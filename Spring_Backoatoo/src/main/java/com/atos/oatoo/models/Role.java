package com.atos.oatoo.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "troles")
public class Role extends AbstractEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20)
    private ERole name;

    public static Role roleAdmin() {
        Role roleAdmin = new Role();
        roleAdmin.setName(ERole.Administrateur);
        return roleAdmin;
    }

    public static Role roleEntreprise() {
        Role roleEntreprise = new Role();
        roleEntreprise.setName(ERole.Entreprise);
        return roleEntreprise;
    }
    public static Role roleDemandeur() {
        Role roleDemandeur = new Role();
        roleDemandeur.setName(ERole.Demandeur);
        return roleDemandeur;
    }
    public static Role roleAgence() {
        Role roleAgence = new Role();
        roleAgence.setName(ERole.Agence);
        return roleAgence;
    }

    @Override
    public String getAuthority() {
        return this.getName().toString();
    }
}
