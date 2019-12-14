package StrategyPatternExer;

public class Ax implements Weapon {
    @Override
    public void attack() {
        System.out.println("도끼 공격합니다.");
    }
}
