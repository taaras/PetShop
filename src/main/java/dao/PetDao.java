package dao;

import model.Pet;

import java.util.List;

public interface PetDao {
    public void addPet(Pet pet);
    public void updatePet(Pet pet);
    public void removePet(int id);
    public Pet getPetById(int id);
    public List<Pet> listPets();
}
