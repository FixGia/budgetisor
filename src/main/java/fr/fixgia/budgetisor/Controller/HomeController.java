package fr.fixgia.budgetisor.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Method Controller - GET - homePage
     * @return the home page
     */
    @GetMapping({"/"})
    public String getHomePage(final Model model, @Param("keyword") final String keyword) {

        model.addAttribute("keyword", keyword);
        return "home";
    }
}
