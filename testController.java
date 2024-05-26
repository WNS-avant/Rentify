package Testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Testing.entity.Property;
import Testing.entity.User;
import Testing.service.PropertyService;
import Testing.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class testController {

    @Autowired
    UserService userv;

    @Autowired
    PropertyService pserv;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @GetMapping("/sellerHome")
    public String sellerHomePage() {
        return "seller";
    }

    @GetMapping("/property")
    public String property() {
        return "propertyPage";
    }

    @GetMapping("/success")
    public String success(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userv.getUser(email);
        return email;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/more")
    public List<Property> viewMore(Model model) {
        List<Property> properties = pserv.display();
        model.addAttribute("properties", properties);
        return properties;
    }

    @GetMapping("/propertyDisplay")
    public String displayProp(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            System.out.println("Email not found in session");
            return "error";
        }
        User user = userv.getUser(email);
        if (user == null) {
            System.out.println("User not found for email: " + email);
            return "error";
        }
        System.out.println("User found: " + user);
        List<Property> propList = pserv.display();
        model.addAttribute("sellerProperties", propList);
        return "display";
    }

    @PostMapping("/entry")
    public String loggedIn(Model model, @RequestParam String email, @RequestParam String password, HttpSession session) {
        boolean result = userv.check(email);
        boolean res = userv.validate(email, password);
        if (result && res) {
            User user = userv.getUser(email);
            if (user != null) {
                String role = user.getRole();
                session.setAttribute("email", email);
                session.setAttribute("role", role);
                model.addAttribute("firstName", user.getFirstName());
                if ("SELLER".equals(role)) {
                    System.out.println("valid seller");
                    return "seller";
                } else if ("BUYER".equals(role)) {
                    System.out.println("valid Buyer");
                    return "home";
                }
            } else {
                System.out.println("User not found");
                return "noExist";
            }
        } else {
            System.out.println("Invalid credentials");
            return "noExist";
        }
        return email;
    }

    @PostMapping("/register")
    public String SignedIn(User u, @RequestParam String email) {
        boolean result = userv.check(email);
        if (!result) {
            String msg = userv.create(u);
            System.out.println(msg);
            return "login";
        } else {
            return "exist";
        }
    }

    @PostMapping("/addProperty")
    public String addProperty(Property p) {
        String msg = pserv.create(p);
        System.out.println(msg);
        return "confirmation";
    }

    @PostMapping("/delete")
    public String deleteProp(@ModelAttribute Property p, @RequestParam String propertyName) {
    	pserv.delete(p, propertyName);
        return "seller";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index";

    }

}
