package com.atos.oatoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

// Model type_contrat
@Entity
@Table(name = "programs")
@Getter
@Setter
public class Programs {

  // Generation de id
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // propriété program_name non null
  @NotNull(message = "Le champ nom du programme est obligatoire")
  @NotBlank(message = "Le champ nom du programme ne peut être vide")
  private String program_name;

  // propriété desc_program not null;
  @NotNull(message = "Le champ description du programme est obligatoire")
  @NotBlank(message = "Le champ description du programme ne peut être vide")
  private String desc_program;

  // propriété photo_program
  @Lob
  private String photo_program;

  // propriété start_date not null;
  @NotNull(message = "Le champ date de début du programme est obligatoire")
  @NotBlank(message = "Le champ date de début du programme ne peut être vide")
  private Date start_date;

  // propriété end_date not null;
  @NotNull(message = "Le champ date de fin du programme est obligatoire")
  @NotBlank(message = "Le champ date de fin du programme ne peut être vide")
  private Date end_date;

  // propriété program_places not null;
  @NotNull(message = "Le champ nombre de places est obligatoire")
  private Number program_places;

  // propriété program_state not null a la creation status= L apres D disponible et T Terminé;
  @NotNull(message = "Le champ état du programme est obligatoire")
  private char program_state;

  // created_at et updated_at pour les dates d'ajout et de modification
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, columnDefinition = "timestamp")
  private Date created_at;

  @CreationTimestamp
  @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp")
  private Date updated_at;

  // jointure unidirectionnelle de  la classe Inscription_program avec la classe Unemployed_workers
  @OneToMany(
    targetEntity = Inscription_program.class,
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  @JoinColumn(name = "programs_fk", referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  @JsonIgnore
  private List<Inscription_program> inscription_programs;
}
