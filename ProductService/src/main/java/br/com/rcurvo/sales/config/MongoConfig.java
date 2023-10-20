package br.com.rcurvo.sales.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.rcurvo.sales.repository")
public class MongoConfig {

}