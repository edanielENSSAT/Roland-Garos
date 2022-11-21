package com.rollandgaros.tournementmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller

@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("home")
    public String getPlayers(){
        return "home";
    }
   /* @GetMapping("editeurdejoueur")
    public String editplayer() {
        return ("<h1>Welcome editeur de joueur</h1>");
    }

    @GetMapping("admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
    @GetMapping("editeurdematch")
    public String editmatch() {
        return ("<h1>Welcome editeur de match</h1>");
    }*/
}
