package br.com.jeffita.zupbank.service;

import br.com.jeffita.zupbank.dto.PersonDTO;
import br.com.jeffita.zupbank.entity.Person;
import br.com.jeffita.zupbank.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(PersonDTO personDTO){
        return personRepository.saveAndFlush(personDTO.convertToObj());
    }

    public List<Person> findALl(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        var person  = personRepository.findById(id);

        if (person.isPresent()){
            return  person.get();
        }else{
            throw new PersonNotFoundException(id);
        }
    }

    public Person update(Long id, PersonDTO personDTO){
        var person =  findById(id);
        person.setCpf(personDTO.getCpf());
        person.setEmail(personDTO.getEmail());
        person.setName(personDTO.getName());
        person.setBirthDate(personDTO.getBirthDate());

        return personRepository.saveAndFlush(person);
    }

    public void delete(Long id){
        var person =  findById(id);
        personRepository.delete(person);
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class PersonNotFoundException extends RuntimeException {
        private Long id;

        @Override
        public String getMessage() {
            return "Person with ID '" + id + "' not found";
        }
    }
}
