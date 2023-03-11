package com.atos.oatoo.models;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

// Model type_contrat
@Entity
@Table(name = "pibs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pib {

  // Generation de id
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // propriété sumvalues_added non null  pour la somme des valeurs ajoutées
  private Number sumvalues_added;

  // propriété vat non null  pour la TVA
  private Number vat;

  // propriété duties_taxes non null
  private Number duties_taxes;

  // propriété subsidies_product non null
  private Number subsidies_product;

  // propriété subsidies_product non null
  private Number net_pib;

  // created_at et updated_at pour les dates d'ajout et de modification
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, columnDefinition = "timestamp")
  private Date created_at;

  @CreationTimestamp
  @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp")
  private Date updated_at;
}
