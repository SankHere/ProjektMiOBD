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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class UlicaController {

    @Autowired
    private UlicaRepository ulicaRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String wybierzTrase(Model model){

        List<String> uliceNazwa = ulicaRepository.getAllUlica();

        model.addAttribute("wyszukanie", "Nie");

        model.addAttribute("ulice", uliceNazwa);
        return "index";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String pokazTrase(Model model, @Valid @ModelAttribute("trasa") Trasa trasa){

        switch(trasa.getTransport()){
            case "samochod":

                Iterable<Map<String, Object>> samochodDrogas = ulicaRepository.getSamochodPath(trasa.getUlicaSkad(), trasa.getUlicaDokad());

                ArrayList<Object> valueSamochod = new ArrayList<Object>();

                for (Map<String, Object> samochodDroga : samochodDrogas) {
                    for (Map.Entry<String, Object> entry : samochodDroga.entrySet()) {

                        //key.add(entry.getKey());
                        valueSamochod.add(entry.getValue());
                    }
                }

                model.addAttribute("values", valueSamochod);
                model.addAttribute("wyszukanie", "samochod");
                break;
            case "autobus":

                Iterable<Map<String, Object>> autobusDrogas = ulicaRepository.getAutobusPath(trasa.getUlicaSkad(), trasa.getUlicaDokad());

                ArrayList<Object> valueAutobus = new ArrayList<Object>();

                for (Map<String, Object> autobusDroga : autobusDrogas) {
                    for (Map.Entry<String, Object> entry : autobusDroga.entrySet()) {

                        //key.add(entry.getKey());
                        valueAutobus.add(entry.getValue());
                    }
                }

                model.addAttribute("values", valueAutobus);
                model.addAttribute("wyszukanie", "autobus");
                break;
            case "pieszo":
                //metoda wyszukująca nakrótszą scieżkę
                Iterable<Map<String, Object>> najkrotszaDrogas = ulicaRepository.getShortesPath(trasa.getUlicaSkad(), trasa.getUlicaDokad());

                ArrayList<Object> valuePieszo = new ArrayList<Object>();

                for (Map<String, Object> najkrotszaDroga : najkrotszaDrogas) {
                    for (Map.Entry<String, Object> entry : najkrotszaDroga.entrySet()) {

                        //key.add(entry.getKey());
                        valuePieszo.add(entry.getValue());
                    }
                }

                //model.addAttribute("keys", key);
                model.addAttribute("values", valuePieszo);
                model.addAttribute("wyszukanie", "pieszo");
                break;
            case "wszystko":

                Iterable<Map<String, Object>> pieszoDrogas = ulicaRepository.getPieszoPath(trasa.getUlicaSkad(), trasa.getUlicaDokad());
                Iterable<Map<String, Object>> autDrogas = ulicaRepository.getAutobusPath(trasa.getUlicaSkad(), trasa.getUlicaDokad());
                Iterable<Map<String, Object>> samoDrogas = ulicaRepository.getSamochodPath(trasa.getUlicaSkad(), trasa.getUlicaDokad());

                ArrayList<Object> valueee = new ArrayList<Object>();

                valueee.add("Pieszo: -> ");
                for (Map<String, Object> pieszoDroga : pieszoDrogas) {
                    for (Map.Entry<String, Object> entry : pieszoDroga.entrySet()) {

                        valueee.add(entry.getValue());
                    }
                }

                valueee.add("Autobus: -> ");
                for (Map<String, Object> autDroga : autDrogas) {
                    for (Map.Entry<String, Object> entry : autDroga.entrySet()) {

                        valueee.add(entry.getValue());
                    }
                }
                valueee.add("Samochód: -> ");
                for (Map<String, Object> samoDroga : samoDrogas) {
                    for (Map.Entry<String, Object> entry : samoDroga.entrySet()) {

                        valueee.add(entry.getValue());
                    }
                }


                model.addAttribute("values", valueee);
                model.addAttribute("wyszukanie", "wszystko");
                break;
        }

        //zeby w indexie widziało ulice wszystkie
        List<String> uliceNazwa = ulicaRepository.getAllUlica();

        model.addAttribute("ulice", uliceNazwa);

        return "index";
    }


}
