package one.digitalinnovation.peopleManagement;

import one.digitalinnovation.peopleManagement.dto.MessageResponse;
import one.digitalinnovation.peopleManagement.dto.request.PersonDTO;
import one.digitalinnovation.peopleManagement.exception.PersonNotFoundException;
import one.digitalinnovation.peopleManagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
	public MessageResponse create(@RequestBody @Valid PersonDTO person) {
		return personService.create(person);
	}

	@GetMapping
	public List<PersonDTO> listAll() {
		return personService.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO getById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
}
