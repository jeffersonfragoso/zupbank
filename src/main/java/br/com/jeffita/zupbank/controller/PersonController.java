package br.com.jeffita.zupbank.controller;

import br.com.jeffita.zupbank.dto.PersonDTO;
import br.com.jeffita.zupbank.dto.PersonResponseDTO;
import br.com.jeffita.zupbank.entity.Person;
import br.com.jeffita.zupbank.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public ResponseEntity<PersonResponseDTO> create(@RequestBody @Valid PersonDTO personRequestDto){
        Person person = personService.create(personRequestDto);
        return new ResponseEntity<>(PersonResponseDTO.convertToDTO(person), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        List<PersonResponseDTO> persons = personService.findALl()
                .stream()
                .map(PersonResponseDTO::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable long id){
        Person person = personService.findById(id);
        return new ResponseEntity<>(PersonResponseDTO.convertToDTO(person), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable long id, @RequestBody @Valid  PersonDTO personRequestDto){
        Person person = personService.update(id, personRequestDto);
        return new ResponseEntity<>(PersonResponseDTO.convertToDTO(person), HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }


}
