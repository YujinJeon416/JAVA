# CH03 ArrayList
> 2장에 이어 MyArrayList 구현 및 MyLinkedList

## `public void add(int index, T element)`
```java
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);

        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
    }
```
```java
    @Override
    public void add(int index, T element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);
        int copyLength = size-index;
        if (copyLength > 0) {
            System.arraycopy(array, index, array, index+1, copyLength);
        }
        array[index] = element;
    }
```

- `amortized analysis`
- `O(n)`


## public boolean removeAll(Collection<?> collection)
```java
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj : collection) {
            flag &= remove(obj);
        }
        return flag;
    }
```
- `problem Size`문제
    - O(n^2)이라 생각하기 쉽지만 `O(NM)`

## 실습 3
- `MyLinkedList`