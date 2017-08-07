package net.space.controller;

import net.space.model.Band;
import net.space.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author A.Albert
 * @Data 8/4/17
 * @Time 9:35 AM
 * @Version 1.0
 * @Info empty
 */

@Controller
public class BandController {

    private BandService service;

    @Autowired(required = true)
    @Qualifier(value = "bandService")
    public void setService(BandService service) {
        this.service = service;
    }

    @RequestMapping(value = "bands", method = RequestMethod.GET)
    public String listBook(Model model) {
        model.addAttribute("band", new Band());
        model.addAttribute("listBand", this.service.listBand());
        return "bands";
    }

    @RequestMapping(value = "/bands/add", method = RequestMethod.POST)
    public String addBand(@ModelAttribute(value = "band") Band band) {
        if(band.getId() == 0)
            this.service.addBand(band);
        else
            this.service.updateBand(band);

        return "redirect:/bands";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBand(@PathVariable("id") int id) {
        this.service.removeBand(id);

        return "redirect:/bands";
    }

    @RequestMapping(value = "edit/{id}")
    public String editBand(@PathVariable("id") int id, Model model) {
        model.addAttribute("band", this.service.getBandById(id));
        model.addAttribute("listBand", this.service.listBand());

        return "bands";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }
}

