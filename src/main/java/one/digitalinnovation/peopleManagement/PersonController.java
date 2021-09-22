package one.digitalinnovation.peopleManagement;

import one.digitalinnovation.peopleManagement.dto.MessageResponse;
import one.digitalinnovation.peopleManagement.entity.Person;
import one.digitalinnovation.peopleManagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
@SpringBootApplication
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}


	public static void main(String[] args) {
		SpringApplication.run(PersonController.class, args);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse create(@RequestBody  Person person) {
		return personService.create(person);
	}

}
