package com.qrz.sp9gi.sotalogger.repositories;

import com.qrz.sp9gi.sotalogger.domain.RadioHam;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RadioHamRepository extends CrudRepository<RadioHam, Long> {

    Optional<RadioHam> findByCallsign(String callsign);
}
