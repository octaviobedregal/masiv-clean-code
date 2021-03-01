package com.masiv.cleancode.roulette.repository;

import com.masiv.cleancode.roulette.model.redis.Bet;
import com.masiv.cleancode.roulette.model.redis.Roulette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouletteRepositoryImpl implements RouletteRepository {
    public static final String HASH_KEY_ROULETTE = "Roulette";
    public static final String HASH_KEY_BET = "Bet";
    @Autowired
    private RedisTemplate template;

    public Roulette createRoulette(Roulette roulette){
        template.opsForHash().put(HASH_KEY_ROULETTE,roulette.getId(),roulette);
        return roulette;
    }

    public Bet createBet(Bet bet){
        template.opsForHash().put(HASH_KEY_BET,bet.getId(),bet);
        return bet;
    }

    public Roulette findRoulette(String id){
        return (Roulette) template.opsForHash().get(HASH_KEY_ROULETTE,id);
    }

    public List<Roulette> listRoulette(){
        return template.opsForHash().values(HASH_KEY_ROULETTE);
    }

    public List<Bet> listBet(){
        return template.opsForHash().values(HASH_KEY_BET);
    }

    public Roulette updateStatusRoulette(String id, String status){
        Roulette roulette=(Roulette) template.opsForHash().get(HASH_KEY_ROULETTE,id);
        roulette.setStatus(status);
        template.opsForHash().put(HASH_KEY_ROULETTE,roulette.getId(),roulette);
        return roulette;
    }
}
