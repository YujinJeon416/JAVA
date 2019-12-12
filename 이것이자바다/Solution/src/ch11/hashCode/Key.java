package ch11.hashCode;

// hashCode()�� == ����� ���� ���� ����񱳿� ���ȴ�.
// HashMap���� get�� ������Ű�� ���ؼ��� equal�� hashCode�� �����ؾ� �Ѵ�.
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

    // ==�� number�������� ���Ѵ�. (�׷���  equals���� ���Ǵ� ==���� hash code�� �ҷ�����?)
    // �̴� get�� �ҷ��� ���, number �� �ش� key.number�� ���Ѵ�.
    @Override
    public int hashCode() {
        return number;
    }
}

