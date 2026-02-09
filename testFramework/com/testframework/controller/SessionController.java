package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.utilitaire.ModelAndView;
import framework.session.Session;

@Controller
public class SessionController {

    @GetMapping("/session/test")
    public ModelAndView test(Session session) {
        Object v = session.get("count");
        int count = v instanceof Integer ? ((Integer) v) + 1 : 1;
        session.put("count", count);

        ModelAndView mv = new ModelAndView("session-test");
        mv.addObject("sid", session.getId());
        mv.addObject("count", count);
        return mv;
    }
}
