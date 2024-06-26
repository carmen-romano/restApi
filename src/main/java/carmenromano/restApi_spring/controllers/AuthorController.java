package carmenromano.restApi_spring.controllers;

import carmenromano.restApi_spring.entities.Author;
import carmenromano.restApi_spring.entities.Blog;
import carmenromano.restApi_spring.services.AuthorService;
import carmenromano.restApi_spring.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    private List<Author> getAllAuthors(){
        return this.authorService.getAuthorsList();
    }
    @GetMapping("/{authorId}")
    private Author findUserById(@PathVariable int authorId){
        return this.authorService.findById(authorId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    private Author saveAuthor(@RequestBody Author body){
        return this.authorService.saveAuthor(body);
    }
    @PutMapping("/{authorId}")
    private Author findAndUpdateBlog(@PathVariable int authorId, @RequestBody Author body){
        return this.authorService.findAndUpdate(authorId, body);
    }
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAndDeleteBlog(@PathVariable int authorId){
        this.authorService.findAndDelete(authorId);
    }

    ///TEST

    @GetMapping("/nome")
    public Author findByName(@RequestParam String nome){
        return this.authorService.findByName(nome);
    }

}
