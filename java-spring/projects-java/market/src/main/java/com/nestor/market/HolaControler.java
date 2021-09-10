package com.nestor.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaControler {

    @GetMapping("/hola")
    public static String saludar(){
        return "Hola Nestor, desde Controler";
    }
}
