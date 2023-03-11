package com.atos.oatoo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Model user
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

  // Generation de id
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // propriété username non null
  @NotNull(message = "Le champ username est obligatoire")
  @NotBlank(message = "Le champ username ne peut être vide")
  private String username;

  // propriété email non null
  @NotNull(message = "Le champ email est obligatoire")
  @NotBlank(message = "Le champ email ne peut être vide")
  private String email;

  // propriété email non null
  @NotNull(message = "Le champ password est obligatoire")
  @NotBlank(message = "Le champ password ne peut être vide")
  private String password;

  // propriété email non null
  @NotNull(message = "Le champ rôle est obligatoire")
  @NotBlank(message = "Le champ rôle ne peut être vide")
  private String role;

  // created_at et updated_at pour les dates d'ajout et de modification
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, columnDefinition = "timestamp")
  private Date created_at;

  @CreationTimestamp
  @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp")
  private Date updated_at;
}
