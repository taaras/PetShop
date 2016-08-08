package app.dao;

import app.model.Species;
import java.util.List;

/**
 * Created by Тарас on 08.08.2016.
 */
public interface SpeciesDao {
    public void addSpecies(Species species);
    public void updateSpecies(Species species);
    public void removeSpecies(int id);
    public Species getSpeciesById(int id);
    public List<Species> listSpecies();
}
