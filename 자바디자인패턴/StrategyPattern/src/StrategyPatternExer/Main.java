package StrategyPatternExer;

public class Main {

    public static void main(String[] args) {
        GameChracter gameChracter1 = new GameChracter("minkj1992");
        GameChracter gameChracter2 = new GameChracter("jeju1992");

        GameChracter[] gameChracters = {gameChracter1, gameChracter2};
        Weapon[] weapons = {new Knife(), new Ax(), new Bow()};

        for (GameChracter gameChracter : gameChracters) {
            for (Weapon weapon : weapons) {
                gameChracter.setWeapon(weapon);
                gameChracter.attack();
            }
        }
    }
}