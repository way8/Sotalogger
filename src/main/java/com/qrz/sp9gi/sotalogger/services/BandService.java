package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import com.qrz.sp9gi.sotalogger.domain.Band;

import java.util.Set;

public interface BandService {

    Set<Band> getBand();

    Band findById(Long l);

    Band save(Band Band);

    void deleteById(Long idToDelete);
}
