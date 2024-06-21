package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.UserLoginDto;
import com.bonappetit.model.dto.UserRegisterDto;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;
//    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDto data){
        Optional<User> existingUser =userRepository.
                findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if(existingUser.isPresent()) {
            return false;
        }
        User user = new User();

       user.setUsername(data.getUsername());
       user.setEmail(data.getEmail());
       user.setPassword(passwordEncoder.encode(data.getPassword()));

       this.userRepository.save(user);

//
//        User mapped = modelMapper.map(data, User.class);
//        mapped.setPassword(passwordEncoder.encode(mapped.getPassword()));
//
//        userRepository.save(mapped);
        return true;
    }

    public boolean login(UserLoginDto data) {
        Optional<User> byUsername = userRepository.findByUsername(data.getUsername());

        if(byUsername.isEmpty()) {
            return false;
        }

        boolean passMatch = passwordEncoder
                .matches(data.getPassword(), byUsername.get().getPassword());
        if(!passMatch) {
            return false;
        }
        userSession.login(byUsername.get().getId(), data.getUsername());
        return true;

    }
}
