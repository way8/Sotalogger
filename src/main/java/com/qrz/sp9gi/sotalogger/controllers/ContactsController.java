package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.domain.Band;
import com.qrz.sp9gi.sotalogger.services.ActivationService;
import com.qrz.sp9gi.sotalogger.services.BandService;
import com.qrz.sp9gi.sotalogger.services.RadioHamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactsController {

    private final BandService bandService;
    private final RadioHamService radioHamService;
    private final ActivationService activationService;

    public ContactsController(BandService bandService, RadioHamService radioHamService, ActivationService activationService) {
        this.bandService = bandService;
        this.radioHamService = radioHamService;
        this.activationService = activationService;
    }

    @GetMapping
    @RequestMapping("/activation/{activationId}/bands")
    public String ShowById(@PathVariable String activationId, Model model) {

        model.addAttribute("activation", activationService.findById(Long.valueOf(activationId)));

        return "activation/contact/list";
    }

//    @GetMapping
//    @RequestMapping("radioham/new")
//    public String newActivation(Model model) {
//        model.addAttribute("activation", new Activation());
//
//        return "activation/activationform";
//    }
//
    @GetMapping
    @RequestMapping("/activation/{activationId}/band/{id}/update")
    public String updateActivation(@PathVariable String activationId,
                                   @PathVariable String id, Model model) {

        model.addAttribute("band", bandService.findById(Long.valueOf(id)));

        return "activation/contact/bandform";
    }

    @PostMapping("activation/{bandId}/band")
    public String saveOrUpdate(@ModelAttribute Band band) {
        Band savedBand = bandService.save(band);
        return "redirect:/activation/" + savedBand.getId() + "/show/";

    }


//    @GetMapping
//    @RequestMapping("/activation/{id}/delete")
//    public String deleteById(@PathVariable String id){
//
//        activationService.deleteById(Long.valueOf(id));
//        return "redirect:/";
//    }

}
