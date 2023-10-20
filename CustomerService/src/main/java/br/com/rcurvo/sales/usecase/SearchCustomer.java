package br.com.rcurvo.sales.usecase;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rcurvo.sales.domain.Customer;
import br.com.rcurvo.sales.exception.EntityNotFoundException;
import br.com.rcurvo.sales.repository.ICustomerRepository;

@Service
public class SearchCustomer {

	private ICustomerRepository customerRepository;
	
	@Autowired
	public SearchCustomer(ICustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Page<Customer> search(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}
	
	public Customer searchById(String id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Customer.class, "id", id));
	}
	
	public Boolean isCadastrado(String id) {
		Optional<Customer> cliente = customerRepository.findById(id);
		return cliente.isPresent() ? true : false;
	}

	public Customer searchByCpf(Long cpf) {
		return customerRepository.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException(Customer.class, "cpf", String.valueOf(cpf)));
	}

}
