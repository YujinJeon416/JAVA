public class AdapterImpl implements Adapter {
    // Math math;

//     �䱸���� 1
//    @Override
//    public Float twiceOf(Float f) {
//        return (float) Math.twoTime(f.doubleValue());
//    }
//
//    @Override
//    public Float halfOf(Float f) {
//        return (float) Math.half(f.doubleValue());
//    }

    // �䱸���� 2

    @Override
    // float -> double -> float
    public Float twiceOf(Float f) {
        return Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        System.out.println("halfOf() ȣ�� �Ǿ���.");
        return (float) Math.half(f.doubleValue());
    }
}
