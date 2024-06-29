package bg.softuni.mobilelele.model.dto;

public record UserRegistrationDto (String firstName,
                                   String lastName,
                                   String password,
                                   String email) {
}
