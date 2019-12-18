# Prototype Pattern
> PrototypePattern�� ���ؼ� **������ �ν��Ͻ��� ����**�� �� �ִ�.

- `Prototype �����ǹ�`
    - ����
    - ǥ��
    - ���
- `Prototype Pattern`
    - **���� ����� ���� �ν��Ͻ�**�� ���縦 ����, ���� ���� �� �� �ֵ��� �ϴ� ����
## �ν��Ͻ� �������� ���� ���
1. **������ �ʹ� ����** Ŭ������ �������� �ʴ� ���
2. Ŭ�����κ��� �ν��Ͻ� **������ ����� ���**

## �䱸 ����
- �Ϸ���Ʈ�����Ϳ� ���� �׸� �׸��� ���� �������Դϴ�. 
    - � ���(Shpae)�� �׸� �� �ֵ��� �Ͻÿ�
    - ���� �ٿ��ֱ� ����� �����Ͻÿ�
 
## �������
- �ڹٿ����� `public class Prototype.Shape implements Cloneable`�� ���Ͽ�, `clone()` method�� ���� ���� ������ �� �ִ�.
- ���� ���� �Լ��� ������ش�. 
```java
public class Prototype.Circle extends Shape{
    ...
        public Prototype.Circle copy() throws CloneNotSupportedException {
            Prototype.Circle circle = (Prototype.Circle) clone();
            // ���� ��, ��ġ�� �ʵ��� �����ϱ�
            circle.x += 1;
            circle.y += 1;
    
            return circle;
}
```
- `Prototype.Circle circle = (Prototype.Circle) clone();`�� ���� �ս��� Prototype.Shape �ڽİ�ü�� ���������ϴ�.

## ���ǻ���
> Package `DeepShallow`�� ���� ���
- ���� ����
- ���� ����



