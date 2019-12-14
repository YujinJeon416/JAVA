package StrategyPatternExer;

public class GameChracter {
    Weapon weapon;
    String userId;

    public GameChracter(String userId) {
        this.userId = userId;
    }

    //��ȯ
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(){
        System.out.print(userId+"�� ");
        if (weapon == null) {
            System.out.println("�Ǽ� �����մϴ�.");
        } else {
            // ��������Ʈ
            weapon.attack();
        }
    }

}
