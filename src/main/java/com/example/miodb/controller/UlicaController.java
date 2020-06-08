package com.example.miodb.controller;


import com.example.miodb.model.Ulica;
import com.example.miodb.repository.UlicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UlicaController {

    @Autowired
    private UlicaRepository ulicaRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showTrace(Model model){

        List<String> uliceNazwa = ulicaRepository.getAllUlica();

        //ArrayList<Ulica> ul = new ArrayList<>();

     //  ul.add(new Ulica("nazwa1"));
      //  ul.add(new Ulica("nazwa2"));

        model.addAttribute("ulice", uliceNazwa);
        return "index";
    }

}
