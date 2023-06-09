package com.atos.oatoo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // propriété register_number non null 
   @NotNull(message = "Le champ numéro du registre est obligatoire")
   @NotBlank(message = "Le champ numéro du registre ne peut être vide")
   @Column(length=25, unique = true)
   private String register_number;

   // propriété libelle_type_contrat non null 
   @NotNull(message = "Le champ libellé du type de contrat est obligatoire")
   @NotBlank(message = "Le champ libellé ne peut être vide")
   @Column(length=25, unique = true)
   private String companie_name;



   // propriété companie_regime non null 
   @NotNull(message = "Le champ régime de l'entreprise est obligatoire")
   @NotBlank(message = "Le champ régime de l'entreprise ne peut être vide")
   @Column(length=25)
   private String companie_regime;

    // propriété companie_field non null 
   @NotNull(message = "Le champ domaine d'activité est obligatoire")
   @NotBlank(message = "Le champ domaine d'activité ne peut être vide")
   @Column(length=25)
   private String companie_field;



    // propriété companie_email non null 
   @NotNull(message = "Le champ email  est obligatoire")
   @NotBlank(message = "Le champ email ne peut être vide")
   @Column(length=25,unique = true)
   private String companie_email;

    // propriété companie_logo 
   @Lob
	private String companie_logo;


   // propriété companie_location non null 
   @NotNull(message = "Le champ emplacement géographique  est obligatoire")
   @NotBlank(message = "Le champ emplacement géographique ne peut être vide")
   private String companie_location;
   

   // propriété companie_size non null  
   @NotNull(message = "Le champ taille de l'entreprise est obligatoire")
   private int companie_size;



   // propriété annual_revenue non null le chiffre annuel de l'entreprise
   @NotNull(message = "Le champ chiffre d'affaires annuel est obligatoire")
   private Double annual_revenue;


   // propriété numéro de téléphone est non null
   @NotNull(message = "Le champ numéro de téléphone est obligatoire")
   @NotBlank(message = "Le champ numéro de téléphone ne peut être vide")
   private String company_phone;


   // propriété web_site non null 
   @NotNull(message = "Le champ web est obligatoire")
   @NotBlank(message = "Le champ emplacement géographique ne peut être vide")
   private String web_site;


   
   @NotNull(message = "Le champ user_fk est obligatoire")
   private int user_fk;

   // propriété account_state par défaut Vérification sinon actif ou inactif 
   @NotNull(message = "Le champ état du compte est obligatoire")
   @NotBlank(message = "Le champ état du compte  ne peut être vide")
   private String account_state;
   

    // created_at et updated_at pour les dates d'ajout et de modification
    @CreationTimestamp
    @Column(name="created_at",nullable = false, columnDefinition="timestamp")
    private Date created_at;
    @CreationTimestamp
    @Column(name="updated_at",nullable = false, columnDefinition="timestamp")
    private Date updated_at;

  // jointure unidirectionnelle de  la classe Card_type avec la classe Unemployed_workers
  @OneToMany(targetEntity = Programs.class, cascade = CascadeType.ALL)
  @JoinColumn (name = "companie_fk",referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  @JsonIgnore()
  private List<Programs> programs;

  
}
