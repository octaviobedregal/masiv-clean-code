package com.masiv.cleancode.roulette.business;

import com.masiv.cleancode.roulette.model.bet.BetRequest;
import com.masiv.cleancode.roulette.model.bet.BetResponse;
import com.masiv.cleancode.roulette.model.rouletteclose.RouletteCloseResponse;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateRequest;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateResponse;
import com.masiv.cleancode.roulette.model.roulettelist.RouletteListResponse;
import com.masiv.cleancode.roulette.model.rouletteopen.RouletteOpenResponse;

public interface RouletteService {
    RouletteCreateResponse createRoulette(RouletteCreateRequest request);
    RouletteOpenResponse openRoulette(String idRoulette);
    BetResponse bet(BetRequest request);
    RouletteCloseResponse closeRoulette(String idRoulette);
    RouletteListResponse listRoulettes();
}
