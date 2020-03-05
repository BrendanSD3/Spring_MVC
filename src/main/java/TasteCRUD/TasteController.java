/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasteCRUD;
import Model.Breweries;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;

/**
 *
 * @author k00214874
 */
  @Controller
@RequestMapping("/taste")
@SessionAttributes("taste")
public class TasteController {
  

    @Autowired
    TasteService service;
        
    //@GetMapping("/view")
    @RequestMapping("/view")
    public ModelAndView getall(){
        //System.out.println("Getting Called");
        List <Breweries> b = service.getAllBreweries();
        //System.out.println("Printingreturnedlist" + b);
        return new ModelAndView("/ViewAll", "List", b);
    }
    @GetMapping("/display{id}")
    public ModelAndView displayAgent(@QueryParam("id") int id){
      Breweries b = service.getbrewByID(id);
        
        return new ModelAndView("/display","brew", b);
    
    }
     @GetMapping("/add")
    public ModelAndView displayBreweryAddForm(){
        return new ModelAndView("/addBrewery","brew",new Breweries());
    
    }
    //@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    @PostMapping("/addBrewery")
    public ModelAndView addBrew(@Valid @ModelAttribute("brew")Breweries brew, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("results"+ result);
             return new ModelAndView("/error");
        }
        
        service.addBrewery(brew);
        //route the user to the next page
        return new ModelAndView("redirect:/taste/view");
    }                      
    
}
