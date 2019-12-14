package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.services.ActivationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActivationController {

    private final ActivationService activationService;

    public ActivationController(ActivationService activationService) {
        this.activationService = activationService;
    }

    @GetMapping
    @RequestMapping("/activation/{id}/show")
    public String ShowById(@PathVariable String id, Model model) {

        model.addAttribute("activation", activationService.findById(Long.valueOf(id)));

        return "activation/show";
    }

    @GetMapping
    @RequestMapping("activation/new")
    public String newActivation(Model model) {
        model.addAttribute("activation", new Activation());

        return "activation/activationform";
    }

    @GetMapping
    @RequestMapping("/activation/{id}/update")
    public String updateActivation(@PathVariable String id, Model model) {

        model.addAttribute("activation", activationService.findById(Long.valueOf(id)));

        return "activation/activationform";
    }


    @PostMapping
    @RequestMapping("activation")
    public String saveOrUpdate(@ModelAttribute Activation activation) {
        Activation savedActivation = activationService.save(activation);
        return "redirect:/activation/" + savedActivation.getId() + "/show/";

    }
    @GetMapping
    @RequestMapping("/activation/{id}/delete")
    public String deleteById(@PathVariable String id){

        activationService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

}
