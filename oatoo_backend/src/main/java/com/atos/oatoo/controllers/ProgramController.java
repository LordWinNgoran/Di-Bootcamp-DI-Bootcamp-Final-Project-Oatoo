package com.atos.oatoo.controllers;

import com.atos.oatoo.models.Programs;
import com.atos.oatoo.repository.PorgramsRepository;
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
@RequestMapping("/api/programs")
public class ProgramController {
    
    @Autowired
    private PorgramsRepository porgramsRepository;
  
    @GetMapping
    public ResponseEntity<?> find() {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      List<Programs> programs = (List<Programs>) porgramsRepository.findAll();
      try {
        if (!programs.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", programs);
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No program found");
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
      Optional<Programs> programs = porgramsRepository.findById(id);
      try {
        if (!programs.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", programs);
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No program found");
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
    public ResponseEntity<?> save(@Validated @RequestBody Programs programs) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      porgramsRepository.save(programs);
      map.put("status", 201);
      map.put("message", "Program is Saved Successfully!");
      map.put("data", programs);
      return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
      @PathVariable(value = "id") long id,
      @RequestBody Programs programdetail
    ) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      Optional<Programs> programs = porgramsRepository.findById(id);
      try {
        if (!programs.isEmpty()) {
            programs.get().setProgram_name(programdetail.getProgram_name());
            programs.get().setDesc_program(programdetail.getDesc_program());
            programs.get().setPhoto_program(programdetail.getPhoto_program());
            programs.get().setStart_date(programdetail.getStart_date());
            programs.get().setEnd_date(programdetail.getEnd_date());
            programs.get().setProgram_places(programdetail.getProgram_places());

          Date update = new Date();
          programs.get().setUpdated_at(update);
          porgramsRepository.save(programs.get());
          map.put("status", 200);
          map.put("message", "Program is modified successfully!");
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No company found");
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
      Optional<Programs> programs = porgramsRepository.findById(id);
      try {
        if (!programs.isEmpty()) {
            porgramsRepository.deleteById(id);
          map.put("status", 200);
          map.put("message", "Program is deleted successfully!");
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No company found");
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
  