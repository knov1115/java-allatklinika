package org.example.repository;

import org.example.model.Pet;
import org.example.util.IdProvider;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PetRepository {

    private static final PetRepository PET_REPOSITORY = new PetRepository();
    private final IdProvider idProvider;

    private final List<Pet> petList;

    private PetRepository() {
        this.idProvider = IdProvider.getInstance();
        this.petList = this.initList();
    }

    public Pet save(Pet pet) {
        pet.setId(this.idProvider.nextId());
        this.petList.add(pet);
        return pet;
    }

    public Pet update(Pet pet) {
        Pet current = this.petList.stream()
                .filter(pet::equals)
                .findFirst()
                .get();

        int i = this.petList.indexOf(current);
        this.petList.add(i, pet);
        return pet;
    }

    public Optional<Pet> findById(Long id) {
        return this.petList.stream().filter(p -> Objects.equals(id, p.getId())).findFirst();
    }

    public List<Pet> listAll() {
        return new ArrayList<>(this.petList);
    }

    public static PetRepository getInstance() {
        return PET_REPOSITORY;
    }

    private List<Pet> initList() {
        ArrayList<Pet> petList = new ArrayList<>();

        petList.add(new Pet(this.idProvider.nextId(), "Béla", "33RF5342", "Dummy Address 42", "cat"));
        petList.add(new Pet(this.idProvider.nextId(), "Bobi", "37YX5342", "Dummy Address 42", "dog"));
        petList.add(new Pet(this.idProvider.nextId(), "Overdose", "12TE7812", "Dummy Address 11", "horse"));
        petList.add(new Pet(this.idProvider.nextId(), "Harambe", "64BC3278", "Dummy Address 32", "gorilla"));

        return petList;
    }

    public boolean delete(Long id) {
        Optional<Pet> pet = this.petList.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();

        return pet.map(this.petList::remove).orElse(false);
    }

}
