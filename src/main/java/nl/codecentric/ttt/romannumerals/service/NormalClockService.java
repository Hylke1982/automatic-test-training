package nl.codecentric.ttt.romannumerals.service;

import java.util.Date;

/**
 * Created by hylke on 04/10/2016.
 */
public class NormalClockService implements ClockService {
    public Date getCurrentTime() {
        return new Date();
    }
}
