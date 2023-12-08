package com.junrestwebservice.restfulsnsproject.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }


    @GetMapping
    // 모든 사용자 조회
    public List<User> retriveAllusers(){
        return userDaoService.findAll();
    }

    @GetMapping(value = "/{id}")
    // 특정 유저만 조회
    public User retriveUser(@PathVariable Integer id){
        User user = userDaoService.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id" + id);
        return user;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    // 특정 유저만 조회
    public void deleteUser(@PathVariable Integer id){
        userDaoService.deleteById(id);
    }

}
