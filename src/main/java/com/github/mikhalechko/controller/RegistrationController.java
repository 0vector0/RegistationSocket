package com.github.mikhalechko.controller;

import com.github.mikhalechko.entiry.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(types = User.class)
//@RequestMapping("/")
public class RegistrationController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(Model model) {
        User u = new User();
        model.addAttribute("reg", u);
        return "registration";
    }

    @RequestMapping(value = "/userregistration", method = RequestMethod.POST)
    public ModelAndView doRegistration(@ModelAttribute("reg") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirmation");
        return modelAndView;
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String getConfirmation(SessionStatus status) {
        status.setComplete(); //обнулить сесию
        return "login";
    }
}
