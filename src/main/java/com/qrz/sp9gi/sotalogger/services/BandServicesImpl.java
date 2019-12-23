package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.Band;
import com.qrz.sp9gi.sotalogger.repositories.BandRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BandServicesImpl implements BandService {

    private final BandRepository bandRepository;

    public BandServicesImpl(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @Override
    public Set<Band> getBand() {
        Set<Band> bandSet = new HashSet<>();
        bandRepository.findAll().iterator().forEachRemaining(bandSet::add);
        return bandSet;
    }

    @Override
    public Band findById(Long l) {

        Optional<Band> bandOptional = bandRepository.findById(l);

        if (!bandOptional.isPresent()) {
            throw new RuntimeException("Activation not Found!");
        }
        return bandOptional.get();
    }

    @Override
    public Band save(Band band) {
        Band savedBand = bandRepository.save(band);

        return savedBand;
    }

    @Override
    public void deleteById(Long idToDelete) {
        bandRepository.deleteById(idToDelete);
    }
}
