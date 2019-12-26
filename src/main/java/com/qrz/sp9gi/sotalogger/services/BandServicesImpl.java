package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.domain.Band;
import com.qrz.sp9gi.sotalogger.repositories.ActivationRepository;
import com.qrz.sp9gi.sotalogger.repositories.BandRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BandServicesImpl implements BandService {

    private final BandRepository bandRepository;
    private final ActivationRepository activationRepository;

    public BandServicesImpl(BandRepository bandRepository, ActivationRepository activationRepository) {
        this.bandRepository = bandRepository;
        this.activationRepository = activationRepository;
    }

    @Override
    public Set<Band> getBand() {
        Set<Band> bandSet = new HashSet<>();
        bandRepository.findAll().iterator().forEachRemaining(bandSet::add);
        return bandSet;
    }

    @Override
    public Band findById(Long activationId, Long bandId) {

        Optional<Activation> activationOptional = activationRepository.findById(activationId);

        if (!activationOptional.isPresent()) {
            throw new RuntimeException("Activation not Found!");
        }

        Activation activation = activationOptional.get();

        Optional<Band> bandOptional = activation.getBands().stream().filter(band -> band.getId().equals(bandId)).findFirst();
        return bandOptional.get();
    }

    @Override
    public Band save(Band band) {
        Band savedBand = bandRepository.save(band);

        return savedBand;
    }

    @Override
    public void deleteById(Long activationId, Long idToDelete) {

        Optional<Activation> activationOptional = activationRepository.findById(activationId);

        if(activationOptional.isPresent()){
            Activation activation = activationOptional.get();

            Optional<Band> bandOptional = activation
                    .getBands()
                    .stream()
                    .filter(band -> band.getId().equals(idToDelete))
                    .findFirst();

            if(bandOptional.isPresent()){
                Band bandToDelete = bandOptional.get();
                bandToDelete.setActivation(null);
                activation.getBands().remove(bandOptional.get());
                activationRepository.save(activation);
            }
        }
    }
}
