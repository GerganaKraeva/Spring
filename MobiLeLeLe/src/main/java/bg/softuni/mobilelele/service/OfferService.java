package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDto;
import bg.softuni.mobilelele.model.dto.OfferDetailDto;

public interface OfferService {

    long createOffer(AddOfferDto addOfferDto);

    OfferDetailDto getOfferDetails(Long id);
}
