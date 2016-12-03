package org.hoboventures.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Asha on 12/2/2016.
 */
@RestController
public class ExampleController {

    @GetMapping
    public String greeting(@PathVariable(value = "Bitch") String name){
        return "Hello! " + name;
    }
}
