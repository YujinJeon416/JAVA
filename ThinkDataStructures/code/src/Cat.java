public class Cat extends Animal {
    int type;

    public Cat(String name, int type) {
        super(name);
        this.type = type;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getType(){
        return type;
    }

    public static void main(String[] args) {
        String name = "minwook";
        Cat cat = new Cat(name,1);
        Animal animal = cat;

        String curAnimalName = animal.getName();
        String curCatName = cat.getName();

//        int curAnimalType = animal.getType(); // animal 타입으로 캐스팅된 cat은 cat method를 사용할 수 없다.
        int curCatType = cat.getType();
        System.out.println(animal == cat);  // 그런데 어쨰서 animal == cat (true)가 될까?


    }
}

