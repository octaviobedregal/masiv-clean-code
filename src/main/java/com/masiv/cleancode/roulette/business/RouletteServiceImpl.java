package com.masiv.cleancode.roulette.business;

import com.masiv.cleancode.roulette.model.bet.BetRequest;
import com.masiv.cleancode.roulette.model.bet.BetResponse;
import com.masiv.cleancode.roulette.model.redis.Bet;
import com.masiv.cleancode.roulette.model.redis.Roulette;
import com.masiv.cleancode.roulette.model.rouletteclose.ResultRoucloRes;
import com.masiv.cleancode.roulette.model.rouletteclose.RouletteCloseResponse;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateRequest;
import com.masiv.cleancode.roulette.model.roulettecreate.RouletteCreateResponse;
import com.masiv.cleancode.roulette.model.roulettelist.RouletteListResponse;
import com.masiv.cleancode.roulette.model.rouletteopen.RouletteOpenResponse;
import com.masiv.cleancode.roulette.repository.RouletteRepositoryImpl;
import com.masiv.cleancode.roulette.util.mapper.RouletteMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.masiv.cleancode.roulette.util.constants.Constants.RED;
import static com.masiv.cleancode.roulette.util.constants.Constants.BLACK;
import static com.masiv.cleancode.roulette.util.constants.Constants.OPEN;
import static com.masiv.cleancode.roulette.util.constants.Constants.CLOSE;
import static com.masiv.cleancode.roulette.util.constants.Constants.NUMBERS_ROULETTE;
import static com.masiv.cleancode.roulette.util.constants.Constants.LIMIT_ROULETTE;

@Service
@AllArgsConstructor
public class RouletteServiceImpl implements RouletteService {
    @Autowired
    RouletteRepositoryImpl repository;
    @Autowired
    RouletteMapper rouletteMapper;

    @Override
    public RouletteCreateResponse createRoulette(RouletteCreateRequest request) {
        Roulette roulette = repository.createRoulette(rouletteMapper.convertRouletteCreateRequestToRoulette(request));
        RouletteCreateResponse response = new RouletteCreateResponse(roulette.getId());
        return response;
    }

    @Override
    public RouletteOpenResponse openRoulette(String idRoulette) {
        Roulette roulette = repository.updateStatusRoulette(idRoulette, OPEN);
        return new RouletteOpenResponse(roulette.getStatus());
    }

    @Override
    public BetResponse bet(BetRequest request) {
        Roulette roulette = repository.findRoulette(request.getIdRoulette());
        String result = validateBet(request, roulette);
        if (result.equals("")) {
            repository.createBet(rouletteMapper.convertBetRequestToBet(request));
            result = "Apuesta Registrada correctamente.";
        }
        return new BetResponse(result);
    }

    @Override
    public RouletteCloseResponse closeRoulette(String idRoulette) {
        Roulette roulette = repository.findRoulette(idRoulette);
        List<ResultRoucloRes> results = new ArrayList<>();
        int numberWinner = 0;
        String colorWinner = "";
        if (roulette.getStatus().equals(OPEN)) {
            roulette = repository.updateStatusRoulette(idRoulette, CLOSE);
            List<Bet> bets = repository.listBet();
            Random random = new Random();
            numberWinner = random.nextInt(roulette.getNumbers());
            colorWinner = numberWinner % 2 == 0 ? RED : BLACK;
            for (int cont = 0; cont < bets.stream().count(); cont++) {
                Bet currentBet = bets.get(cont);
                double amountWinner = 0.00;
                if (currentBet.getNumber() == numberWinner) {
                    amountWinner += currentBet.getAmount() * 5;
                }
                if (currentBet.getColor().equals(colorWinner)) {
                    amountWinner += currentBet.getAmount() * 1.8;
                }
                results.add(new ResultRoucloRes(
                        currentBet,
                        (amountWinner > 0 ? true : false),
                        amountWinner));
            }
        }
        return new RouletteCloseResponse(numberWinner, colorWinner, results);
    }

    @Override
    public RouletteListResponse listRoulettes() {
        RouletteListResponse response = new RouletteListResponse(repository.listRoulette());
        return response;
    }

    public String validateBet(BetRequest request, Roulette roulette) {
        String result = "";
        if (roulette != null) {
            if (roulette.getStatus().equals(OPEN)) {
                if (request.getNumber() < 0 || request.getNumber() > NUMBERS_ROULETTE) {
                    result = "Ingresar un número válido entre 0 y 36.";
                }
                if (!request.getColor().equals(RED) && !request.getColor().equals(BLACK)) {
                    result += "Ingresar un color válido (ROJO/ NEGRO).";
                }
                if (request.getAmount() > LIMIT_ROULETTE) {
                    result += "Ingresar un monto máximo de 10000 dólares.";
                }
            } else {
                result = "Ruleta cerrada.";
            }
        } else {
            result = "El id de ruleta no existe.";
        }
        return result;
    }
}
