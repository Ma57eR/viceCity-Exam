package viceCity.models.guns;

import viceCity.models.guns.BaseGun;

public class Pistol extends BaseGun {
    public static final int DEFAULT_PER_BARREL = 10;
    public static final int DEFAULT_TOTAL = 100;
    int bulletsInCurrentBarrel = DEFAULT_PER_BARREL;
    int bulletsPerFire = 1;

    public Pistol(String name) {
        super(name, DEFAULT_PER_BARREL, DEFAULT_TOTAL);
        this.bulletsInCurrentBarrel = DEFAULT_PER_BARREL;
    }

    @Override
    public int fire() {

        return this.bulletsInCurrentBarrel - bulletsPerFire;
    }
}
