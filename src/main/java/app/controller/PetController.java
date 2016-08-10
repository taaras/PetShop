package app.controller;

import app.model.Pet;
import app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PetController {
    private PetService petService;

    @Autowired(required = true)
    @Qualifier(value = "petService")
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(value = "pets", method = RequestMethod.GET)
    public String listPets(Model model){
        model.addAttribute("pet", new Pet());
        model.addAttribute("listPets", petService.listPets());

        return "pets";
    }

    @RequestMapping(value = "/pets/add", method = RequestMethod.POST)
    public String addPet(@ModelAttribute("pet") Pet pet){
        if(pet.getId() == 0){
            petService.addPet(pet);
        }else{
            petService.updatePet(pet);
        }

        return "redirect:/pets";
    }

    @RequestMapping(value = "/pets/remove/{id}")
    public String removePet(@PathVariable("id") int id){
        petService.removePet(id);

        return "redirect:/pets";
    }

    @RequestMapping(value = "/pets/edit/{id}")
    public String editPet(@PathVariable("id")int id, Model model){
        model.addAttribute("pet", petService.getPetById(id));
        model.addAttribute("listPets", petService.listPets());

        return "pets";
    }

    @RequestMapping("petdata/{id}")
    public String petData(@PathVariable("id") int id, Model model){
        model.addAttribute("pet", petService.getPetById(id));

        return "petdata";
    }
}
