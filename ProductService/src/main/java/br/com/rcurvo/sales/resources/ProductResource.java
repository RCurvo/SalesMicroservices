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

import br.com.rcurvo.sales.domain.Product;
import br.com.rcurvo.sales.usecase.RegisterProduct;
import br.com.rcurvo.sales.usecase.SearchProduct;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
	
	private SearchProduct searchProduct;
	
	private RegisterProduct registerProduct;
	
	@Autowired
	public ProductResource(SearchProduct searchProduct, RegisterProduct registerProduct) {
		this.registerProduct = registerProduct;
		this.searchProduct = searchProduct;
	}
	
	@GetMapping
	public ResponseEntity<Page<Product>> search(Pageable pageable){
		return ResponseEntity.ok(searchProduct.search(pageable));
	}
	
	@PostMapping
	public ResponseEntity<Product> register(@RequestBody @Valid Product product){
		return ResponseEntity.ok(registerProduct.register(product));
	}

}
