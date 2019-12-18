package DeepShallow;

import javax.sound.sampled.Line;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cat cat1 = new Cat();
        cat1.setName("cat1");
        System.out.println(cat1.getName());

        // Case 1: Instance copy
        Cat shallowCopiedCat = cat1;
        Cat deepCopiedCat = cat1.copy(); //Cloneable clone()은 deepcopy

        cat1.setName("cat-1");
        System.out.println(shallowCopiedCat.getName());
        System.out.println(deepCopiedCat.getName());

        // Case 2: Argument Instance copy (OK)
        Cat cat3 = new Cat();
        cat3.setName("cat3");
        cat3.setAge(new Age(2012, 3));

        Cat cat4 = cat3.copy();
        cat4.setName("cat4");
        cat4.setAge(new Age(2013, 3));

        System.out.println(cat3.getAge().getYear());    //2012
        System.out.println(cat4.getAge().getYear());    //2013

        // case 3: Argument Instance's member field copy (False)
        Cat cat5 = cat3.copy();
        cat5.setName("cat5");
        cat5.getAge().setYear(2013);
        cat5.getAge().setValue(2);
        // cat3의 Year, Value값이 공유된 상태
        System.out.println(cat3.getAge().getYear()+", "+cat3.getAge().getValue());    //2013, 2
        System.out.println(cat5.getAge().getYear()+", "+cat5.getAge().getValue());    //2013, 2

        // Case 4: Case 3 해결법, 명시적 깊은 복사
        // Cat 28 Line을 통해 해결
    }
}
