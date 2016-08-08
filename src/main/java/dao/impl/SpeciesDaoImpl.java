package dao.impl;

import dao.SpeciesDao;
import model.Species;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SpeciesDaoImpl implements SpeciesDao{
    Logger logger = LoggerFactory.getLogger(SpeciesDaoImpl.class);

    private SessionFactory sessionFactory;

    public void addSpecies(Species species) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(species);
        logger.info("Species successfully saved. Species details: " + species);
    }

    public void updateSpecies(Species species) {
        Session session = sessionFactory.getCurrentSession();
        session.update(species);
        logger.info("Species successfully updated. Species details: " + species);
    }

    public void removeSpecies(int id) {
        Session session = sessionFactory.getCurrentSession();
        Species species = (Species) session.load(Species.class, id);

        if(species != null){
            session.delete(species);
        }
        logger.info("Species successfully deleted. Species details: " + species);
    }

    public Species getSpeciesById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Species species = (Species) session.load(Species.class, id);
        logger.info("Species successfully loaded. Species details: " + species);
        return species;
    }

    @SuppressWarnings("unchecked")
    public List<Species> listSpecies() {
        Session session = sessionFactory.getCurrentSession();
        List <Species> speciesList = session.createQuery("from Species").list();

        for(Species species : speciesList){
            logger.info("Species list: " + species);
        }

        return speciesList;
    }
}
