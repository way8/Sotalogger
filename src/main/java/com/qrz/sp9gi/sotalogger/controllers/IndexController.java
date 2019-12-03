package com.qrz.sp9gi.sotalogger.controllers;

import com.qrz.sp9gi.sotalogger.domain.RadioHam;
import com.qrz.sp9gi.sotalogger.repositories.RadioHamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RadioHamRepository radioHamRepository;

    public IndexController(RadioHamRepository radioHamRepository) {
        this.radioHamRepository = radioHamRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<RadioHam> radioHamOptional = radioHamRepository.findByCallsign("SP9GI");

        System.out.println("Callsign id is:" + radioHamOptional.get().getId());

        return "index";
    }
}