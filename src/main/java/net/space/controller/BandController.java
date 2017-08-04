package net.space.controller;

import net.space.model.Band;
import net.space.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
