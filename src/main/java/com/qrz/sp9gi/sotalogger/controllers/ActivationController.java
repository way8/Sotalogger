package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.services.ActivationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivationController {

    private final ActivationService activationService;

    public ActivationController(ActivationService activationService) {
        this.activationService = activationService;
    }
    @RequestMapping("/activation/show/{id}")
    public String ShowById(@PathVariable String id, Model model ){

        model.addAttribute("activation", activationService.findById(Long.valueOf(id)));

        return "activation/show";
    }
}
