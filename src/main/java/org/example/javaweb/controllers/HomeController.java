package org.example.javaweb.controllers;

import org.example.javaweb.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "/")
    String empty(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("activeFunction", "home");
        model.addAttribute("products", productRepository.findAll());

        if (principal != null) {
            model.addAttribute("username", principal.getAttribute("login"));
        }

        return "products";
    }

    @GetMapping(path = "/list")
    String list(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("activeFunction", "home");
        model.addAttribute("products", productRepository.findAll());

        if (principal != null) {
            model.addAttribute("username", principal.getAttribute("login"));
        }

        return "list";
    }

    @GetMapping(path = "/admin")
    String admin(Model model, @AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getAttribute("login"));
        }
        return "admin";
    }
}
