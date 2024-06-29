package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineEnum;
import jakarta.validation.constraints.*;

public record AddOfferDto (
        @NotEmpty
        @Size(min = 5, max =500)
        String description,
        @NotEmpty
        @PositiveOrZero
        Integer mileage,

        @NotEmpty
        EngineEnum engineType
) {
    public static AddOfferDto empty() {
        return new AddOfferDto(null, null, null);
    }

}
