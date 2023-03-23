package com.atos.oatoo.service;

import com.atos.oatoo.models.Companies;
import com.atos.oatoo.repository.CompaniesRepository;
import java.io.IOException;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyService {

  @Autowired
  private CompaniesRepository companiesRepository;

  public void saveProductToDB(
    String register_number,
    String companie_name,
    String companie_regime,
    String companie_field,
    String companie_email ,
    String companie_location,
    int companie_size,
    double annual_revenue,
    String companie_phone,
    String web_site,
    int user_fk,
    String account_state,
    MultipartFile companie_logo
  ) {
    Companies p = new Companies();
    String fileName = StringUtils.cleanPath(
      companie_logo.getOriginalFilename()
    );
   
    p.setRegister_number(register_number);
    p.setCompanie_name(companie_name);
    p.setCompanie_regime(companie_regime);
    p.setCompanie_field(companie_field);
    p.setCompanie_email(companie_email);
    p.setCompanie_location(companie_location);
    p.setCompanie_size(companie_size);
    p.setAnnual_revenue(annual_revenue);
    p.setCompany_phone(companie_phone);
    p.setWeb_site(web_site);
    p.setUser_fk(user_fk);
    p.setAccount_state(account_state);
    if (fileName.contains("..")) {
      System.out.println("not a a valid file");
    }
    try {
      p.setCompanie_logo(Base64.getEncoder().encodeToString(companie_logo.getBytes()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    companiesRepository.save(p);
  }
}
