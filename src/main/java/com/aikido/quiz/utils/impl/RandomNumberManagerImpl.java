package com.aikido.quiz.utils.impl;

import com.aikido.quiz.utils.RandomNumberManager;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberManagerImpl implements RandomNumberManager {

    public int generateRandomInt() {
        Random r = new Random();
        return r.nextInt(4) + 1;
    }
}
