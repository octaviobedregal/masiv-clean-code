package com.masiv.cleancode.roulette.repository;

import com.masiv.cleancode.roulette.model.redis.Bet;
import com.masiv.cleancode.roulette.model.redis.Roulette;
import java.util.List;


public interface RouletteRepository {
    Roulette createRoulette(Roulette roulette);
    Roulette findRoulette(String id);
    Roulette updateStatusRoulette(String id, String status);
    List<Roulette> listRoulette();
    Bet createBet(Bet bet);
    List<Bet> listBet();
}
