package nl.codecentric.ttt.romannumerals.service;

import java.util.Random;

/**
 * Created by hylke on 04/10/2016.
 */
public class NormalRandomNumberService implements RandomNumberService {

    public Integer getNextNumber() {
        return new Random().nextInt();
    }
}
