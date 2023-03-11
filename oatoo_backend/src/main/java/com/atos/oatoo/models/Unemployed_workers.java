package com.atos.oatoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "unemployed_workers")
@Getter
@Setter
public class Unemployed_workers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // propriété unemployed_firstname = nom non null
  @NotNull(message = "Le champ nom est obligatoire")
  @NotBlank(message = "Le champ nom ne peut être vide")
  @Column(length = 25)
  private String unemployed_firstname;

  // propriété unemployed_lastname = prenoms non null
  @NotNull(message = "Le champ prénoms est obligatoire")
  @NotBlank(message = "Le champ prénoms ne peut être vide")
  @Column(length = 100)
  private String unemployed_lastname;

  // propriété unemployed_mail non null
  @NotNull(message = "Le champ email est obligatoire")
  @NotBlank(message = "Le champ email ne peut être vide")
  @Column(length = 25, unique = true)
  private String unemployed_mail;

  // propriété unemployed_phone non null
  @NotNull(message = "Le champ téléphone est obligatoire")
  @NotBlank(message = "Le champ téléphone ne peut être vide")
  @Column(length = 25, unique = true)
  private String unemployed_phone;

  // propriété unemployed_birthdate non null
  @NotNull(message = "Le champ date de naissance est obligatoire")
  @NotBlank(message = "Le champ date de naissance ne peut être vide")
  private Date unemployed_birthdate;

  // propriété unemployed_birthplace non null
  @NotNull(message = "Le champ lieu de naissance est obligatoire")
  @NotBlank(message = "Le champ lieu de naissance ne peut être vide")
  @Column(length = 25)
  private String unemployed_birthplace;

  // propriété unemployed_bloodtype
  private char unemployed_bloodtype;

  // propriété unemployed_partnumber non null
  @NotNull(message = "Le champ numéro de la pièce est obligatoire")
  @NotBlank(message = "Le champ numéro de la pièce ne peut être vide")
  @Column(length = 25)
  private String unemployed_partnumber;

  // propriété unemployed_goals
  @Lob
  private String unemployed_goals;

  // propriété unemployed_like pour le nombre de points obtenus pour des formations , son comportement, les bonnes actions etc
  private Number unemployed_points = 0;

  // propriété unemployed_level non null
  @NotNull(message = "Le champ niveau actuel est obligatoire")
  @NotBlank(message = "Le champ niveau actuel ne peut être vide")
  @Column(length = 25)
  private String unemployed_level;

  // propriété unemployed_state par défaut toute creation d'un chômeur prend le statut C
  private char unemployed_state = 'C';

  // propriété unemployed_cv si disponible --- aucun candidat ne pourra postuler sans cv
  @Column(length = 100)
  private String unemployed_cv;

  // propriété unemployed_img si disponible ---
  @Column(length = 100)
  private String unemployed_img;

  // propriété unemployed_unique non null
  // unemployed_unique est généré à partir du nom et la concatenation avec la date  et l'id généré

  Date date = new Date();
  SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");

  private String unemployed_unique =
    unemployed_firstname + '-' + formatter + '.' + id;

  // created_at et updated_at pour les dates d'ajout et de modification
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, columnDefinition = "timestamp")
  private Date created_at;

  @CreationTimestamp
  @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp")
  private Date updated_at;

  // jointure unidirectionnelle de  la classe Unemployed_workers avec la classe Contracts
  @OneToMany(
    mappedBy = "unemployed_worker",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  @JsonIgnore
  private List<Inscription_program> bookCategories;

  // jointure unidirectionnelle de  la classe Inscription_program avec la classe Unemployed_workers
  @OneToMany(
    targetEntity = Inscription_program.class,
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  @JoinColumn(name = "unemployed_workers_fk", referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  @JsonIgnore
  private List<Inscription_program> inscription_programs;
}
