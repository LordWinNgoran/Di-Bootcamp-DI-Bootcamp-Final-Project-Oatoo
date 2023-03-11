package com.atos.oatoo.controllers;

import com.atos.oatoo.models.Contracts;
import com.atos.oatoo.repository.ContractsRepository;

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
@RequestMapping("/api/contracts")
public class ContractController {
    
 
    @Autowired
    private ContractsRepository contractsRepository;
  
    @GetMapping
    public ResponseEntity<?> getContract_types() {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      List<Contracts> contracts = (List<Contracts>) contractsRepository.findAll();
      try {
        if (!contracts.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", contracts);
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
      Optional<Contracts> contracts = contractsRepository.findById(id);
      try {
        if (!contracts.isEmpty()) {
          map.put("status", 200);
          map.put("message", "Data found");
          map.put("data", contracts);
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
    public ResponseEntity<?> save(@Validated @RequestBody Contracts contracts) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      contractsRepository.save(contracts);
      map.put("status", 201);
      map.put("message", "Contract is Saved Successfully!");
      map.put("data", contracts);
      return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") long id, @RequestBody Contracts contract_detail) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      Optional<Contracts> contracts = contractsRepository.findById(id);
      try {
        if (!contracts.isEmpty()) {
            contracts.get().setCnps_number(contract_detail.getCnps_number());
            contracts.get().setGross_salary(contract_detail.getGross_salary());
            contracts.get().setNet_salary(contract_detail.getNet_salary());
            contracts.get().setSalary_tax(contract_detail.getSalary_tax());
            contracts.get().setCn(contract_detail.getCn());
            contracts.get().setIgr(contract_detail.getIgr());
            contracts.get().setCnps(contract_detail.getCnps());
            contracts.get().setTotal_tax(contract_detail.getTotal_tax());
            contracts.get().setPeriod(contract_detail.getPeriod());
          Date update = new Date();
          contracts.get().setUpdated_at(update);
          contractsRepository.save(contracts.get());
          map.put("status", 200);
          map.put("message", "Card is modified successfully!");
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
      Optional<Contracts> contracts = contractsRepository.findById(id);
      try {
        if (!contracts.isEmpty()) {
            contractsRepository.deleteById(id);
          map.put("status", 200);
          map.put("message", "Card is deleted successfully!");
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
