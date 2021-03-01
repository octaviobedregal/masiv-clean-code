package com.masiv.cleancode.roulette.util.mapper;

import com.masiv.cleancode.roulette.model.bet.BetRequest;
import com.masiv.cleancode.roulette.model.redis.Bet;
import com.masiv.cleancode.roulette.model.redis.Roulette;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateRequest;
import org.springframework.stereotype.Component;
import static com.masiv.cleancode.roulette.util.constants.Constants.GENERATE_ID;
import static com.masiv.cleancode.roulette.util.constants.Constants.CLOSE;
import static com.masiv.cleancode.roulette.util.constants.Constants.NUMBERS_ROULETTE;

@Component
public class RouletteMapper {
    public Roulette convertRouletteCreateRequestToRoulette(RouletteCreateRequest request){
        return new Roulette(GENERATE_ID(),
                request.getName(),
                NUMBERS_ROULETTE,
                CLOSE);
    }
    public Bet convertBetRequestToBet(BetRequest request){
        return new Bet(GENERATE_ID(),
                request.getIdRoulette(),
                request.getIdUser(),
                request.getColor(),
                request.getNumber(),
                request.getAmount());
    }
}
