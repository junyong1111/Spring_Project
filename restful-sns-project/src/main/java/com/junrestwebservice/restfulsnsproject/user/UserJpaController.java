package com.junrestwebservice.restfulsnsproject.user;

import com.junrestwebservice.restfulsnsproject.posts.Post;
import com.junrestwebservice.restfulsnsproject.posts.PostRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jpa/users")
public class UserJpaController {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaController(UserRepository repository, PostRepository postRepository) {
        this.userRepository = repository;
        this.postRepository = postRepository;
    }


    @GetMapping
    // 모든 사용자 조회
    public List<User> retriveAllusers(){

        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    // 특정 유저만 조회
    public EntityModel<User> retriveUser(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id" + id);
        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllusers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    // 특정 유저만 조회
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping(value = "/{id}/posts")
    public List<Post> retrivePostsforUser(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id" + id);
        return user.get().getPosts();
    }

    @PostMapping(value = "/{id}/posts")
    public ResponseEntity<Object> createPostsforUser(@PathVariable("id") Integer id, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id" + id);
        post.setUser(user.get());
        Post savedPose = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPose.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
