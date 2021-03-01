package com.masiv.cleancode.roulette.model.rouletteclose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RouletteCloseResponse {
    private int numberWinner;
    private String colorWinner;
    private List<ResultRoucloRes> results;
}
