package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineEnum;

public record OfferDetailDto (Long id,
                             String description,
                             Integer mileage,
                             EngineEnum engineType){
}
