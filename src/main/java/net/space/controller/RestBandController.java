package net.space.controller;

import net.space.model.Band;
import net.space.service.BandService;
import net.space.utilities.constants.BandDateUtils;
import net.space.validators.BandValidator;
import net.space.validators.json.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/main/add/band", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<?> addBand(@RequestBody Band band, Errors errors) {

        bandValidator.validate(band, errors);

        JsonResponse jr = new JsonResponse();

        if(errors.hasErrors()) {
            jr.setStatus("FAIL");
            jr.setResult(errors.getAllErrors());

            //return ResponseEntity.badRequest().body(jr);
        }

        else {
            jr.setStatus("SUCCESS");
            jr.setResult(band);

            if(band.getId() == 0)
                service.addBand(BandDateUtils.breakADate(band));

            else
                service.updateBand(band);
        }

        return ResponseEntity.ok(jr);
    }
}
