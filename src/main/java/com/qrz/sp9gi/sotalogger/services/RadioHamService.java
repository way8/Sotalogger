package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.RadioHam;

import java.util.Set;

public interface RadioHamService {

    Set<RadioHam> getRadioHam();

    RadioHam findById(Long activationId, Long l);

    RadioHam save(RadioHam RadioHam);

    void deleteById(Long activationId, Long idToDelete);
}
