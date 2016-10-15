package com.github.mikhalechko.controller;

import com.github.mikhalechko.dao.UserDao;
import com.github.mikhalechko.entity.User;
import com.github.mikhalechko.validation.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(types = User.class)
//@RequestMapping("/")
public class RegistrationController {

    @Autowired
    FormValidator formValidator;
    @Autowired
    UserDao userDao;
    @Autowired
    HttpSession session;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(Model model) {
        User u = new User();
        model.addAttribute("reg", u);
        return "registration";
    }

    @RequestMapping(value = "/userregistration", method = RequestMethod.POST)
    public ModelAndView doRegistration(@ModelAttribute("reg") @Validated User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        } else {
            modelAndView.setViewName("confirmation");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String getConfirmation(SessionStatus status) {
        userDao.create((User) session.getAttribute("reg"));
        status.setComplete(); //обнулить сесию
        return "login";
    }

    @InitBinder
    protected void initValidator(WebDataBinder binder) {
        binder.setValidator(formValidator);
    }
}
