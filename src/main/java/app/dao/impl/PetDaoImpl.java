package app.dao.impl;

import app.dao.PetDao;
import app.model.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetDaoImpl implements PetDao {
    private static final Logger logger = LoggerFactory.getLogger(PetDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPet(Pet pet) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(pet);
        logger.info("Pet successfully saved. Pet details: " + pet);
    }

    public void updatePet(Pet pet) {
        Session session = sessionFactory.getCurrentSession();
        session.update(pet);
        logger.info("Pet successfully updated. Pet details: " + pet);
    }

    public void removePet(int id) {
        Session session = sessionFactory.getCurrentSession();
        Pet pet = (Pet) session.load(Pet.class, id);

        if(pet != null){
            session.delete(pet);
        }
        logger.info("Pet successfully deleted. Pet details: " + pet);
    }

    public Pet getPetById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Pet pet = (Pet) session.load(Pet.class, id);
        logger.info("Pet successfully loaded. Pet details: " + pet);
        return pet;
    }

    @SuppressWarnings("unchecked")
    public List<Pet> listPets() {
        Session session = sessionFactory.getCurrentSession();
        List <Pet> petList = session.createQuery("from Pet").list();

        for(Pet pet : petList){
            logger.info("Pet list: " + pet);
        }

        return petList;
    }
}
