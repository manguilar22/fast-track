package guru.aguilar.fasttrack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Home {

    @RequestMapping("/")
    public String message(){
        return "home";
    }

}
