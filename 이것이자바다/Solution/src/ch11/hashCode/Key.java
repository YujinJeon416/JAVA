package ch11.hashCode;

// hashCode()는 == 연산과 같은 논리적 동등비교에 사용된다.
// HashMap에서 get을 성공시키기 위해서는 equal와 hashCode가 동일해야 한다.
public class Key {
    public int number;

    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Key) {
            Key compareKey = (Key) o;
            return (this.number == compareKey.number);
        }
        return false;
    }

    // ==를 number기준으로 비교한다. (그런데  equals에서 사용되는 ==에도 hash code가 불려질까?)
    // 이는 get을 불렀을 경우, number 와 해당 key.number를 비교한다.
    @Override
    public int hashCode() {
        return number;
    }
}

