package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.annotation.PostMapping;
import framework.utilitaire.FormMapper;
import framework.utilitaire.ModelAndView;
import testFramework.com.testframework.model.UserForm;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("user-form");
        mv.addObject("user", new UserForm());
        return mv;
    }

    @PostMapping("/users/register")
    public ModelAndView handleRegistration(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        Map<String, Object> simpleMap = new HashMap<>();
        for (Map.Entry<String, String[]> e : paramMap.entrySet()) {
            String[] vals = e.getValue();
            simpleMap.put(e.getKey(), (vals != null && vals.length > 0) ? vals[0] : null);
        }

        UserForm form = FormMapper.map(simpleMap, UserForm.class);
        boolean valid = form.isValid();

        ModelAndView mv = new ModelAndView("user-form");
        mv.addObject("user", form);
        mv.addObject("valid", valid);
        mv.addObject("errors", form.getLastValidationResult() != null ? form.getLastValidationResult().getFieldErrors() : java.util.Collections.emptyMap());
        return mv;
    }
}
