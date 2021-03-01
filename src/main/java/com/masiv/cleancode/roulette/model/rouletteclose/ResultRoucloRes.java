package com.masiv.cleancode.roulette.model.rouletteclose;

import com.masiv.cleancode.roulette.model.redis.Bet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultRoucloRes {
    private Bet bet;
    private boolean winner;
    private double amount;
}
