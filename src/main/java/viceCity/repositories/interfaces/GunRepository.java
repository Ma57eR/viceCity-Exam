package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    @Override
    public Collection<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
        models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return false;
    }

    @Override
    public Gun find(String name) {
        Gun currentGun = models.stream().filter(gun -> gun.getName().equals(name)).findFirst().orElse(null);
        return currentGun;
    }
}
