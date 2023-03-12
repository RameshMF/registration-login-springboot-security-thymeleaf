package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Role;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.RoleRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository,
//                           RoleRepository roleRepository,
//                           PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public void saveUser(UserDto userDto) {
//        User user = new User();
//        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
//        user.setEmail(userDto.getEmail());
//
        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        //user.setRoles(Arrays.asList(role));

        //used builed annoatatioan
        User user1=User.builder().name(userDto.getFirstName()+" "+userDto.getLastName()).email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword())).roles(Arrays.asList(role)).build();
        userRepository.save(user1);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
//        UserDto userDto = new UserDto();
            String[] name = user.getName().split(" ");
//        userDto.setFirstName(name[0]);
//        userDto.setLastName(name[1]);
//        userDto.setEmail(user.getEmail());
        UserDto userDto1= UserDto.builder().firstName(name[0]).lastName(name[1]).email(user.getEmail())
                .build();
        return userDto1;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
