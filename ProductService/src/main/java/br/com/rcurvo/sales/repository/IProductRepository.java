package br.com.rcurvo.sales.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rcurvo.sales.domain.Product;


@Repository
public interface IProductRepository extends MongoRepository<Product, String>{

	Optional<Product> findByCode(Long cpf);
}