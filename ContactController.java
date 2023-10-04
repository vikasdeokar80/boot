package com.sajal.addressbookapp.controller;

import com.sajal.addressbookapp.dto.ContactDto;
import com.sajal.addressbookapp.model.Contact;
import com.sajal.addressbookapp.respository.ContactRepo;
import com.sajal.addressbookapp.service.ContactService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
//    ContactRepo contactRepo;
    ContactService contactService;


//    @PostMapping("/mycontacts")
//    public String createNewContact(@RequestBody Contact contact) {
//        contactRepo.save(contact);
//        return "New contact created";

    @PostMapping("/mycontacts")
    public Contact createNewContact(@RequestBody ContactDto contactDto) {
        return  contactService.create(contactDto);
    }

    @GetMapping("/mycontacts")
    public ResponseEntity<List<Contact>> getAllContact() {
        return contactService.getAllContact();

    }

    @GetMapping("/mycontacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/mycontacts/{id}")
    public Object updateContactById (@PathVariable long id, @RequestBody ContactDto contactDto) {
        return contactService.updateContactById(id, contactDto);
    }

    @GetMapping("/mycontacts/city")
    public Object getContactByCity (@RequestParam String city){
        return contactService.getContactByCity(city);
    }

//
//    }
//    @DeleteMapping("/mycontacts/{id}")
//    public String contactDeleteById(@PathVariable long id) {
//        contactRepo.deleteById(id);
//        return "ID: "+id+ " has been deleted successfully";
//    }
}
