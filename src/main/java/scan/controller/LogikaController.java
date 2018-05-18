package scan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scan.service.LogikaService;

import java.util.List;

@Controller
public class LogikaController {
    private LogikaService logikaService;
    private static final String VIEW_LISTA = "/lista";
    private static final String VIEW_LISTA_REDIRECT = "redirect:/lista";
    private static final String MODEL_LISTA = "pobierzListe";
    private static final String MODEL_LISTA_DODAJ = "dodajProdukt";
  //  private static final String VIEW_CSS = "styles/css/style.css";

    @Autowired
    public LogikaController(LogikaService logikaService){
        this.logikaService = logikaService;
    }

    @RequestMapping (value = "/lista", method = RequestMethod.GET)
    public String showListProduct(Model model){
        model.addAttribute(MODEL_LISTA, logikaService.pobierzDane());

        return VIEW_LISTA;
    }

    @RequestMapping (value = "/lista", method = RequestMethod.POST)
    public String addListProduct(@RequestParam String dane){
    if(dane != null) logikaService.dodajDane(dane);
    return new String(VIEW_LISTA_REDIRECT);
    }

    @RequestMapping (value = "/lista/edit/{productId}")
    public String getProduct(@PathVariable("productId") int id, Model model){
        //model.addAttribute(MODEL_LISTA, logikaService.pobierzDane());
        model.addAttribute(MODEL_LISTA, logikaService.pobierzDanePoId(id));
        return new String(VIEW_LISTA_REDIRECT);
    }

//    @RequestMapping (value = "/lista", method = RequestMethod.GET)
//    public ModelAndView pokazWszystko(){
//        List<String> all = logikaService.pobierzDane();
//        ModelAndView nawigacjaDoListy = new ModelAndView(VIEW_LISTA);
//        nawigacjaDoListy.addObject(MODEL_LISTA, all);
//        return nawigacjaDoListy;
//    }

//    @RequestMapping (value ="/styles/css", method = RequestMethod.GET)
//    public ModelAndView pokazCss(){
//        ModelAndView cssWczytaj = new ModelAndView(VIEW_CSS);
//        return cssWczytaj;
//    }

//    @RequestMapping (value = "/lista", method = RequestMethod.POST)
//    public String addListProduct(@RequestParam String dane){
//    if(dane != null) logikaService.dodajDane(dane);
//    return new String(VIEW_LISTA_REDIRECT);
//    }


//    @RequestMapping (value = "/lista", method = RequestMethod.POST )
//    public ModelAndView dodajKolejny(@RequestParam String dane){
//        if(dane != null) logikaService.dodajDane(dane);
//        return new ModelAndView("redirect:/lista");
//
//    }

}
