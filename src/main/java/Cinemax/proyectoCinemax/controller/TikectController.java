package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.service.TikectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TikectController {
    private final TikectService tikectService;

    public TikectController(TikectService tikectService) {
        this.tikectService = tikectService;
    }

    @GetMapping("/compraTikects")
    public String compraTikects(  ) {
        //model.addAttribute("" );
        return "compraTikects";
    }
}
