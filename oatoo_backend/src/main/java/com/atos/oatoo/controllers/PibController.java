package com.atos.oatoo.controllers;

import com.atos.oatoo.models.Pib;
import com.atos.oatoo.repository.PibRepository;
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
@RequestMapping("/api/pib")
public class PibController {
    
    @Autowired
    private PibRepository pibRepository;
  
    @GetMapping
    public ResponseEntity<?> find() {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      List<Pib> pibs = (List<Pib>) pibRepository.findAll();
      try {
        if (!pibs.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", pibs);
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No pib found");
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
      Optional<Pib> pibs = pibRepository.findById(
        id
      );
      try {
        if (!pibs.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", pibs);
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No pib found");
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
      @Validated @RequestBody Pib pibs
    ) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      pibRepository.save(pibs);
      map.put("status", 201);
      map.put("message", "Pib is Saved Successfully!");
      map.put("data", pibs);
      return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
      @PathVariable(value = "id") long id,
      @RequestBody Pib pib_detail
    ) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      Optional<Pib> pibs = pibRepository.findById(
        id
      );
      try {
        if (!pibs.isEmpty()) {
            pibs.get().setSumvalues_added(pib_detail.getSumvalues_added());
            pibs.get().setVat(pib_detail.getVat());
            pibs.get().setDuties_taxes(pib_detail.getDuties_taxes());
            pibs.get().setSubsidies_product(pib_detail.getSubsidies_product());
            pibs.get().setNet_pib(pib_detail.getNet_pib());
          Date update = new Date();
          pibs.get().setUpdated_at(update);
          pibRepository.save(pibs.get());
          map.put("status", 200);
          map.put("message", "Pib is modified successfully!");
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No pib found");
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
      Optional<Pib> pibs = pibRepository.findById(
        id
      );
      try {
        if (!pibs.isEmpty()) {
            pibRepository.deleteById(id);
          map.put("status", 200);
          map.put("message", "Pib is deleted successfully!");
          return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
          map.clear();
          map.put("status", 404);
          map.put("message", "No pib found");
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
  
