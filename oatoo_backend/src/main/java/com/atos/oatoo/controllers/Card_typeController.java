package com.atos.oatoo.controllers;

import com.atos.oatoo.models.Card_type;
import com.atos.oatoo.repository.Card_typeRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card_types")
public class Card_typeController {

  @Autowired
  private Card_typeRepository card_typeRepository;

  @GetMapping
  public ResponseEntity<?> find() {
    JSONObject jsonObject;
    JSONArray jsonArray = new JSONArray();
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Card_type> card_type = (List<Card_type>) card_typeRepository.findAll();
    try {
      if (!card_type.isEmpty()) {
        map.put("status", 200);
      map.put("message", "Data found");
      for (Card_type carType : card_typeRepository.findAll()) {
        jsonObject = new JSONObject();
        jsonObject.put("id", carType.getId());
        jsonObject.put("description", carType.getDesc_card_type());
        jsonArray.put(jsonObject);
      }
      map.put("data", jsonArray.toList());
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

  /*@GetMapping
  public String findEze() {
    JSONObject jsonObject;
    JSONArray jsonArray = new JSONArray();
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Card_type> card_type = (List<Card_type>) card_typeRepository.findAll();
    if (!card_type.isEmpty()) {
      map.put("status", 200);
      map.put("message", "Data found");
      for (Card_type carType : card_typeRepository.findAll()) {
        jsonObject = new JSONObject();
        jsonObject.put("id", carType.getId());
        jsonObject.put("description", carType.getDesc_card_type());
        jsonArray.put(jsonObject);
      }
      map.put("data", jsonArray);
    }
    return jsonArray.toString();
    
  }*/

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable(value = "id") long id) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Card_type> card_types = card_typeRepository.findById(id);
    try {
      if (!card_types.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", card_types);
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
  public ResponseEntity<?> save(@Validated @RequestBody Card_type card_types) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    card_typeRepository.save(card_types);
    map.put("status", 201);
    map.put("message", "Card type is Saved Successfully!");
    map.put("data", card_types);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable(value = "id") long id,
    @RequestBody Card_type card_typedetail
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Card_type> card_types = card_typeRepository.findById(id);
    try {
      if (!card_types.isEmpty()) {
        card_types.get().setDesc_card_type(card_typedetail.getDesc_card_type());
        Date update = new Date();
        card_types.get().setUpdated_at(update);
        card_typeRepository.save(card_types.get());
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
    Optional<Card_type> card_types = card_typeRepository.findById(id);
    try {
      if (!card_types.isEmpty()) {
        card_typeRepository.deleteById(id);
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
