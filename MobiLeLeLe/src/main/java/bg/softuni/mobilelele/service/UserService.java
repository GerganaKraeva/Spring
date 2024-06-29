package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.UserRegistrationDto;
import org.springframework.stereotype.Service;

public interface UserService {
    void registerUser(UserRegistrationDto userRegistrationDto) ;
}
