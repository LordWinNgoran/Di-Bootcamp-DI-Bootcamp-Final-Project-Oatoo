package com.atos.oatoo.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "inscription_programs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscription_program {
    
  @EmbeddedId
  private Inscription_programkey id;

  @ManyToOne()
  @MapsId("unemployedId")
  @JoinColumn(name="unemployed_id")
  private Unemployed_workers unemployed_worker;



  @ManyToOne()
  @MapsId("programId")
  @JoinColumn(name="program_id")
  private Programs program;


  // propriété unemployed_mail non null 
  @NotNull(message = "Le champ consentement est obligatoire")
  @NotBlank(message = "Le champ consentement ne peut être vide")
  private boolean approval;

  // propriété notes La note 
  private Double notes;

  private boolean give_work;
 // created_at et updated_at pour les dates d'ajout et de modification
 @CreationTimestamp
 @Column(name = "created_at", nullable = false, columnDefinition = "timestamp")
 private Date created_at;

 @CreationTimestamp
 @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp")
 private Date updated_at;


 //jointure unidirectionnelle de  la classe Card_type avec la classe Unemployed_workers
 @OneToMany(targetEntity = Contracts.class, cascade = CascadeType.ALL)
 @JoinColumns({
  @JoinColumn(name = "unemployed_id",referencedColumnName = "unemployed_id"),
  @JoinColumn(name = "program_id", referencedColumnName = "program_id")
})
 //  @JsonIgnore() permet de ne pas retouner les données des enfants
 @JsonIgnore()
 private List<Contracts> contracts;

}
