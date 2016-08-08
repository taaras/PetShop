package app.service.impl;

import app.dao.PetDao;
import app.model.Pet;
import app.service.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    private PetDao petDao;

    public void setPetDao(PetDao petDao) {
        this.petDao = petDao;
    }

    @Transactional
    public void addPet(Pet pet) {
        petDao.addPet(pet);
    }

    @Transactional
    public void updatePet(Pet pet) {
        petDao.updatePet(pet);
    }

    @Transactional
    public void removePet(int id) {
        petDao.removePet(id);
    }

    @Transactional
    public Pet getPetById(int id) {
        return petDao.getPetById(id);
    }

    @Transactional
    public List<Pet> listPets() {
        return petDao.listPets();
    }
}
