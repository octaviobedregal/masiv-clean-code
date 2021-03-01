package com.masiv.cleancode.roulette.model.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Bet")
public class Bet implements Serializable {
    @Id
    private String id;
    private String idRoulette;
    private int idUser;
    private String color;
    private int number;
    private double amount;
}