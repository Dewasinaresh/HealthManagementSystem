package com.HMS.Latest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/Home")
public class WelcomeController {
    @GetMapping("/welcome")
    public ModelAndView getHomePage()
    {
        ModelAndView model=new ModelAndView("Home");
        return model;

    }
}
