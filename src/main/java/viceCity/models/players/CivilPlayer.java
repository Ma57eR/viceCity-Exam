package viceCity.models.players;

public class CivilPlayer extends BasePlayer{
    public static final int INITIAL_HEALTH = 50;


    public CivilPlayer(String name) {
        super(name, INITIAL_HEALTH);
    }
}
