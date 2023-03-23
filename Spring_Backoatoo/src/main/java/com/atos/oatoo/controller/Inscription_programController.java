package com.atos.oatoo.controller;

import com.atos.oatoo.models.Inscription_program;
import com.atos.oatoo.repository.Inscription_programRepository;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/inscriptions")
public class Inscription_programController {

  @Autowired
  private Inscription_programRepository inscription_programRepository;

  @GetMapping
  public ResponseEntity<?> find() {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Inscription_program> inscription_programs = (List<Inscription_program>) inscription_programRepository.findAll();
    try {
      if (!inscription_programs.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", inscription_programs);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No inscription found");
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
    Optional<Inscription_program> inscription_programs = inscription_programRepository.findById(
      id
    );
    try {
      if (!inscription_programs.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", inscription_programs);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No inscription found");
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
  public ResponseEntity<?> save(
    @Validated @RequestBody Inscription_program inscription_programs
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    inscription_programRepository.save(inscription_programs);
    map.put("status", 201);
    map.put("message", "Inscription is Saved Successfully!");
    map.put("data", inscription_programs);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable(value = "id") long id,
    @RequestBody Inscription_program inscription_detail
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Inscription_program> inscription_programs = inscription_programRepository.findById(
      id
    );
    try {
      if (!inscription_programs.isEmpty()) {
        inscription_programs.get().setApproval(inscription_detail.isApproval());
        Date update = new Date();
        inscription_programs.get().setUpdated_at(update);
        inscription_programRepository.save(inscription_programs.get());
        map.put("status", 200);
        map.put("message", "Inscription is modified successfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No inscription found");
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
  public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Inscription_program> inscription_programs = inscription_programRepository.findById(
      id
    );
    try {
      if (!inscription_programs.isEmpty()) {
        inscription_programRepository.deleteById(id);
        map.put("status", 200);
        map.put("message", "Inscription is deleted successfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No inscription found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 500);
      map.put("message", "internal error is not found");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }
}
