package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.domain.Band;
import com.qrz.sp9gi.sotalogger.domain.RadioHam;
import com.qrz.sp9gi.sotalogger.services.ActivationService;
import com.qrz.sp9gi.sotalogger.services.BandService;
import com.qrz.sp9gi.sotalogger.services.RadioHamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RadioHamController {

    private final RadioHamService radioHamService;
    private final ActivationService activationService;

    public RadioHamController(RadioHamService radioHamService, ActivationService activationService) {
        this.radioHamService = radioHamService;
        this.activationService = activationService;
    }

    @GetMapping
    @RequestMapping("/activation/{activationId}/radiohams")
    public String ShowById(@PathVariable String activationId, Model model) {

        model.addAttribute("activation", activationService.findById(Long.valueOf(activationId)));

        return "activation/radioham/list";
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
    @RequestMapping("/activation/{activationId}/radioham/{id}/update")
    public String updateActivation(@PathVariable String activationId,
                                   @PathVariable String id, Model model) {

        model.addAttribute("ham", radioHamService.findById(Long.valueOf(activationId), Long.valueOf(id)));

        log.info("activation id:" + activationId);
        log.info("radioham id:" + id);
        return "activation/radioham/radiohamform";
    }

    @PostMapping("activation/{hamId}/radioham")
    public String saveOrUpdate(@ModelAttribute RadioHam radioHam) {
        RadioHam savedHam = radioHamService.save(radioHam);

        log.info("saved band id:" + savedHam.getId());

        return "redirect:/activation/1/show";

    }

    @GetMapping
    @RequestMapping("/activation/{activationId}/radioham/{id}/delete")
    public String deleteById(@PathVariable String activationId,
                             @PathVariable String id, Model model) {


        log.info("saved band id:" + id);
        radioHamService.deleteById(Long.valueOf(activationId), Long.valueOf(id));
        return "redirect:/activation/1/show";
    }

}
