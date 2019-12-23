package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.RadioHam;
import com.qrz.sp9gi.sotalogger.repositories.RadioHamRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RadioHamServicesImpl implements RadioHamService {

    private final RadioHamRepository radioHamRepository;

    public RadioHamServicesImpl(RadioHamRepository radioHamRepository) {
        this.radioHamRepository = radioHamRepository;
    }

    @Override
    public Set<RadioHam> getRadioHam() {
        Set<RadioHam> radioHamSet = new HashSet<>();
        radioHamRepository.findAll().iterator().forEachRemaining(radioHamSet::add);
        return radioHamSet;
    }

    @Override
    public RadioHam findById(Long l) {

        Optional<RadioHam> radioHamOptional = radioHamRepository.findById(l);

        if (!radioHamOptional.isPresent()) {
            throw new RuntimeException("Activation not Found!");
        }
        return radioHamOptional.get();
    }

    @Override
    public RadioHam save(RadioHam RadioHam) {
        RadioHam savedBand = radioHamRepository.save(RadioHam);

        return savedBand;
    }

    @Override
    public void deleteById(Long idToDelete) {
        radioHamRepository.deleteById(idToDelete);
    }
}
