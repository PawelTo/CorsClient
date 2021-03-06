package pl.pawel.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.app.domain.models.CorsRecivedModel;
import pl.pawel.app.domain.services.LocalHostCaller;

@RequestMapping(V1CorsController.API_PATH)
@RestController
public class V1CorsController {

    static final String API_PATH = "/cors-server";

    @Autowired
    private LocalHostCaller localHostCaller;

    @GetMapping()
    public CorsRecivedModel getForDataFromAnotherService(){
        CorsRecivedModel corsRecivedModel = localHostCaller.getForObject();
        System.out.println("Recived Model: "+corsRecivedModel);
        return corsRecivedModel;
    }
}
