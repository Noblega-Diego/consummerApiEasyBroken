package com.dn.challange.challangeeasybroken.controllers;

import com.dn.challange.challangeeasybroken.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @GetMapping("/{page}")
    public String listProperty(@PathVariable("page") Integer page, Model model){
        model.addAttribute("properties", service.PageProperty(page));
        return "properties";
    }

}
