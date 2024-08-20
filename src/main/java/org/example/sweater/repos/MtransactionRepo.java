package org.example.sweater.repos;

import org.example.sweater.domain.Mtransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MtransactionRepo extends CrudRepository<Mtransaction, Long> {

    List<Mtransaction> findByCurrencyshortname(String currency_shortname);
    }