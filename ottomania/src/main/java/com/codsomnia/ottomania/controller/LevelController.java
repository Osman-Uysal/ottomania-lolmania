package com.codsomnia.ottomania.controller;


import com.codsomnia.ottomania.model.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
public class LevelController {

   final private String api_key = "RGAPI-2f339503-485e-40af-b6b6-48ad10d337bc";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    @GetMapping("/level")
    public String viewLevelPage(
            @RequestParam(value = "profileName", required = false) String profileName,
            Model model) {


        var summonerDTO = retrievePlayerProfile(profileName);
        model.addAttribute("summonerDTO", summonerDTO);



        return "LevelPage";
    }

    private SummonerDTO retrievePlayerProfile(String profileName){
//
//        String playerName = "OOODF"; // from API
//        int level = 5; // from API
//        String icon = "icon"; // from API
//
//        var pp = new PlayerProfile( playerName, level, icon);

//        var pp = new SummonerDTO();

        HttpHeaders headers = new HttpHeaders();

// set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

// example of custom header
//        headers.set("api_key", api_key);
//
//// build the request
        HttpEntity request = new HttpEntity(headers);

        String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ profileName + "?api_key="+ api_key ;
        ResponseEntity<SummonerDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                SummonerDTO.class,
                1
        );


        return response.getBody();
    }
}