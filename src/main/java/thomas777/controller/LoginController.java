package thomas777.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;




@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Model model,
                        HttpSession session) {

        Object loggedOn = session.getAttribute("userID");
        if (loggedOn != null) {
            return "redirect:/admin";
        }

        return "login";
    }


    @RequestMapping("/logging")
    public String logging(@RequestParam("password") String password,
                        Model model,
                        HttpSession session) {

        Object loggedOn = session.getAttribute("userID");
        if (loggedOn != null) {
            return "redirect:/admin";
        }

        String pass = "password";
        boolean isLogin = pass.equals(password);
        if (isLogin) {
            session.setAttribute("userID", 777);
            return "redirect:/admin";
        } else {
            model.addAttribute("msg", "Invalid login information. Please try again.");
            return "login";
        }
    }


    @RequestMapping("/logout")
    public String signup(HttpSession session) {
        Object isLogin = session.getAttribute("userID");
        if (isLogin != null) {
            session.removeAttribute("userID");
            return "redirect:/";
        }
        return "index";
    }
}
