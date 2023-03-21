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
    MultipartFile companie_logo,
    String register_number,
    String companie_name,
    String companie_regime,
    String companie_field,
    String companie_location,
    String companie_email,
    int companie_size,
    double annual_revenue,
    String companie_phone,
    String web_site,
    String account_state
  ) {
    Companies p = new Companies();
    String fileName = StringUtils.cleanPath(
      companie_logo.getOriginalFilename()
    );
    if (fileName.contains("..")) {
      System.out.println("not a a valid file");
    }
    try {
      p.setCompanie_logo(Base64.getEncoder().encodeToString(companie_logo.getBytes()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    p.setRegister_number(register_number);
    p.setCompanie_name(companie_name);
    p.setCompanie_regime(companie_regime);
    p.setCompanie_field(companie_field);
    p.setCompanie_location(companie_location);
    p.setCompanie_email(companie_email);
    p.setCompanie_size(companie_size);
    p.setAnnual_revenue(annual_revenue);
    p.setCompany_phone(companie_phone);
    p.setWeb_site(web_site);
    p.setAccount_state(account_state);
    companiesRepository.save(p);
  }
}
