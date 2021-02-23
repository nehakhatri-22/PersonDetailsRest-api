//package com.example.java;
//
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//import com.example.exception.ResourceNotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import javax.validation.Valid;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Controller
//public class RestController {
//
//
//    @Autowired
//    private APIRepository personRepository;
//
//    /**
//     * Get all persons list.
//     *
//     * @return the list
//     */
//    @RequestMapping(value="/persons",method=RequestMethod.GET)
//    public List<PersonEntity> getAllpersons() {
//        return personRepository.findAll();
//    }
//
//    /**
//     * Gets persons by id.
//     *
//     * @param personId the person id
//     * @return the persons by id
//     * @throws ResourceNotFoundException the resource not found exception
//     */
//    @RequestMapping(value="/persons/{id}",method=RequestMethod.GET)
//    public ResponseEntity<Person> getpersonsById(@PathVariable(value = "id") Long personId)
//            throws ResourceNotFoundException {
////        Person person =
////                personRepository
////     e                   .findById(personId)
////                        .orElseThrow(() -> new ResourceNotFoundException("person not found on :: " + personId));
////        return ResponseEntity.ok().body(person);
//    }
//
//    /**
//     * Create person person.
//     *
//     * @param person the person
//     * @return the person
//     */
//    @RequestMapping(value="/persons",method=RequestMethod.POST)
//    public Person createperson(@Valid @RequestBody Person person) {
//        return personRepository.save(person);
//    }
//
//    /**
//     * Update person response entity.
//     *
//     * @param personId      the person id
//     * @param personDetails the person details
//     * @return the response entity
//     * @throws ResourceNotFoundException the resource not found exception
//     */
//
//    @RequestMapping(value="/persons/{id}",method=RequestMethod.PUT)
//    public ResponseEntity<Person> updateperson(
//            @PathVariable(value = "id") Long personId, @Valid @RequestBody Person personDetails)
//            throws ResourceNotFoundException {
//
////        Person person =
////                personRepository
////                        .findById(personId)
////                        .orElseThrow(() -> new ResourceNotFoundException("person not found on :: " + personId));
//
////        person.(personDetails.getEmail());
////        person.setLastName(personDetails.getLastName());
////        person.setFirstName(personDetails.getFirstName());
////        person.setUpdatedAt(new Date());
////        final Person updatedperson = personRepository.save(person);
//        return ResponseEntity.ok(updatedperson);
//    }
//
//    /**
//     * Delete person map.
//     *
//     * @param personId the person id
//     * @return the map
//     * @throws Exception the exception
//     */
//
//    @RequestMapping(value="/persons/{id}",method=RequestMethod.DELETE)
//
//    public Map<String, Boolean> deleteperson(@PathVariable(value = "id") Long personId) throws Exception {
////        Person person =
////                personRepository
////                        .findById(personId)
////                        .orElseThrow(() -> new ResourceNotFoundException("person not found on :: " + personId));
////
////
////        personRepository.delete(person);
////        Map<String, Boolean> response = new HashMap<>();
////        response.put("deleted", Boolean.TRUE);
////        return response;
//
//
//
//
//}
//
//
