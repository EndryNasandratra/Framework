package testFramework.com.testframework.controller;

import framework.annotation.RestController;
import framework.annotation.RequestMapping;
import framework.annotation.GetMapping;
import framework.annotation.ResponseBody;
import testFramework.com.testframework.model.*;
//import testFramework.com.testFramework.model.Departement;

@RestController
@RequestMapping("/api")
public class EmployeRestController {
    
    @GetMapping("/employes")
    public Employee[] getAllEmployes() {
        Employee emp1=new Employee();
        emp1.setEmail("valy@gmail.com");
        emp1.setFirstName("Valimbavaka");
        emp1.setLastName("ETU003157");
        return new Employee[] { emp1};
    }
    
    @GetMapping("/employe")
    public EmployeDTO getEmploye() {
        EmployeDTO emp = new EmployeDTO();
        emp.setNom("Test");
        return emp;
    }
}
