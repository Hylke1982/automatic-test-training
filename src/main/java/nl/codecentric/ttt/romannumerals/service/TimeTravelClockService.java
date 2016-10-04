package nl.codecentric.ttt.romannumerals.service;

import java.util.Date;

/**
 * Created by hylke on 04/10/2016.
 */
public class TimeTravelClockService implements ClockService {

    private Date newDate;

    public void setDate(final Date newDate) {
        this.newDate = newDate;
    }

    public Date getCurrentTime() {
        return this.newDate;
    }
}
