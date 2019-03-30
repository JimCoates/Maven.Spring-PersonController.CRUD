package io.zipcoder.crudapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    PersonRepository repository;

    public PersonController(PersonRepository repository){
        this.repository = repository;
    }

    @PostMapping("/people")
    public ResponseEntity<Person> creatPerson(@RequestBody Person p){
        return new ResponseEntity<>(repository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/people")
    public ResponseEntity<Person> getPersonList(){
        return new ResponseEntity<>((Person) repository.findAll(), HttpStatus.FOUND);
    }

    @PutMapping("/people")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p){
        return new ResponseEntity<>(repository.save(p), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        repository.delete(id);
        return new ResponseEntity<Person>(HttpStatus.OK);
    }
}
