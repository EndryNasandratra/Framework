package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.annotation.PostMapping;
import framework.annotation.ModelAttribute;
import framework.utilitaire.ModelAndView;
import testFramework.com.testframework.model.EmployeDTO;

@Controller
public class EmployeController {

    @GetMapping("/employe/form")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("employe-form");
        mv.addObject("employe", new EmployeDTO());
        return mv;
    }

    @PostMapping("/employe/save")
    public ModelAndView save(@ModelAttribute EmployeDTO employe) {
        System.out.println("Employe: " + employe.getNom());
        if (employe.getDept() != null) {
            System.out.println("Departement: " + employe.getDept().getNomDept());
        }
        if (employe.getLieu() != null) {
            System.out.println("Lieu: " + employe.getLieu().getVille());
        }

        ModelAndView mv = new ModelAndView("employe-form");
        mv.addObject("employe", employe);
        mv.addObject("message", "Employe sauvegarde (voir console serveur).");
        return mv;
    }
}
