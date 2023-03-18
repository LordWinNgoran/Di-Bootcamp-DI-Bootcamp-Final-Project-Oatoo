package com.atos.oatoo.controller;

import com.atos.oatoo.models.Contract_types;
import com.atos.oatoo.repository.Contract_typesRepository;

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
@RequestMapping("/api/v1/contract_types")
public class Contract_typeController {
    
    @Autowired
    private Contract_typesRepository contract_typesRepository;
  
    @GetMapping
    public ResponseEntity<?> getContract_types() {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      List<Contract_types> contract_types = (List<Contract_types>) contract_typesRepository.findAll();
      try {
        if (!contract_types.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", contract_types);
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 200);
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
  
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") long id) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      Optional<Contract_types> contract_types = contract_typesRepository.findById(id);
      try {
        if (!contract_types.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", contract_types);
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
    public ResponseEntity<?> save(@Validated @RequestBody Contract_types contract_types) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      contract_typesRepository.save(contract_types);
      map.put("status", 201);
      map.put("message", "Contract type is Saved Successfully!");
      map.put("data", contract_types);
      return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") long id, @RequestBody Contract_types contract_typedetail) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      Optional<Contract_types> contract_types = contract_typesRepository.findById(id);
      try {
        if (!contract_types.isEmpty()) {
            contract_types.get().setDesc_contract_type(contract_typedetail.getDesc_contract_type());
          Date update = new Date();
          contract_types.get().setUpdated_at(update);
          contract_typesRepository.save(contract_types.get());
          map.put("status", 200);
          map.put("message", "Card type is modified successfully!");
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
      Optional<Contract_types> contract_types = contract_typesRepository.findById(id);
      try {
        if (!contract_types.isEmpty()) {
            contract_typesRepository.deleteById(id);
          map.put("status", 200);
          map.put("message", "Card type is deleted successfully!");
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
