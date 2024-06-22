package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {
    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.random = new Random();
    }
    @Transactional
    public List<RouteShortInfoDto> getAll() {
       return routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();
    }

    private RouteShortInfoDto mapToShortInfo(Route route) {
        RouteShortInfoDto dto = modelMapper.map(route, RouteShortInfoDto.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());
        return dto;


    }

    @Transactional
    public RouteShortInfoDto getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;
        Optional<Route> byId = routeRepository.findById(randomId);
        if(byId.isEmpty()) {
            //throw exception, return empty
        }
     return mapToShortInfo(byId.get());
       //Request from DB
        // Map to DTO

    }
}


