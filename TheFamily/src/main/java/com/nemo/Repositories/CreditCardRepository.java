package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemo.Models.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

}
