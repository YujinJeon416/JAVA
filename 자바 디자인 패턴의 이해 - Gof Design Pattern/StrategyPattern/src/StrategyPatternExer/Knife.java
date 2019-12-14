package StrategyPatternExer;

public class Knife implements Weapon {
    @Override
    public void attack() {
        System.out.println("검 공격합니다.");
    }
}
