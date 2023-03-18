package com.atos.oatoo.controller;

import com.atos.oatoo.models.Year;
import com.atos.oatoo.repository.YearRepository;
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
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/year")
public class YearController {
  @Autowired
  private YearRepository yearRepository;

  @GetMapping
  public ResponseEntity<?> getContract_types() {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Year> years = (List<Year>) yearRepository.findAll();
    try {
      if (!years.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", years);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 200);
        map.put("message", "No year found");
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
    Optional<Year> years = yearRepository.findById(id);
    try {
      if (!years.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", years);
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

  @PostMapping()
  public ResponseEntity<?> save(@Validated @RequestBody Year years) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    yearRepository.save(years);
    map.put("status", 201);
    map.put("message", "Year is Saved Successfully!");
    map.put("data", years);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable(value = "id") long id,
    @RequestBody Year yeardetail
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Year> years = yearRepository.findById(id);
    try {
      if (!years.isEmpty()) {
        years.get().setYear(yeardetail.getYear());
        Date update = new Date();
        years.get().setUpdated_at(update);
        yearRepository.save(years.get());
        map.put("status", 200);
        map.put("message", "Year is modified successfully!");
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
    Optional<Year> years = yearRepository.findById(id);
    try {
      if (!years.isEmpty()) {
        yearRepository.deleteById(id);
        map.put("status", 200);
        map.put("message", "Year is deleted successfully!");
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
