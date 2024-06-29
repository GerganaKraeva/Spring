package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.UserRegistrationDto;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        System.out.println("The user received is: " + userRegistrationDto);
    }
}
