package com.minkj1992.thinkdast;

public class MyInteger extends Number implements Comparable<Integer>{
    private final int value;

    public MyInteger(int var1) {
        this.value = var1;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    // 핵심 method
    @Override
    public int compareTo(Integer anotherInteger) {
        int thisVal = this.value;
        // Integer class의 getter
        int anotherVal = anotherInteger.intValue();
        return (thisVal<anotherVal ? -1 : (thisVal==anotherVal ? 0 : 1));
    }
}
