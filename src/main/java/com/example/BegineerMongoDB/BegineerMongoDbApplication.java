package com.example.BegineerMongoDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BegineerMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BegineerMongoDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository , MongoTemplate mongoTemplate){
		return args -> {
			String firstName = "Radhu";

			Student student = new Student(
					firstName,
					"Code",
					"rcode@gmail.com",
					Gender.MALE,
					new Address("India", "823881A", "Sindri"),
					List.of("Java", "SpringBoot"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			// QueryMongoTemplate(repository, mongoTemplate, firstName, student);
			repository.findStudentByfirstName(firstName).ifPresentOrElse(
					st -> {
						System.out.println(st+"already exists!");
					},()->{
						System.out.println("Inserting student "+ student);
						//Repository
						repository.insert(student);
					}
			);
		};
	}

//	private void QueryMongoTemplate(StudentRepository repository, MongoTemplate mongoTemplate, String firstName, Student student) {
//		//Mongo's Template Queries
//		Query query = new Query();
//		query.addCriteria(Criteria.where("firstName").is(firstName));
//
//		List<Student> students = mongoTemplate.find(query, Student.class);
//
//		if (students.size() > 1) {
//			throw new IllegalStateException("found many students with the email"+ firstName);
//		}
//
//		if (students.isEmpty()){
//			System.out.println("Inserting student "+ student);
//			//Repository
//			repository.insert(student);
//		}else{
//			System.out.println("already exists!");
//		}
//	}

}
