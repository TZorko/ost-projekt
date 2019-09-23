package si.tz.feri.ost.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import si.tz.feri.ost.model.Test;

@Controller
@RequestMapping("view")
public class ViewController {

    @RequestMapping(value = {"/", "/test"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView test(@RequestParam(name = "name", required = false, defaultValue = "Visitor") String name)
    {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("name", name);
        return mv;
    }

}
