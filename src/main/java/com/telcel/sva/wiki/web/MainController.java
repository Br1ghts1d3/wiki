package com.telcel.sva.wiki.web;

import com.telcel.sva.wiki.model.Profile;
import com.telcel.sva.wiki.model.Service;
import com.telcel.sva.wiki.repository.ProfileRepository;
import com.telcel.sva.wiki.repository.ServiceRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {


    private final ServiceRepository serviceRepository;
    private final ProfileRepository profileRepository;

    public MainController(ServiceRepository serviceRepository, ProfileRepository profileRepository) {
        this.serviceRepository = serviceRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Profile> profiles = profileRepository.findAll();
        StringBuilder profiles2 = new StringBuilder();
        for (com.telcel.sva.wiki.model.Profile profile: profiles) {
            profiles2.insert(0, profile.getProfile() + ", ");
        }
        model.addAttribute("perfiles", profiles2.substring(0, profiles2.length() -2));
        return "index";
    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @GetMapping(value="/services/mitelcel")
    public String services(Model model){

        List<Service> services = serviceRepository.findAll();
        model.addAttribute("servicios", services);
        return "services";
    }


}