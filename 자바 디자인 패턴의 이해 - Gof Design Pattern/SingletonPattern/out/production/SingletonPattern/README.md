# Singleton Pattern
> �̱��� ������ ���� **�ϳ��� �ν��Ͻ�**�� �����ϵ��� ���� �� �� �ִ�.

- `static private �̱��� instance`
- `private ������()`
    - �����ڴ� getInstance������ ȣ��
- `public static getInstance()`
    - �̱��� instance�� �ҷ��־�� �ϹǷ�

## �䱸����
- �������� �ý��ۿ��� ����Ŀ�� ������ �� �ִ� class�� �����
    - ����Ŀ�� �ϳ��̻� �����Ѵٸ�, sync�� ���� �ʱ� ������
    - �׷��� �ʴٸ� �������� instance�� ���� ���� ��������� update ���־� overhead�Ͼ
- ����� �̱���
