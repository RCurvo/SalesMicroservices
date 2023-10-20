package br.com.rcurvo.sales.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rcurvo.sales.domain.Customer;


@Repository
public interface ICustomerRepository extends MongoRepository<Customer, String>{

	Optional<Customer> findByCpf(Long cpf);
}