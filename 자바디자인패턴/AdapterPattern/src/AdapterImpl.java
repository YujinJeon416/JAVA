public class AdapterImpl implements Adapter {
    // Math math;

//     요구사항 1
//    @Override
//    public Float twiceOf(Float f) {
//        return (float) Math.twoTime(f.doubleValue());
//    }
//
//    @Override
//    public Float halfOf(Float f) {
//        return (float) Math.half(f.doubleValue());
//    }

    // 요구사항 2

    @Override
    // float -> double -> float
    public Float twiceOf(Float f) {
        return Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        System.out.println("halfOf() 호출 되었다.");
        return (float) Math.half(f.doubleValue());
    }
}
