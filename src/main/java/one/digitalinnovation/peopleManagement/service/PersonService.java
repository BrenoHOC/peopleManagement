package one.digitalinnovation.peopleManagement.service;

import one.digitalinnovation.peopleManagement.dto.MessageResponse;
import one.digitalinnovation.peopleManagement.dto.request.PersonDTO;
import one.digitalinnovation.peopleManagement.entity.Person;
import one.digitalinnovation.peopleManagement.mapper.PersonMapper;
import one.digitalinnovation.peopleManagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponse create(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponse
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
