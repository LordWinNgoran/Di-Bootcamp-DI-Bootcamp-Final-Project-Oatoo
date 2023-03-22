package com.atos.oatoo.payload;
import com.atos.oatoo.models.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    private String username;
    private String firstname;
    private String lastname;
    private Role role;
    private String email;
    private String password;
}
