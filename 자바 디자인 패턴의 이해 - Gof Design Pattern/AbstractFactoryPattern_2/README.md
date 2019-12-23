# Abstract Factory Pattern 2
> 1���� �ǿ����� ������ ���� �н�

- GUI���õ� abstract Factory Pattern

## ����
1. abstract
    - abstFactory
        - create �߻� ��ǰ
    - ��ǰ��
        - �߻����� ���(method) ����

2. concrete
    - Main() �Լ����� ����� abstract interface ����
        - class FactoryInstance
            - static `getGuiFac()`
            - static `getOsCode()`
    - **�̸� ���Ͽ� main������ � os���� �������, ������ �������̽��� ���� ��Ȳ�� �°� Ȱ��� �� �ִ�.**(�ٽ����� �߻����丮 ���� ����) 

3. linux,mac,windows..
    - concreteFactory
    - ��ü���� ��ǰ��(linuxButton, MacTextArea ...)
