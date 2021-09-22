package one.digitalinnovation.peopleManagement.repository;

import one.digitalinnovation.peopleManagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {



}
