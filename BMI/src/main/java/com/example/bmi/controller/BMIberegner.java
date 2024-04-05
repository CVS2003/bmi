package com.example.bmi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BMIberegner {

    double bmi;

    @GetMapping("/")
    public String design() {

        return "design";
    }

    @PostMapping("/processForm")
    public String processUserInput(@RequestParam("weight") double weight,
                                   @RequestParam("height") double height, RedirectAttributes redirectAttributes) {

        bmi = weight/((height/100)*(height/100));

        redirectAttributes.addAttribute("redirectText", bmi);

        return "redirect:/showBMIResult";

    }

    @GetMapping("/showBMIResult")
    public String viewResult(@RequestParam("redirectText") double bmi, Model model) {

        model.addAttribute("bmi", bmi);

        return "result";
    }

}
