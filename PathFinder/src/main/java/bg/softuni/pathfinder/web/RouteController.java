package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService= routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteShortInfoDto randomRoute = routeService.getRandomRoute();
//        model.addAttribute("route", randomRoute);
        List<RouteShortInfoDto> routes =routeService.getAll();
model.addAttribute("allRoutes",routes);
        return "routes";
    }
}
