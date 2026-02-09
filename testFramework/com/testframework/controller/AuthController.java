package testFramework.com.testframework.controller;

import framework.annotation.Controller;
import framework.annotation.GetMapping;
import framework.annotation.Auth;
import framework.session.Session;
import framework.utilitaire.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public ModelAndView login(Session session) {
        session.put("isConnected", true);
        session.put("userRole", "user");
        ModelAndView mv = new ModelAndView("auth-status");
        mv.addObject("message", "Vous êtes maintenant connecté en tant qu'utilisateur simple.");
        return mv;
    }

    @GetMapping("/auth/login-admin")
    public ModelAndView loginAdmin(Session session) {
        session.put("isConnected", true);
        session.put("userRole", "admin");
        ModelAndView mv = new ModelAndView("auth-status");
        mv.addObject("message", "Vous êtes maintenant connecté en tant qu'Administrateur.");
        return mv;
    }

    @GetMapping("/auth/logout")
    public ModelAndView logout(Session session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("auth-status");
        mv.addObject("message", "Vous avez été déconnecté.");
        return mv;
    }

    @GetMapping("/auth/protected")
    @Auth
    public ModelAndView protectedPage() {
        ModelAndView mv = new ModelAndView("auth-status");
        mv.addObject("message", "Félicitations ! Vous accédez à une page protégée (authentification requise).");
        return mv;
    }

    @GetMapping("/auth/admin")
    @Auth("admin")
    public ModelAndView adminPage() {
        ModelAndView mv = new ModelAndView("auth-status");
        mv.addObject("message", "Bienvenue sur la zone ADMIN (rôle 'admin' requis).");
        return mv;
    }
}
