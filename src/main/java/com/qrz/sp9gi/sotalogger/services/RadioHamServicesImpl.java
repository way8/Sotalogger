package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.domain.RadioHam;
import com.qrz.sp9gi.sotalogger.repositories.ActivationRepository;
import com.qrz.sp9gi.sotalogger.repositories.RadioHamRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RadioHamServicesImpl implements RadioHamService {

    private final RadioHamRepository radioHamRepository;
    private final ActivationRepository activationRepository;

    public RadioHamServicesImpl(RadioHamRepository radioHamRepository, ActivationRepository activationRepository) {
        this.radioHamRepository = radioHamRepository;
        this.activationRepository = activationRepository;
    }

    @Override
    public Set<RadioHam> getRadioHam() {
        Set<RadioHam> radioHamSet = new HashSet<>();
        radioHamRepository.findAll().iterator().forEachRemaining(radioHamSet::add);
        return radioHamSet;
    }

    @Override
    public RadioHam findById(Long activationId, Long hamId) {

        Optional<Activation> activationOptional = activationRepository.findById(activationId);

        if (!activationOptional.isPresent()) {
            throw new RuntimeException("Activation not Found!");
        }
        Activation activation = activationOptional.get();

        Optional<RadioHam> radioHamOptional = activation.getRadioHams().stream().filter(radioHam -> radioHam.getId().equals(hamId)).findFirst();

        return radioHamOptional.get();
    }

    @Override
    public RadioHam save(RadioHam RadioHam) {
        RadioHam savedBand = radioHamRepository.save(RadioHam);

        return savedBand;
    }

    @Override
    public void deleteById(Long activationId, Long idToDelete)
    {
        Optional<Activation> activationOptional = activationRepository.findById(activationId);

        if(activationOptional.isPresent()){
            Activation activation = activationOptional.get();

            Optional<RadioHam> radioHamOptional = activation
                    .getRadioHams()
                    .stream()
                    .filter(radioHam -> radioHam.getId().equals(idToDelete))
                    .findFirst();

            if(radioHamOptional.isPresent()){
                RadioHam radioHamToDelete = radioHamOptional.get();
                radioHamToDelete.setActivations(null);
                activation.getRadioHams().remove(radioHamOptional.get());
                activationRepository.save(activation);
            }
        }
    }
}
