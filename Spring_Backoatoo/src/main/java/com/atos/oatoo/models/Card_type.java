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
import org.hibernate.annotations.CreationTimestamp;

// Model card_type
@Entity
@Table(name = "card_types")
// Creation automatique des setters et getters
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   // propriété desc_card_type non null 
   @NotNull(message = "Le champ libellé du type de pièce est obligatoire")
   @NotBlank(message = "Le champ libellé du type de pièce ne peut être vide")
   @Column(length=25,unique = true)
   private String desc_card_type;
  
    // created_at et updated_at pour les dates d'ajout et de modification
    @CreationTimestamp
    @Column(name="created_at",nullable = false, columnDefinition="timestamp")
    private Date created_at;
    @CreationTimestamp
    @Column(name="updated_at",nullable = false, columnDefinition="timestamp")
    private Date updated_at;

    // jointure unidirectionnelle de  la classe Card_type avec la classe Unemployed_workers
  @OneToMany(targetEntity = Unemployed_workers.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn (name = "card_type_fk",referencedColumnName = "id")
  //  @JsonIgnore() permet de ne pas retouner les données des enfants
  private List<Unemployed_workers> unemployed_workers;


}
