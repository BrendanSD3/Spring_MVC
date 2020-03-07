/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasteCRUD;
import Model.Breweries;
import Model.BreweriesGeocode;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

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
import java.util.ListIterator;
import javax.mail.Session;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
      BindingResult result, ModelMap model, RedirectAttributes attr) {
         if (result.hasErrors()) {
             
            System.out.println("results"+ result);
             return new ModelAndView("/addBrewery","brew",brew);
        }
        Integer maxbreweryid=service.getmaxBreweryID()+1;
        System.out.println("Breweryid"+maxbreweryid);
        brew.setBrewery_id(maxbreweryid);
        
        //BreweriesGeocode geobrew=new BreweriesGeocode(0,maxbreweryid,lat, lon);
        int success = service.addBrewery(brew);
        System.out.println("success?"+success);
        String Message="";
        if(success==1)
        {
         Message= "Record inserted successfully";
        }
        else
        {
          Message="there was an error";
        return new ModelAndView("redirect:/taste/addBrewery");
        }
       attr.addAttribute("Message", Message);
        //service.addBreweryGeo(geobrew);
        //route the user to the next page
        return new ModelAndView("redirect:/taste/Success");
    }            
    
    @GetMapping("/Success")
    @ResponseBody
    public String successpage(@QueryParam("Message") String Message)
    {
    return Message+ "<br>"+ " <a href='/TasteMVC/taste/view'>Return to Home page</a>  ";
    
    
    }        
    
    @RequestMapping("/editbrew")
    public ModelAndView editBreweryForm(@QueryParam("id") int id){
        Breweries br=service.getbrewByID(id);
        System.out.println("brewery"+ br.getbrewid());
        return new ModelAndView("/edit", "brew",br);
    }
    
    @PostMapping("/edit")
    public ModelAndView editbrew(@Valid @ModelAttribute("brew") Breweries brew, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("REsult"+result);
            return new ModelAndView("/edit","brew",brew);
        }
        System.out.println("Brewid"+brew.getbrewid());
        
        service.editBrewery(brew);
        return new ModelAndView("redirect:/taste/view");
    }
    @GetMapping("/delete")
    public ModelAndView deleteBrewery(@QueryParam("id") int id, RedirectAttributes attr){
        Breweries b = service.getbrewByID(id);
        service.deleteBrew(b);
        
        attr.addAttribute("Message","user removed");
        return new ModelAndView("redirect:/taste/view");
        //return new ModelAndView("/allAgents", "agentlist", service.getAllAgents());
    }
  
    
}
