package com.masiv.cleancode.roulette.model.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash("Roulette")
public class Roulette implements Serializable {
    @Id
    @Indexed
    private String id;
    private String name;
    private int numbers;
    private String status;
}