package com.example.miodb.controller;

import com.example.miodb.model.Trasa;
import com.example.miodb.repository.UlicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UlicaController {

    @Autowired
    private UlicaRepository ulicaRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String wybierzTrase(Model model){

        List<String> uliceNazwa = ulicaRepository.getAllUlica();


        model.addAttribute("ulice", uliceNazwa);
        return "index";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String pokazTrase(Model model, @Valid @ModelAttribute("trasa") Trasa trasa){


        String asd = null;

        return "index";
    }

}
