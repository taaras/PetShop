package app.service;

import app.model.Species;

import java.util.List;

public interface SpeciesService {
    public void addSpecies(Species species);
    public void updateSpecies(Species species);
    public void removeSpecies(int id);
    public Species getSpeciesById(int id);
    public List<Species> listSpecies();
}
