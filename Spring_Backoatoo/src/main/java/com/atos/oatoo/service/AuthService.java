package com.atos.oatoo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atos.oatoo.config.jwt.JwTokenClient;
import com.atos.oatoo.config.jwt.JwtUserDetailsImpl;
import com.atos.oatoo.controller.exception.EntityException;
import com.atos.oatoo.models.User;
import com.atos.oatoo.payload.LoginDto;
import com.atos.oatoo.payload.SignupDto;
import com.atos.oatoo.repository.IRoleRepository;
import com.atos.oatoo.repository.IUserRepository;

@Service
public class AuthService implements IAuthService {

    private AuthenticationManager authenticationManager;
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwTokenClient jwtTokenProvider;


    public AuthService(AuthenticationManager authenticationManager,
                       IUserRepository userRepository,
                       IRoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwTokenClient jwtTokenProviders
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProviders;
    }

    

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateJwtToken((JwtUserDetailsImpl) authentication);
        //String token = "rttaaaaaaaaaaaaaaaaa";

        return token;
    }

    @Override
    public String register(SignupDto registerDto) throws EntityException {


        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())) {
            throw new EntityException("Email is already exists!.");
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setRole(registerDto.getRole());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        //Role roles = roleRepository.findByName(ERole.ROLE_ADMIN).get();
        //user.setRoles(Collections.singletonList(roles));

        //Set<Role> roles = new HashSet<>();
        //Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN).get();
        //roles.add(userRole);
        //user.setRoles((List<Role>) roles);

        userRepository.save(user);

        return "User registered successfully!.";
    }
}
