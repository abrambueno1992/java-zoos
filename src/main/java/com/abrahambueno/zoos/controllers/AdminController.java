package com.abrahambueno.zoos.controllers;

import com.abrahambueno.zoos.models.Animal;
import com.abrahambueno.zoos.models.Telephone;
import com.abrahambueno.zoos.models.Zoo;
import com.abrahambueno.zoos.repositories.AnimalRepository;
import com.abrahambueno.zoos.repositories.TelephoneRepository;
import com.abrahambueno.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

//@RestController
@RequestMapping(path = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    ZooRepository zoorepos;

    @Autowired
    TelephoneRepository telephonerepos;

    @Autowired
    AnimalRepository animalrepos;

    @PostMapping("/zoos")
    public Zoo addZoo(@RequestBody Zoo zoo) throws URISyntaxException {
        return zoorepos.save(zoo);
    }
//    @PostMapping("/zoos/animals")
    @PutMapping("/zoos/{id}")
    public Zoo changeZoo(@RequestBody Zoo zoo, @PathVariable long id) throws URISyntaxException {
        Optional<Zoo> updateZoo = zoorepos.findById(id);
        if (updateZoo.isPresent()) {
            if (zoo.getAnimals() == null) {
                zoo.setAnimals(updateZoo.get().getAnimals());
            }
            if (zoo.getPhones() == null) {
                zoo.setPhones(updateZoo.get().getPhones());
            }
            zoo.setZooid(id);
            zoorepos.save(zoo);
            return zoo;
        } else {
            return null;
        }
    }
    // might need to return String
    @DeleteMapping("/zoos/{id}")
    public Zoo deleteZooById(@PathVariable long id) throws URISyntaxException {
        var deleteZoo = zoorepos.findById(id);
        if (deleteZoo.isPresent()) {
            zoorepos.deleteById(id);
//            zoorepos.deleteZooFromAnimals(id);
//            zoorepos.deleteFromPhonenumbers(id);
            // return something
            return deleteZoo.get();
        } else {
            return null;
        }
    }
//    @DeleteMapping("/zoos/{zooid}/animals/{animalid}")

    @PostMapping("/phones")
    public Telephone addTelephone(@RequestBody Telephone phone) throws URISyntaxException {
        return telephonerepos.save(phone);
    }
    @PutMapping("/phones/{id}")
    public Telephone changePhone(@RequestBody Telephone phone, @PathVariable long id) throws URISyntaxException {
        Optional<Telephone> updatePhone = telephonerepos.findById(id);
        if (updatePhone.isPresent()) {
            // not sure wether to think about relation
            phone.setPhoneid(id);
            telephonerepos.save(phone);
            return phone;
        } else {
            return null;
        }
    }
    // might need to return String
    @DeleteMapping("/phones/{id}")
    public Telephone deleteTelephone(@PathVariable long id) throws URISyntaxException {
        var deleteTelephone = telephonerepos.findById(id);
        if (deleteTelephone.isPresent()) {
            telephonerepos.deleteById(id);
            return  deleteTelephone.get();
        } else {
            return null;
        }
    }
    @PostMapping("/animals")
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalrepos.save(animal);
    }
    @PutMapping("/animals/{id}")
    public Animal changeAnimal(@RequestBody Animal animal, @PathVariable long id) throws URISyntaxException {
        Optional<Animal> updateAnimal = animalrepos.findById(id);
        if (updateAnimal.isPresent()) {
            // not sure whether to have other relations
            animal.setAnimalid(id);
            animalrepos.save(animal);
            return animal;
        } else {
            return null;
        }
    }
    // might need to return Strin
    @DeleteMapping("/animals/{id}")
    public Animal deleteAnimal(@PathVariable long id) throws URISyntaxException {
        var deleteAnimal = animalrepos.findById(id);
        if (deleteAnimal.isPresent()) {
            animalrepos.deleteById(id);
            return deleteAnimal.get();
        } else {
            return null;
        }
    }


}
