package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller to handle all things route relates
 */

@Controller
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService= routeService;
    }

    /**
     * Method to handle the list of all routes.
     * @param model
     * @return
     */
    @GetMapping("/routes")
    public String routes(Model model) {
//        RouteShortInfoDto randomRoute = routeService.getRandomRoute();
//        model.addAttribute("route", randomRoute);
        List<RouteShortInfoDto> routes =routeService.getAll();
model.addAttribute("allRoutes",routes);
        return "routes";
    }
}
