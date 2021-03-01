package com.masiv.cleancode.roulette.model.bet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BetRequest {
    private String idRoulette;
    private int idUser;
    private String color;
    private int number;
    private double amount;
}
