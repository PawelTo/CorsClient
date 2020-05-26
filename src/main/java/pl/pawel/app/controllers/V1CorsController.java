package pl.pawel.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(V1CorsController.API_PAHT)
@RestController
public class V1CorsController {

    static final String API_PAHT = "/cors-server";


}
