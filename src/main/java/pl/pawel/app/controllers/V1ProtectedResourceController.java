package pl.pawel.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(V1ProtectedResourceController.API_PAHT)
@RestController
public class V1ProtectedResourceController {

    static final String API_PAHT = "/security-resources";

    @GetMapping(value= "/all")
    public String returnedForAll(){
        return "for all";
    }

    @GetMapping("/authenticated")
    public String returnedForAuthenticated(){
        return "for Authenticated";
    }
}
