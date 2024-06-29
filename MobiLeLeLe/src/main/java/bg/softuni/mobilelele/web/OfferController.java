package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.AddOfferDto;
import bg.softuni.mobilelele.model.enums.EngineEnum;
import bg.softuni.mobilelele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @ModelAttribute("allEngineTypes")
    public EngineEnum[] allEngineTypes() {
        return EngineEnum.values();
    }
    @GetMapping("/add")
    public String newOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDto.empty());
        }

        return "offer-add";
    }
    @PostMapping("/add")
    public String createOffer(
            @Valid AddOfferDto addOfferDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/add";
        }

        long offerId = offerService.createOffer(addOfferDto);
        return "redirect:/offers/" + offerId;
    }
}