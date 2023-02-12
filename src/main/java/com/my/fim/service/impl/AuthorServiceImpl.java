package com.my.fim.service.impl;

import com.my.fim.dto.AuthorDto;
import com.my.fim.exceptions.NotFoundExceptionMessage;
import com.my.fim.model.Author;
import com.my.fim.repository.AuthorRepository;
import com.my.fim.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstname(authorDto.getFirstname());
        author.setLastname(authorDto.getLastname());

        Author newAuthor = authorRepository.save(author);

        AuthorDto authorResponse = new AuthorDto();
        authorResponse.setId(newAuthor.getId());
        authorResponse.setFirstname(newAuthor.getFirstname());
        authorResponse.setLastname(newAuthor.getLastname());
        return  authorResponse;
    }
    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> author = authorRepository.findAll();
        return author.stream().map(element -> mapToDto(element)).collect(Collectors.toList());
    }
    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Auteur non trouvé"));
        return mapToDto(author);
    }
    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de mettre à jour l'auteur"));

        author.setFirstname(authorDto.getFirstname());
        author.setLastname(authorDto.getLastname());

        Author updateAuthor = authorRepository.save(author);
        return mapToDto(updateAuthor);
    }
    @Override
    public void deleteAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new NotFoundExceptionMessage("Impossible de supprimer l'auteur"));
        authorRepository.delete(author);
    }
    private AuthorDto mapToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstname(author.getFirstname());
        authorDto.setLastname(author.getLastname());
        return authorDto;
    }
    private Author mapToEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstname(authorDto.getFirstname());
        author.setLastname(authorDto.getLastname());
        return author;
    }
}
