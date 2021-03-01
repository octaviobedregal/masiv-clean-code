package com.masiv.cleancode.roulette.model.roulettelist;

import com.masiv.cleancode.roulette.model.redis.Roulette;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RouletteListResponse {
    private List<Roulette> roulettes;
}
