
package com.atos.oatoo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
// Model type_contrat
@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contracts {
      // Generation de id 
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;


      // propriété cnps_number non null numéro cnps
      @NotNull(message = "Le champ numéro cnps du type de contrat est obligatoire")
      @NotBlank(message = "Le champ numéro cnps ne peut être vide")
      @Column(unique = true)
      private String cnps_number;
  
      // propriété gross_salary non null 
      @NotNull(message = "Le champ salaire brut du type de contrat est obligatoire")
      private Double gross_salary;

      // propriété net_salary non null 
      @NotNull(message = "Le champ salaire net du type de contrat est obligatoire")
      private Double net_salary;



      // propriété post non null 
      @NotNull(message = "Le champ post net du type de contrat est obligatoire")
      private String post;


       // propriété desc_post non null 
       @NotNull(message = "Le champ podesc_postst net du type de contrat est obligatoire")
       private String desc_post;

      

      // propriété is non null  impôt sur salaire est exprimer en pourcentage 10% soit 0,1
      @NotNull(message = "Le champ impôt sur salaire est obligatoire")
      private Double salary_tax;

      // propriété cn non null cotisation nationale est exprimer en pourcentage 10% soit 0,1
      @NotNull(message = "Le champ cotisation nationale est obligatoire")
      @NotBlank(message = "Le champ cotisation nationale ne peut être vide")
      private Double cn;


       // propriété igr non null  impôt sur salaire est exprimer en pourcentage 10% soit 0,1
       @NotNull(message = "Le champ impôt sur le revenu géneral est obligatoire")
       private Double igr;
 
       // propriété cnps non null cotisation sociale cnps est exprimer en pourcentage 10% soit 0,1
       @NotNull(message = "Le champ cotisation sociale cnps est obligatoire")
       private Double cnps;


        // propriété total_tax non null la somme de toutes les taxes
        @NotNull(message = "Le champ cotisation sociale cnps est obligatoire")
        private Double total_tax;

      // propriété period non null exprimé en mois et peut être vide si le contrat est un CDI 
      @NotNull(message = "Le champ periode est obligatoire")
      private Number period;
    
      // created_at et updated_at pour les dates d'ajout et de modification
    @CreationTimestamp
    @Column(name="created_at",nullable = false, columnDefinition="timestamp")
    private Date created_at;
    @CreationTimestamp
    @Column(name="updated_at",nullable = false, columnDefinition="timestamp")
    private Date updated_at;

    
}
