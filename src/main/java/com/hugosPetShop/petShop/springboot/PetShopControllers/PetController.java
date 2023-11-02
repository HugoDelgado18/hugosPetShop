package com.hugosPetShop.petShop.springboot.PetShopControllers;

import com.hugosPetShop.petShop.springboot.exception.PetNotFoundException;
import com.hugosPetShop.petShop.springboot.models.Pet;
import com.hugosPetShop.petShop.springboot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping(path = "/pets")
    public List<Pet> retrieveAllPets() {
        return petRepository.findAll();
    }

    @GetMapping(path = "/pets/{id}")
    Pet getPetById(@PathVariable Long id) {
        return petRepository.findById(id)
                .orElseThrow(()-> new PetNotFoundException(id));
    }

    @PostMapping("/pets")
    Pet newPet(@RequestBody Pet newPet){
        return petRepository.save(newPet);
    }

    @PutMapping("/pets/{id}")
    Pet editPet(@RequestBody Pet newPet,  @PathVariable Long id){
        return petRepository.findById(id)
                .map(petDetails -> {
                    if (newPet.getName() != null) {
                        petDetails.setName(newPet.getName());
                    }
//                    petDetails.setName(newPet.getName());
                    if (newPet.getAge() != null) {
                        petDetails.setAge(newPet.getAge());
                    } else {
                        petDetails.setAge(petDetails.getAge());
                    }
//                    petDetails.setAge(newPet.getAge());
                    if (newPet.getBreed() != null) {
                        petDetails.setBreed(newPet.getBreed());
                    }
//                    petDetails.setBreed(newPet.getBreed());
                    if (newPet.getPrice() != null) {
                        petDetails.setPrice(newPet.getPrice());
                    }
//                    petDetails.setPrice(newPet.getPrice());
                    if (newPet.isAvailable()) {
                        petDetails.setAvailable(newPet.isAvailable());
                    }
//                    petDetails.setAvailable(newPet.isAvailable());
                    return petRepository.save(petDetails);
                }).orElseThrow(()-> new PetNotFoundException(id));
    }

    @DeleteMapping("/pets/{id}")
    String  DeletePet(@PathVariable Long id){
        if(!petRepository.existsById(id)){
            throw new PetNotFoundException((id));
        }
        petRepository.deleteById(id);
        return "Pet has been deleted";
    }

}
