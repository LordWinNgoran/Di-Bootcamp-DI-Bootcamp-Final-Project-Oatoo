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
// Model type_contrat
@Entity
@Table(name = "contract_types")
// Creation automatique des setters et getters
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract_types {

    // Generation de id 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // propriété desc_contract_type non null 
    @NotNull(message = "Le champ libellé du type de contrat est obligatoire")
    @NotBlank(message = "Le champ libellé du type de contrat ne peut être vide")
    private String desc_contract_type;
  
     // created_at et updated_at pour les dates d'ajout et de modification
     @CreationTimestamp
     @Column(name="created_at",nullable = false, columnDefinition="timestamp")
     private Date created_at;
     @CreationTimestamp
     @Column(name="updated_at",nullable = false, columnDefinition="timestamp")
     private Date updated_at;

    // jointure unidirectionnelle de  la classe Contract_types avec la classe Contracts
  @OneToMany(targetEntity = Contracts.class, cascade = CascadeType.ALL)
  @JoinColumn (name = "contract_types_fk",referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  @JsonIgnore()
  private List<Contracts> contracts;

}
