package carmenromano.restApi_spring.controllers;

import carmenromano.restApi_spring.entities.Blog;
import carmenromano.restApi_spring.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    private List<Blog> getAllBlog(){
        return this.blogService.getBlogList();
    }

    @GetMapping("/{blogId}")
    private Blog findUserById(@PathVariable int blogId){
        return this.blogService.findById(blogId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    private Blog saveBlog(@RequestBody Blog body){
        return this.blogService.saveBlog(body);
    }
    @PutMapping("/{blogId}")
        private Blog findAndUpdateBlog(@PathVariable int blogId, @RequestBody Blog body){
        return this.blogService.findByIdAndUpdate(blogId, body);
    }
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAndDeleteBlog(@PathVariable int blogId){
        this.blogService.findByIdAndDelete(blogId);
    }

    ///TEST

    @GetMapping("/readingTime")
    public List<Blog> findByReadingTime(@RequestParam int readingTime){
        return this.blogService.findByReadingTime(readingTime);
    }

}
