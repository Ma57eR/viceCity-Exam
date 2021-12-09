package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private List<Player> civilPlayers;
    private GunRepository guns;

    public ControllerImpl(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
        this.civilPlayers = new ArrayList<>();
        this.guns = new GunRepository();
    }


    @Override
    public String addPlayer(String name) {
        Player currentCivil = new CivilPlayer(name);
        civilPlayers.add(currentCivil);

        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun currentGun;
        switch (type) {
            case "Pistol":
                currentGun = new Pistol(name);
                guns.add(currentGun);
                break;
            case "Rifle":
                currentGun = new Rifle(name);
                guns.add(currentGun);
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (name.equals("Vercetti")) {
            List<Gun> gunsForPlayers = new ArrayList<>(guns.getModels());
            //Създаваме обект оръжие - първото от списъка
            Gun firstGun = gunsForPlayers.get(0);
            //Добавяме оръжието към цивилния
            mainPlayer.getGunRepository().add(firstGun);
            //Премахваме го от колекцията
            guns.remove(firstGun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, firstGun.getName(), mainPlayer.getName());
        } else {

        //Намирам цивилния
        Player player = civilPlayers.get(civilPlayers.indexOf(name));
        //Правим на лист колекцията с оръжия
        List<Gun> gunsForPlayers = new ArrayList<>(guns.getModels());
        //Създаваме обект оръжие - първото от списъка
        Gun firstGun =  gunsForPlayers.get(0);
        //Добавяме оръжието към цивилния
        player.getGunRepository().add(firstGun);
        //Премахваме го от колекцията
        guns.remove(firstGun);
        }

        return null;
    }

    @Override
    public String fight() {
        return null;
    }
}
