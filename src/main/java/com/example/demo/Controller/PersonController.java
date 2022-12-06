package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;

@Controller
@RequestMapping("/hello")
public class PersonController {
    private List<Person> personList = new ArrayList<>();

    @Autowired
    PersonService personService;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${person.list.header}")
    private String personMessage;

    @GetMapping(value = { "/", "/home" })
    public String index(Model model) {
        model.addAttribute("message", welcomeMessage);
        return "view";
    }

    @GetMapping(value = "/persons")
    public @ResponseBody List<Person> getAllPerson() {
        return personList = personService.getPerson();

    }

    @GetMapping(value = "/list")
    public String personList(Model model) {
        personList = personService.getPerson();
        model.addAttribute("persons", personList);
        model.addAttribute("listOfPerson", personMessage);
        return "personList";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value = "per") Person p, Model model) {
        model.addAttribute("per", p);
        return "personEdit";
    }

    @PostMapping("/updatePerson")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    public String updatePersonRecord(@ModelAttribute(value = "person") Person person) {
        personService.updatePerson(person);
        return "redirect:/hello/list";
    }
}
