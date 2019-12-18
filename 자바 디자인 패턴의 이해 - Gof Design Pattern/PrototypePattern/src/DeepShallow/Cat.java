package DeepShallow;

public class Cat implements Cloneable {
    private String name;
    private Age age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Cat copy() throws CloneNotSupportedException {

        Cat ret = (Cat) this.clone();   //clone�Լ��� protected�̹Ƿ� ���ο� �Լ� ����(public)

        // Main case3���� ����ó�� ���� -> case4
        if (this.age != null) {
            ret.setAge(new Age(this.age.getYear(),this.age.getValue()));
        }

        return ret;
    }


}
