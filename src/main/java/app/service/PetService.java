package app.service;

import app.model.Pet;

import java.util.List;

public interface PetService {
    public void addPet(Pet pet);
    public void updatePet(Pet pet);
    public void removePet(int id);
    public Pet getPetById(int id);
    public List<Pet> listPets();
}
