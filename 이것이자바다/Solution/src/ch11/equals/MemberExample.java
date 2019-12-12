package ch11.equals;

public class MemberExample {
    public static void isEqual(Member m1, Member m2){
        if (m1.equals(m2)) {
            match(m1, m2);
        } else {
            mismatch(m1,m2);
        }
    }

    public static void match(Member m1, Member m2){
        System.out.printf("%s와 %s는 동일합니다.\n",m1.id,m2.id);
    }

    public static void mismatch(Member m1, Member m2){
        System.out.printf("%s와 %s는 동일하지 않습니다.\n",m1.id,m2.id);
    }

    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        isEqual(obj1,obj2);
        isEqual(obj1,obj3);
        isEqual(obj2,obj3);
    }
}
