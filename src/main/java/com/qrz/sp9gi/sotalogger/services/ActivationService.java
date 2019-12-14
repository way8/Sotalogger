package com.qrz.sp9gi.sotalogger.services;

import com.qrz.sp9gi.sotalogger.domain.Activation;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface ActivationService {

    Set<Activation> getActivations();

    Activation findById(Long l);

    Activation save(Activation activation);

    void deleteById(Long idToDelete);
}
