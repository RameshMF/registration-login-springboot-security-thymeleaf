package techIn.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import techIn.springboot.springsecurity.model.User;
import techIn.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
