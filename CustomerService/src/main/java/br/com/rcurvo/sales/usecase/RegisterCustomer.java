package br.com.rcurvo.sales.usecase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rcurvo.sales.domain.Customer;
import br.com.rcurvo.sales.repository.ICustomerRepository;

@Service
public class RegisterCustomer {
	
	private ICustomerRepository customerRepository;
	
	@Autowired
	public RegisterCustomer(ICustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer register(@Valid Customer customer) {
		return this.customerRepository.insert(customer);
	}

	public Customer update(@Valid Customer customer) {
		return this.customerRepository.save(customer);
	}

	public void remove(String id) {
		this.customerRepository.deleteById(id);
	}

}
