import abst.BikeFactory;
import abst.Body;
import abst.Wheel;
import gt.GtBikeFactory;
import samchunly.SamFactory;

public class Main {

    public static void main(String[] args) {
        BikeFactory samFactory = new SamFactory();
        Body body = samFactory.createBody();
        Wheel wheel = samFactory.createWheel();

        System.out.println(body.getClass());
        System.out.println(wheel.getClass());

        BikeFactory gtFactory = new GtBikeFactory();
        Body gtBody = gtFactory.createBody();
        Wheel gtWheel = gtFactory.createWheel();

        System.out.println(gtBody.getClass());
        System.out.println(gtWheel.getClass());


    }
}
