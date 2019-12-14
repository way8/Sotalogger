package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.repositories.ActivationRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ActivationServicesImpl implements ActivationService {

    private final ActivationRepository activationRepository;

    public ActivationServicesImpl(ActivationRepository activationRepository) {
        this.activationRepository = activationRepository;
    }

    @Override
    public Set<Activation> getActivations() {
        Set<Activation> activationSet = new HashSet<>();
        activationRepository.findAll().iterator().forEachRemaining(activationSet::add);
        return activationSet;
    }

    @Override
    public Activation findById(Long l) {

        Optional<Activation> activationOptional = activationRepository.findById(l);

        if (!activationOptional.isPresent()) {
            throw new RuntimeException("Activation not Found!");
        }
        return activationOptional.get();
    }

    @Override
    public Activation save(Activation activation) {
        Activation savedActivation = activationRepository.save(activation);

        return savedActivation;
    }

    @Override
    public void deleteById(Long idToDelete) {
        activationRepository.deleteById(idToDelete);
    }
}
