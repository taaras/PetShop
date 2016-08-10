package app.controller;

import app.model.Pet;
import app.model.Species;
import app.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpeciesController {
    private SpeciesService speciesService;

    @Autowired(required = true)
    @Qualifier(value = "speciesService")
    public void setSpeciesService(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }


    @RequestMapping(value = "species", method = RequestMethod.GET)
    public String listSpecies(Model model){
        model.addAttribute("species", new Pet());
        model.addAttribute("listSpecies", speciesService.listSpecies());

        return "species";
    }

    @RequestMapping(value = "/species/add", method = RequestMethod.POST)
    public String addSpecies(@ModelAttribute("species") Species species){
        if(species.getId() == 0){
            speciesService.addSpecies(species);
        }else{
            speciesService.updateSpecies(species);
        }

        return "redirect:/species";
    }

    @RequestMapping(value = "/species/remove/{id}")
    public String removeSpecies(@PathVariable("id") int id){
        speciesService.removeSpecies(id);

        return "redirect:/species";
    }

    @RequestMapping(value = "/species/edit/{id}")
    public String editSpecies(@PathVariable("id")int id, Model model){
        model.addAttribute("species", speciesService.getSpeciesById(id));
        model.addAttribute("listSpecies", speciesService.listSpecies());

        return "species";
    }

    @RequestMapping("speciesdata/{id}")
    public String speciesData(@PathVariable("id") int id, Model model){
        model.addAttribute("species", speciesService.getSpeciesById(id));

        return "speciesdata";
    }
}
