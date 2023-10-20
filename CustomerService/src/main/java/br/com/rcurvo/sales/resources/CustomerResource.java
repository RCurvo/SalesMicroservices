package br.com.rcurvo.sales.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rcurvo.sales.domain.Customer;
import br.com.rcurvo.sales.usecase.RegisterCustomer;
import br.com.rcurvo.sales.usecase.SearchCustomer;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {
	
	private SearchCustomer searchCustomer;
	
	private RegisterCustomer registerCustomer;
	
	@Autowired
	public CustomerResource(SearchCustomer searchCustomer, RegisterCustomer registerCustomer) {
		this.registerCustomer = registerCustomer;
		this.searchCustomer = searchCustomer;
	}
	
	@GetMapping
	public ResponseEntity<Page<Customer>> search(Pageable pageable){
		return ResponseEntity.ok(searchCustomer.search(pageable));
	}
	
	@PostMapping
	public ResponseEntity<Customer> register(@RequestBody @Valid Customer customer){
		return ResponseEntity.ok(registerCustomer.register(customer));
	}

}
