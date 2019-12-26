package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.domain.Band;
import com.qrz.sp9gi.sotalogger.services.ActivationService;
import com.qrz.sp9gi.sotalogger.services.BandService;
import com.qrz.sp9gi.sotalogger.services.RadioHamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class BandController {

    private final BandService bandService;
    private final ActivationService activationService;

    public BandController(BandService bandService, ActivationService activationService) {
        this.bandService = bandService;
        this.activationService = activationService;
    }

    @GetMapping
    @RequestMapping("/activation/{activationId}/bands")
    public String ShowById(@PathVariable String activationId, Model model) {

        model.addAttribute("activation", activationService.findById(Long.valueOf(activationId)));

        return "activation/band/list";
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

        model.addAttribute("band", bandService.findById(Long.valueOf(activationId), Long.valueOf(id)));

        log.info("activation id:" + activationId);
        log.info("band id:" + id);
        return "activation/band/bandform";
    }

    @PostMapping("activation/{bandId}/band")
    public String saveOrUpdate(@ModelAttribute Band band) {
        Band savedBand = bandService.save(band);

//        log.debug("saved activation id:" + savedBand.getActivation().getId());
        log.info("saved band id:" + savedBand.getId());

        return "redirect:/activation/1/show";

    }

    @GetMapping
    @RequestMapping("/activation/{activationId}/band/{id}/delete")
    public String deleteById(@PathVariable String activationId,
                             @PathVariable String id, Model model) {


        log.info("saved band id:" + id);
        bandService.deleteById(Long.valueOf(activationId), Long.valueOf(id));
        return "redirect:/activation/1/show";
    }

}
