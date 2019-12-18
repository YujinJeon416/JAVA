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

        Cat ret = (Cat) this.clone();   //clone함수는 protected이므로 새로운 함수 생성(public)

        // Main case3에서 에러처리 구문 -> case4
        if (this.age != null) {
            ret.setAge(new Age(this.age.getYear(),this.age.getValue()));
        }

        return ret;
    }


}
