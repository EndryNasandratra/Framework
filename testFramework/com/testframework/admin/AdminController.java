package testFramework.com.testframework.admin;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.annotation.PostMapping;
import framework.annotation.RequestParam;
import framework.utilitaire.ModelAndView;
import testFramework.com.testframework.model.Employee;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "aizazzz";
    }
    
    @GetMapping("/admin/settings")
    public String settings() {
        return "Admin settings";
    }

    @GetMapping("/admin/page")
    public ModelAndView page() {
        // Restituer la vue "admin" -> resolu en /WEB-INF/views/admin.jsp (via view.prefix/suffix)
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("title", "Tableau de bord Admin")
          .addObject("message", "Bienvenue sur la page admin rendue via JSP")
          .addObject("count", 3);
        return mv;
    }

    @GetMapping("/admin/employees")
    public ModelAndView employees() {
        List<Employee> list = Arrays.asList(
                new Employee(1, "Alice", "Martin", "alice@example.com", "Manager"),
                new Employee(2, "Bob", "Durand", "bob@example.com", "Developer"),
                new Employee(3, "Chloe", "Bernard", "chloe@example.com", "QA")
        );
        ModelAndView mv = new ModelAndView("employees");
        mv.addObject("employees", list)
          .addObject("title", "Liste des employes");
        return mv;
    }

    @GetMapping("/admin/echo")
    public ModelAndView echoForm() {
        ModelAndView mv = new ModelAndView("echo");
        mv.addObject("title", "Echo Form");
        return mv;
    }


    @PostMapping("/admin/echo")
    public ModelAndView echoPost(@RequestParam("msg") String message, @RequestParam(value = "count", required = false, defaultValue = "1") int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(1, count); i++) {
            if (i > 0) sb.append(" <br/>");
                sb.append(message);
        }
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("title", "Echo POST")
            .addObject("message", sb.toString())
            .addObject("count", count);
        return mv;
    }
}
