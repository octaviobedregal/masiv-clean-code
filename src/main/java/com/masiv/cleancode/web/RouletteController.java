package com.masiv.cleancode.web;

import com.masiv.cleancode.roulette.business.RouletteService;
import com.masiv.cleancode.roulette.model.bet.BetRequest;
import com.masiv.cleancode.roulette.model.bet.BetResponse;
import com.masiv.cleancode.roulette.model.rouletteclose.RouletteCloseResponse;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateRequest;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateResponse;
import com.masiv.cleancode.roulette.model.roulettelist.RouletteListResponse;
import com.masiv.cleancode.roulette.model.rouletteopen.RouletteOpenResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roulette")
@AllArgsConstructor
public class RouletteController {
    @Autowired
    private RouletteService service;

    @PostMapping("/create")
    public RouletteCreateResponse create(@RequestBody RouletteCreateRequest request) {
        return service.createRoulette(request);
    }

    @PostMapping("/open/{id}")
    public RouletteOpenResponse open(@PathVariable String id) {
        return service.openRoulette(id);
    }

    @PostMapping("/bet")
    public BetResponse bet(@RequestHeader("id-user") int idUser, @RequestBody BetRequest request) {
        request.setIdUser(idUser);
        return service.bet(request);
    }

    @PostMapping("/close/{id}")
    public RouletteCloseResponse close(@PathVariable String id) {
        return service.closeRoulette(id);
    }

    @GetMapping("/list")
    public RouletteListResponse list() {
        return service.listRoulettes();
    }

}