package org.anu;

import org.anu.entity.Address;
import org.anu.entity.Person;
import org.anu.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateOntToManyMappingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HibernateOntToManyMappingApplication.class, args);
	}

	@Autowired
	private PersonRepo personRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Person person1 = new Person("Anu", "Sathiya");
		
		Address address1 = new Address( "Frisco", "TX");
		Address address2 = new Address( "Plano", "Texas");
		
		person1.getAddress().add(address1);
		person1.getAddress().add(address2);
		
		this.personRepo.save(person1);
	}

}
