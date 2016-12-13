package org.hoboventures.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Asha on 12/2/2016.
 */
@RestController
public class ExampleController {

    @GetMapping(value = "test/{name}")
    public String greeting(@PathVariable(value = "name") String name){
        return "Hello! " + name;
    }
}
