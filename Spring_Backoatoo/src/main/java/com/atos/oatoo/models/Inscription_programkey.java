package com.atos.oatoo.models;


import javax.persistence.*;

import java.io.Serializable;

@Embeddable
public class Inscription_programkey implements Serializable {

    private static final long serialVersionUID = -7275079872834495736L;

  @Column(name="program_id")
  private Integer program_id;
  @Column(name="unemployed_id")
  private Integer unemployed_id;
    
}
