package br.com.rcurvo.sales.usecase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rcurvo.sales.domain.Product;
import br.com.rcurvo.sales.repository.IProductRepository;

@Service
public class RegisterProduct {
	
	private IProductRepository productRepository;
	
	@Autowired
	public RegisterProduct(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product register(@Valid Product product) {
		return this.productRepository.insert(product);
	}

	public Product update(@Valid Product product) {
		return this.productRepository.save(product);
	}

	public void remove(String id) {
		this.productRepository.deleteById(id);
	}

}
