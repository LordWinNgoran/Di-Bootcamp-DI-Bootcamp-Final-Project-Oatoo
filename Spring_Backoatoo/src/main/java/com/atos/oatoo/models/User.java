package com.atos.oatoo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tusers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ firstname est obligatoire")
    @NotBlank(message = "Le champ firstname ne peut etre vide")
    @Column(name = "firstname")
    private String firstname;

    @NotNull(message = "Le champ lastname est obligatoire")
    @NotBlank(message = "Le champ lastname ne peut etre vide")
    @Column(name = "lastname")
    private String lastname;

    @NotNull(message = "Le champ email est obligatoire")
    @NotBlank(message = "Le champ email ne peut etre vide")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Le champ username est obligatoire")
    @NotBlank(message = "Le champ username ne peut etre vide")
    @Column(name = "username")
    private String username;


    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;


    public static User superAdmin(Optional<Role> role, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        User user = new User();
        user.setFirstname("Kouadio Jean Cyrille");
        user.setLastname("N'Goran");
        user.setUsername("lordwin@13");
        user.setEmail("lordwin@gmail.com");
        if (!(bCryptPasswordEncoder == null)) {
            user.setPassword(bCryptPasswordEncoder.encode("naruto"));
        }
        user.setRole(role.get());

        return user;
    }
}
