package com.atos.oatoo.controller;

import com.atos.oatoo.models.Companies;
import com.atos.oatoo.repository.CompaniesRepository;
import com.atos.oatoo.service.CompanyService;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/companies")
public class CompanieController {

  @Autowired
  private CompaniesRepository companiesRepository;

  @Autowired
	private CompanyService companyService;

  @GetMapping
  public ResponseEntity<?> find() {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Companies> companies = (List<Companies>) companiesRepository.findAll();
    try {
      if (!companies.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", companies);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No company found");
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
    Optional<Companies> companies = companiesRepository.findById(id);
    try {
      if (!companies.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", companies);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No company found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 400);
      map.put("message", "<Error>");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }



  @GetMapping("/user/{id}")
  public ResponseEntity<?> findByUser(@PathVariable(value = "id") int id) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Companies> companies = companiesRepository.findByUser(id);
    try {

      if (!companies.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", companies);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No company found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      map.clear();
      map.put("status", 400);
      map.put("message", "<Error>");
      return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
  }



  @GetMapping("/companyactive")
  public ResponseEntity<?> findAllCompanyActive() {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    List<Companies> companies = companiesRepository.findAllCompanyActive();
    try {

      if (!companies.isEmpty()) {
        map.put("status", 200);
        map.put("message", "Data found");
        map.put("data", companies);
        return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
        map.clear();
        map.put("status", 404);
        map.put("message", "No company found");
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

  public ResponseEntity<?> saveProduct(
    		@RequestParam("register_number") String register_number,
        @RequestParam("companie_name") String companie_name,
        @RequestParam("companie_regime") String companie_regime,
        @RequestParam("companie_field") String companie_field,
        @RequestParam("companie_email") String companie_email,
        @RequestParam("companie_location") String companie_location,
    		@RequestParam("companie_size") String companie_size,
        @RequestParam("annual_revenue") String annual_revenue,
    		@RequestParam("companie_phone") String companie_phone,
        @RequestParam("web_site") String web_site,
        @RequestParam("user_fk") String user_fk,
        @RequestParam("companie_logo") MultipartFile companie_logo
        )
    {
      int size = Integer.parseInt(companie_size);
      double revenue = Double.valueOf(annual_revenue);
      String acccount_state = "L";
      int id_user =Integer.parseInt(user_fk);
    	companyService.saveProductToDB(register_number,companie_name,companie_regime,companie_field,companie_email,
      companie_location,size,revenue, companie_phone, web_site,id_user,acccount_state,companie_logo);
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      map.put("status", 201);
      map.put("message", "Company is Saved Successfully!");
      return new ResponseEntity<>(map, HttpStatus.CREATED);
    }



  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable(value = "id") long id,
    @RequestBody Companies companydetail
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Companies> companies = companiesRepository.findById(id);
    try {
      if (!companies.isEmpty()) {
        companies.get().setCompanie_name(companydetail.getCompanie_name());
        companies.get().setCompanie_email(companydetail.getCompanie_email());
        companies.get().setRegister_number(companydetail.getRegister_number());
        companies.get().setCompanie_regime(companydetail.getCompanie_regime());
        companies.get().setCompanie_field(companydetail.getCompanie_field());
        companies.get().setCompanie_email(companydetail.getCompanie_email());
        companies.get().setCompanie_logo(companydetail.getCompanie_logo());
        companies
          .get()
          .setCompanie_location(companydetail.getCompanie_location());

        Date update = new Date();
        companies.get().setUpdated_at(update);
        companiesRepository.save(companies.get());
        map.put("status", 200);
        map.put("message", "Company is modified successfully!");
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



  @PutMapping("/activeAccount/{id}")
  public ResponseEntity<?> updateAccount(
    @PathVariable(value = "id") long id
  ) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    companiesRepository.UpdateCompanyAccount(id);
        map.put("status", 200);
        map.put("message", "Account is modified successfully!");
        return new ResponseEntity<>(map, HttpStatus.OK);
      
  }



  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Optional<Companies> companies = companiesRepository.findById(id);
    try {
      if (!companies.isEmpty()) {
        companiesRepository.deleteById(id);
        map.put("status", 200);
        map.put("message", "Company is deleted successfully!");
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
