package bg.softuni.mobilelele.model;

public record UserRegistrationDto (String firstName,
                                   String lastName,
                                   String password,
                                   String email) {
}
