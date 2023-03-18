package com.atos.oatoo.controller;


import com.atos.oatoo.models.Unemployed_workers;
import com.atos.oatoo.repository.Unemployed_workersRepository;

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
@RequestMapping("/api/v1/unemployees")
public class Unemployed_workersController {
    @Autowired
    private Unemployed_workersRepository unemployed_workersRepository;
  
    @GetMapping
    public ResponseEntity<?> getContract_types() {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      List<Unemployed_workers> unemployed_workers = (List<Unemployed_workers>) unemployed_workersRepository.findAll();
      try {
        if (!unemployed_workers.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", unemployed_workers);
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No job seekers found");
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
      Optional<Unemployed_workers> unemployed_workers = unemployed_workersRepository.findById(id);
      try {
        if (!unemployed_workers.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", unemployed_workers);
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
    public ResponseEntity<?> save(@Validated @RequestBody Unemployed_workers contract_types) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      unemployed_workersRepository.save(contract_types);
      map.put("status", 201);
      map.put("message", "Job seeker is Saved Successfully!");
      map.put("data", contract_types);
      return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") long id, @RequestBody Unemployed_workers unemployed_detail) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      Optional<Unemployed_workers> unemployed_workers = unemployed_workersRepository.findById(id);
      try {
        if (!unemployed_workers.isEmpty()) {
            unemployed_workers.get().setUnemployed_firstname(unemployed_detail.getUnemployed_firstname());
            unemployed_workers.get().setUnemployed_lastname(unemployed_detail.getUnemployed_lastname());
          Date update = new Date();
          unemployed_workers.get().setUpdated_at(update);

          unemployed_workersRepository.save(unemployed_workers.get());
          map.put("status", 200);
          map.put("message", "Job seeker is modified successfully!");
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
      Optional<Unemployed_workers> unemployed_workers = unemployed_workersRepository.findById(id);
      try {
        if (!unemployed_workers.isEmpty()) {
            unemployed_workersRepository.deleteById(id);
          map.put("status", 200);
          map.put("message", "Job seeker is deleted successfully!");
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
