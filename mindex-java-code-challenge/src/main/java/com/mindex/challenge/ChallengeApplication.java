package com.mindex.challenge;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}//end main

	/*
	@Bean
	CommandLineRunner runner(EmployeeRepository repository, MongoTemplate mongoTemplate){
		return args -> {

			String employee = "Engineer";
			Compensation compensation = new Compensation(employee,
					"$80000",
					LocalDateTime.now());



			//repository.findCompensationByEmployee(employee);
			//repository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");

			//*Querying/inserting into database
			Query query = new Query();
			query.addCriteria(Criteria.where("employee").is(employee));
			List<Compensation> compensations = mongoTemplate.find(query, Compensation.class);

			//checking for duplicate records
			if(compensations.size() > 1){
				throw new IllegalStateException("Duplicate employees with name " + employee);		//should not happen with indexed, but good practice
			}

			//if compensation is not in existence, it will be added, otherwise it will not be and a message is sent to console
			if(compensations.isEmpty()){
				System.out.println("Inserting compensation record for " + compensation);
				repository.insert(compensation);
			}
			else {
				System.out.println(compensation + " is already in existence");
			}


		};//end return args
	}//end runner
	*/


}//end ChallengeApplication
