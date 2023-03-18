package com.atos.oatoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "inscription_programs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscription_program {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // propriété unemployed_mail non null
  @NotNull(message = "Le champ consentement est obligatoire")
  private boolean approval;

  // propriété inscription_state non null  prend la valeur En vérification sinon validé ou annulé
  @NotNull(message = "Le champ état de l'inscription est obligatoire")
  @NotBlank(message = "Le champ état de l'inscription ne peut être vide")
  private String inscription_state;

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

}
