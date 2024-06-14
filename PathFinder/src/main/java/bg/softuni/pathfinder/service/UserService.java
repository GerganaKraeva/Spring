package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.UserRepository;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.web.dto.UserRegisterDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public void register(UserRegisterDto userRegisterDto) {
        User user = this.mapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(user);
    }
}
