package nl.codecentric.ttt.romannumerals.service;

/**
 * Created by hylke on 04/10/2016.
 */
public class FollowUpRandomNumberService implements RandomNumberService {

    private static final RandomNumberService INSTANCE = new FollowUpRandomNumberService();

    private Integer number;

    private FollowUpRandomNumberService() {

    }

    public Integer getNextNumber() {
        this.number++;
        return number;
    }

    public static RandomNumberService getInstance(){
        return INSTANCE;
    }
}
