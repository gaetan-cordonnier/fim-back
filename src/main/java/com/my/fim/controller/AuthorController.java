package com.my.fim.controller;

import com.my.fim.dto.AuthorDto;
import com.my.fim.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/")
    public ResponseEntity<List<AuthorDto>> getAllAuthor() {
        return new ResponseEntity<>(authorService.getAllAuthor(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AuthorDto> updateAuthorById(@RequestBody AuthorDto authorDto, @PathVariable("id") Long authorId) {
        AuthorDto response = authorService.updateAuthorById(authorDto, authorId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<String> deleteAuthorById(@PathVariable("id") Long authorId) {
        authorService.deleteAuthorById(authorId);
        return new ResponseEntity<>("Auteur supprimé", HttpStatus.OK);
    }
}
