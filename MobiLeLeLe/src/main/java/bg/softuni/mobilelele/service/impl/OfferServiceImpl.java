package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.AddOfferDto;
import bg.softuni.mobilelele.model.dto.OfferDetailDto;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository=offerRepository;
    }

    @Override
    public long createOffer(AddOfferDto addOfferDto) {
           return offerRepository.save(map(addOfferDto)).getId();
    }

    @Override
    public OfferDetailDto getOfferDetails(Long id) {
        return this.offerRepository.findById(id)
                .map(OfferServiceImpl::toOfferDetails)
                .orElseThrow();
    }

    private static OfferDetailDto toOfferDetails(OfferEntity offerEntity) {

        return new OfferDetailDto(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());

    }


    private static OfferEntity map(AddOfferDto addOfferDto) {
       OfferEntity offerEntity= new OfferEntity();
       offerEntity.setDescription(addOfferDto.description());
       offerEntity.setEngine(addOfferDto.engineType());
       offerEntity.setMileage(addOfferDto.mileage());
       return offerEntity;


    }
}
