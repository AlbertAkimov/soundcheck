package net.space.controller;

import net.space.service.BandService;
import net.space.validators.BandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author A.Albert
 * @Data 8/23/17
 * @Time 10:08 PM
 * @Version 1.0
 * @Info empty
 */

@RestController
public class RestBandController {

    private BandService service;

    @Autowired
    private BandValidator bandValidator;

    @Autowired(required = true)
    @Qualifier(value = "bandService")
    public void setService(BandService service) {
        this.service = service;
    }



}
