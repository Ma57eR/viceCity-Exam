package viceCity.models.guns;

public class Rifle extends BaseGun{
    public static final int DEFAULT_PER_BARREL = 50;
    public static final int DEFAULT_TOTAL = 500;


    public Rifle(String name) {
        super(name, DEFAULT_PER_BARREL, DEFAULT_TOTAL);
    }
}
