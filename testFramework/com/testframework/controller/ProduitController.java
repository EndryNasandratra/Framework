package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.annotation.PathVariable;
import framework.utilitaire.ModelAndView;

@Controller
public class ProduitController {

    @GetMapping("/produits/{id}")
    public ModelAndView detail(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("produit-detail");
        mv.addObject("title", "Détail produit")
          .addObject("id", id)
          .addObject("name", "Produit #" + id)
          .addObject("price", 19.99 + id);
        return mv;
    }
}
