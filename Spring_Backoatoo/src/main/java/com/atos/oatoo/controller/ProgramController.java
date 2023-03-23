package com.atos.oatoo.controller;

import com.atos.oatoo.models.Programs;
import com.atos.oatoo.repository.PorgramsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import org.springframework.web.multipart.MultipartFile;
import com.atos.oatoo.service.ProgramService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/programs")
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
  /* public ResponseEntity<?> save(@Validated @RequestBody Companies card_types) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    companiesRepository.save(card_types);
    map.put("status", 201);
    map.put("message", "Company is Saved Successfully!");
    map.put("data", card_types);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
  } */

  public ResponseEntity<?> saveProgram(
    		@RequestParam("program_name") String program_name,
        @RequestParam("desc_program") String desc_program,
        @RequestParam("start_date") String start_date,
        @RequestParam("end_date") String end_date,
        @RequestParam("program_places") String program_places,
        @RequestParam("program_state") char program_state,
    		@RequestParam("companie_fk") String companie_fk,
        @RequestParam("photo_program") MultipartFile photo_program
        ) throws ParseException
    {
      int places = Integer.parseInt(program_places);
      int fk_companie = Integer.parseInt(companie_fk);

      Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(start_date); 
      Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end_date); 
      
    	ProgramService.saveProgramToDB(program_name,desc_program,date1,date2,places,
      program_state,fk_companie,photo_program);
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      map.put("status", 201);
      map.put("message", "Company is Saved Successfully!");
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
  