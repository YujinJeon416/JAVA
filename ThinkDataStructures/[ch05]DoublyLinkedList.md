# Doubly Linked List

## ArrayList, LinkedList, DoublyLinkedList 
- ArrayList가 growth_rate로 우위를 가질 수 있는것은 `get/set`외에는 없다.

- 증가 차수 이외에 고려할 사항
```
1. 실제 application에서 List와 관련된 시간 소모 퍼센트 고려
2. 작업하는 리스트가 크지 않다면 성능 차이 (x)
3. Space Complexity
    - ArrayList는 한덩어리 Memory안에 나란히 데이터들이 저장된다. (cache locality)
        - 다만 ArrayList는 삭제시 compaction시키지 않고 null값이 array안에 존재하는 방식이다.
        - 이로 인하여 sparse하게 데이터가 저장될 수도 있다.
    - java Array는 mutable하다. 다만 Length에 대하여 immutable하다.
        - java array에서 remove를 한다는 것은 해당 index 또는 element를 찾고 이후의 값 또는 ref를 앞으로 당겨주는 행위이다.
        - 즉 Array의 size는 그대로 두고 삭제이후 값들을 당겨준다.
        - 이로인해 마지막 값부터 null로 존재한다.
    - ArrayUtils.remove(array, index);를 활용하면 size가 compaction된다.
4. LinkedList에서 ref는 각 element당 1~2개 존재하며, 이는 ArrayList의 Element보다 사이즈 클 수 있다.

```