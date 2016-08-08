package app.service.impl;

import app.dao.SpeciesDao;
import app.model.Species;
import app.service.SpeciesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpeciesServiceImpl  implements SpeciesService{
    private SpeciesDao speciesDao;

    public void setSpeciesDao(SpeciesDao speciesDao) {
        this.speciesDao = speciesDao;
    }

    @Transactional
    public void addSpecies(Species species) {
        speciesDao.addSpecies(species);
    }

    @Transactional
    public void updateSpecies(Species species) {
        speciesDao.updateSpecies(species);
    }

    @Transactional
    public void removeSpecies(int id) {
        speciesDao.removeSpecies(id);
    }

    @Transactional
    public Species getSpeciesById(int id) {
        return speciesDao.getSpeciesById(id);
    }

    @Transactional
    public List<Species> listSpecies() {
        return speciesDao.listSpecies();
    }
}
