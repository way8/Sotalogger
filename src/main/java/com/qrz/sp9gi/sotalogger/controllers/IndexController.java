package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.services.ActivationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final ActivationService activationService;

    public IndexController(ActivationService activationService) {
        this.activationService = activationService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("activations", activationService.getActivations());

        return "index";
    }
}