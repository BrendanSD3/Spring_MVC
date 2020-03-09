/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TasteCRUD;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author brend
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value=Exception.class)
    public ModelAndView HandleException(HttpServletRequest req, Exception ex)
    {
        System.out.println("Request threw an error"+ex);
        //model.addAttribute("error",ex);
        return new ModelAndView("/error","message",ex);
    }
}
