package net.space.controller;

import net.space.model.Band;
import net.space.model.User;
import net.space.service.*;
import net.space.utilities.constants.BandDateUtils;
import net.space.validators.BandValidator;
import net.space.validators.json.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private BandValidator bandValidator;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired(required = true)
    @Qualifier(value = "bandService")
    public void setService(BandService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String listBand(Model model) {
        model.addAttribute("band", new Band());
        model.addAttribute("listBand", this.service.listBand());
        return "main";
    }

    @RequestMapping(value = "/personal-page", method = RequestMethod.GET)
    public String getPersonalPage(Model model) {

        List<Band> result = this.service.lists();

        String userName = this.securityService.findLoggedInUsername();
        User user = this.userService.findByUsername(userName);

        List<Band> bandList = new ArrayList<>();

        for(Band band : result) {
            if(user.getId().equals(band.getUserID()))
                bandList.add(band);
        }

        model.addAttribute("listBand", bandList);

        return "personalPage";
    }

    @RequestMapping(value = "/main/add", method = RequestMethod.POST)
    public @ResponseBody JsonResponse addBand(@ModelAttribute(value = "band") Band band, BindingResult bindingResult) {

        bandValidator.validate(band, bindingResult);

        JsonResponse jr = new JsonResponse();

        if(!bindingResult.hasErrors()) {

            jr.setStatus("SUCCESS");
            jr.setResult(band);

            if (band.getId() == 0)
                this.service.addBand(BandDateUtils.breakADate(band));

            else
                this.service.updateBand(band);
        }
        else{
            jr.setStatus("FAIL");
            jr.setResult(bindingResult.getAllErrors());
        }

        return jr;
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
}

