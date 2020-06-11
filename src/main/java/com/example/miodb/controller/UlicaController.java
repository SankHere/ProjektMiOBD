package com.example.miodb.controller;

import com.example.miodb.model.Polaczenie;
import com.example.miodb.model.Test;
import com.example.miodb.model.Trasa;
import com.example.miodb.model.Ulica;
import com.example.miodb.repository.UlicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collection;
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

        switch(trasa.getTransport()){
            case "samochod":

                break;
            case "autobus":

                break;
            case "pieszo":
                //metoda wyszukująca nakrótszą scieżkę
                Test najkrótszaDroga = najkrotszaDroga(trasa.getUlicaSkad(), trasa.getUlicaDokad());
                String test = "test";
                break;
        }
        return "index";
    }

    public Test najkrotszaDroga(String ulica1, String ulica2){

       Test najkrotszaDroga = ulicaRepository.getShortesPath(ulica1, ulica2);

        return najkrotszaDroga;
    }
}
