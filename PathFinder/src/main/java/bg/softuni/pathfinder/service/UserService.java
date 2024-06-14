package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.UserRepository;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.web.dto.UserLoginDto;
import bg.softuni.pathfinder.web.dto.UserRegisterDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userRepository.save(user);
    }

    public void login(UserLoginDto loginData) {
        User user = userRepository.findByUsername(loginData.getUsername());

        if (user == null) {
            //to do throw error
            return;
        }
        if (passwordEncoder.matches(loginData.getPassword(), user.getPassword()) && !currentUser.isLoggedIn()) {
            currentUser.setUser(user);
        }
    }
}