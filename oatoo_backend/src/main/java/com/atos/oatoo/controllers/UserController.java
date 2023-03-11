package com.atos.oatoo.controllers;

import com.atos.oatoo.models.User;
import com.atos.oatoo.repository.UserRepository;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public ResponseEntity<?> getContract_types() {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<User> users = (List<User>) userRepository.findAll();
    try {
      if (!users.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", users);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 200);
        map.put("message", "No user found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 400);
      map.put("message", "<Error>");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable(value = "id") long id) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<User> users = userRepository.findById(id);
    try {
      if (!users.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", users);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 400);
      map.put("message", "<Error>");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<?> save(@Validated @RequestBody User users) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    userRepository.save(users);
    map.put("status", 201);
    map.put("message", "User is Saved Successfully!");
    map.put("data", users);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable(value = "id") long id,
    @RequestBody User userdetail
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<User> users = userRepository.findById(id);
    try {
      if (!users.isEmpty()) {
        users.get().setUsername(userdetail.getUsername());
        users.get().setEmail(userdetail.getEmail());
        users.get().setPassword(userdetail.getPassword());
        users.get().setRole(userdetail.getRole());
        Date update = new Date();
        users.get().setUpdated_at(update);
        userRepository.save(users.get());
        map.put("status", 200);
        map.put("message", "User is modified successfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 404);
      map.put("message", "Data is not found");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable(value = "id") long id) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<User> users = userRepository.findById(id);
    try {
      if (!users.isEmpty()) {
        userRepository.deleteById(id);
        map.put("status", 200);
        map.put("message", "User is deleted successfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 0);
      map.put("message", "Data is not found");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }
}
