package one.digitalinnovation.peopleManagement.service;

import one.digitalinnovation.peopleManagement.dto.MessageResponse;
import one.digitalinnovation.peopleManagement.entity.Person;
import one.digitalinnovation.peopleManagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponse create(Person person) {
        Person saved = personRepository.save(person);
        return MessageResponse
                .builder()
                .message("Created person with ID " + saved.getId())
                .build();
    }

}
