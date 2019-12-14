package StrategyPatternExer;

public class GameChracter {
    Weapon weapon;
    String userId;

    public GameChracter(String userId) {
        this.userId = userId;
    }

    //교환
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(){
        System.out.print(userId+"가 ");
        if (weapon == null) {
            System.out.println("맨손 공격합니다.");
        } else {
            // 델리게이트
            weapon.attack();
        }
    }

}
