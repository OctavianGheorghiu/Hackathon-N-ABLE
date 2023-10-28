
package com.example.demo.Controllers;

import com.example.demo.Models.Person;
import com.example.demo.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
@CrossOrigin
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/find_all")
    public List<Person> findAll(){
        return personRepository.findAll();
    }


/*    @GetMapping
    public String listPersons(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person/list";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") Long id, Model model) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            model.addAttribute("person", person);
            return "person/show";
        } else {
            return "person/not_found";
        }
    }*//*

*/
/*
    @GetMapping("/create")
    public String createPersonForm() {
        return "person/create";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/edit")
    public String editPersonForm(@PathVariable("id") Long id, Model model) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            model.addAttribute("person", person);
            return "person/edit";
        } else {
            return "person/not_found";
        }
    }

    @PostMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") Long id, @ModelAttribute Person updatedPerson) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.setName(updatedPerson.getName());
            person.setEmail(updatedPerson.getEmail());
            person.setPassword(updatedPerson.getPassword());
            person.setCity(updatedPerson.getCity());
            person.setPoints(updatedPerson.getPoints());
            personRepository.save(person);
            return "redirect:/persons";
        } else {
            return "person/not_found";
        }
    }

    @GetMapping("/{id}/delete")
    public String deletePerson(@PathVariable("id") Long id) {
        personRepository.deleteById(id);
        return "redirect:/persons";
    }*/

}

