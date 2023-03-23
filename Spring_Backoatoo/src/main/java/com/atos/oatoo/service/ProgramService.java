package com.atos.oatoo.service;

import com.atos.oatoo.models.Programs;
import com.atos.oatoo.repository.PorgramsRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProgramService {
    
    @Autowired
    private static PorgramsRepository porgramsRepository;
  
    public static void saveProgramToDB(
      String program_name,
      String desc_program,
      Date start_date,
      Date end_date,
      int places,
      char program_state ,
      int fk_companie,
      MultipartFile photo_program
    ) {
      Programs p = new Programs();
      String fileName = StringUtils.cleanPath(
        photo_program.getOriginalFilename()
      );
     
      p.setPhoto_program(program_name);
      p.setDesc_program(desc_program);
      p.setStart_date(start_date);
      p.setEnd_date(end_date);
      p.setProgram_places(places);
      p.setProgram_state(program_state);
      if (fileName.contains("..")) {
        System.out.println("not a a valid file");
      }
      try {
        p.setPhoto_program(Base64.getEncoder().encodeToString(photo_program.getBytes()));
      } catch (IOException e) {
        e.printStackTrace();
      }
      porgramsRepository.save(p);
    }

   
  }
  
