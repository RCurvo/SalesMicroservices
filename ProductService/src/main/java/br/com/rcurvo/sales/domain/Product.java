package br.com.rcurvo.sales.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Product", description="Product") 
public class Product {
	
	public enum Status {
		ACTIVE, INACTIVE;
	}
	
	@Id
	private String id;

	@NotNull
	@Size(min = 2, max = 10)
	@Indexed(unique = true, background = true)
	private String code;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String name;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String description;
	
	private BigDecimal value;
	
	private Status status;

}
