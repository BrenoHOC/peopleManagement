package one.digitalinnovation.peopleManagement.service;

import one.digitalinnovation.peopleManagement.dto.MessageResponse;
import one.digitalinnovation.peopleManagement.dto.request.PersonDTO;
import one.digitalinnovation.peopleManagement.entity.Person;
import one.digitalinnovation.peopleManagement.exception.PersonNotFoundException;
import one.digitalinnovation.peopleManagement.mapper.PersonMapper;
import one.digitalinnovation.peopleManagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

       Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
}
