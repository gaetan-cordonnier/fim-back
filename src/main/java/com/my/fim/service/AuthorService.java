package com.my.fim.service;

import com.my.fim.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto createAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthor();

    AuthorDto getAuthorById(Long id);

    AuthorDto updateAuthorById(AuthorDto authorDto, Long id);

    void deleteAuthorById(Long id);
}
