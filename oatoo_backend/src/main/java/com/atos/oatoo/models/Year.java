package com.atos.oatoo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


// Model Year

@Entity
@Table(name = "years")
// Creation automatique des setters et getters
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // propriété libelle_type_contrat non null 
    @NotNull(message = "Le champ année est obligatoire")
    //@NotBlank(message = "Le champ année ne peut être vide")
    @Column(unique = true)
    private Integer year;
  
   // created_at et updated_at pour les dates d'ajout et de modification
   @CreationTimestamp
   @Column(name="created_at",nullable = false, columnDefinition="timestamp")
   private Date created_at;
   @CreationTimestamp
   @Column(name="updated_at",nullable = false, columnDefinition="timestamp")
   private Date updated_at;
    //jointure unidirectionnelle de  la classe Card_type avec la classe Unemployed_workers
  @OneToMany(targetEntity = Pib.class, cascade = CascadeType.ALL)
  @JoinColumn (name = "year_fk",referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  private List<Pib> pib;
}
