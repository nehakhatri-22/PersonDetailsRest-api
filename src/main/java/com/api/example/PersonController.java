package com.api.example;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/", produces = "application/json;charset=UTF-8")
public class PersonController {

    @Autowired
    private APIRepository personRepository;
    ObjectMapper objectMapper;

    /**
     * Get all persons list.
     *
     * @return the list
     */

    @GetMapping("/patients")
    List<PersonEntity> getPatients() {
        List<PersonEntity> l = new ArrayList();
        PersonEntity p = new PersonEntity();
        // p.setLast_Name("K");
        // p.setAge(1);
        l.add(p);
        return l;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PersonEntity> getAllpersons() {
        return personRepository.findAll();
    }

    /**
     * Gets persons by id.
     *
     * @param personId the person id
     * @return the persons by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Person> getpersonsById(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        PersonEntity personEntity =
                personRepository
                        .findById(personId)
                        .orElseThrow(() -> new ResourceNotFoundException("person not found on :: " + personId));

        Person p = new Person();
        p.setAge(personEntity.getAge());
        p.setFavouriteColor(personEntity.getFavourite_color());
        p.setFirstName(personEntity.getFirst_name());
        p.setLastName(personEntity.getLast_name());


        return ResponseEntity.ok().body(DtoToEntity(personEntity));
    }

    /**
     * ////     * Create person person.
     * ////     *
     * ////     * @param person the person
     * ////     * @return the person
     * ////
     */
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createperson(@NonNull @RequestBody Person person) {
        PersonEntity p = personRepository.save(entityToDTO(person));
        HttpHeaders headers= new HttpHeaders();
        headers.set("id",p.getId().toString());
        return new ResponseEntity<>("Person is added",headers, HttpStatus.OK);
    }

    /**
     * Update person response entity.
     *
     * @param personId      the person id
     * @param personDetails the person details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Person> updateperson(
            @PathVariable(value = "id") Long personId, @Validated @RequestBody Person personDetails)
            throws ResourceNotFoundException {

        PersonEntity personEntity =
                personRepository
                        .findById(personId)
                        .orElseThrow(() -> new ResourceNotFoundException("person not found on :: " + personId));

personEntity.setLast_name(personDetails.getLastName());
        personEntity.setFirst_name(personDetails.getFirstName());
        personEntity.setFavourite_color(personDetails.getFavouriteColor());
        personEntity.setAge(personDetails.getAge());
         PersonEntity updatedPerson = personRepository.save(personEntity);
        HttpHeaders headers= new HttpHeaders();
        headers.set("id",updatedPerson.getId().toString());
        return new ResponseEntity<>(DtoToEntity(updatedPerson),headers,HttpStatus.OK);
    }

    /**
     * Delete person map.
     *
     * @param personId the person id
     * @return the map
     * @throws Exception the exception
     */

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE)

    public Map<String, Boolean> deleteperson(@PathVariable(value = "id") Long personId) throws Exception {
        PersonEntity person =
                personRepository
                        .findById(personId)
                        .orElseThrow(() -> new ResourceNotFoundException("person not found on :: " + personId));


        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;


    }

    private PersonEntity entityToDTO(Person p) {
        PersonEntity pe = new PersonEntity();
        pe.setAge(p.getAge());
        pe.setFavourite_color(p.getFavouriteColor());
        pe.setFirst_name(p.getFirstName());
        pe.setLast_name(p.getLastName());
        return pe;

    }

    private Person DtoToEntity(PersonEntity pe) {
        Person p = new Person();
        p.setAge(pe.getAge());
        p.setFirstName(pe.getFirst_name());
        p.setLastName(pe.getLast_name());
        p.setFavouriteColor(pe.getFavourite_color());
        return p;
    }

}


