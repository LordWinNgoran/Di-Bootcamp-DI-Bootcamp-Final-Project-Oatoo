package com.atos.oatoo.service;
import com.atos.oatoo.controller.exception.EntityException;
import com.atos.oatoo.payload.LoginDto;
import com.atos.oatoo.payload.SignupDto;
public interface IAuthService {

    String login(LoginDto loginDto);
    String register(SignupDto registerDto) throws EntityException;
}
