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
        //Employee emp= new  Employee();
        //emp.setNom(employe.getNom());
        System.out.println("Employé: " + employe.getNom());
        if (employe.getDept() != null) {
            System.out.println("Département: " + employe.getDept().getNomDept());
        }
        if (employe.getLieu() != null) {
            System.out.println("Lieu: " + employe.getLieu().getVille());
        }

        ModelAndView mv = new ModelAndView("employe-form");
        mv.addObject("employe", employe);
        mv.addObject("message", "Employé sauvegardé (voir console serveur).");
        return mv;
    }
}
