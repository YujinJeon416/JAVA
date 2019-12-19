# [ch06] Tree 순회

## 6.1 검색엔진
- 필수기능
    1. `crawling`
    2. `indexing`
    3. `retrieval`

## 6.3 `jsoup`
- `Connection`
- `Document`:   DOM트리
    - `getElementById();`: 자식 손자 포함
- `Element`
    - `select()`
- `Elements`
    - `Element`객체 컬렉션(ArrayList 상속)
- `Node`:   DOM트리에서의 노드
    - Element
    - TextNode, DataNode
    - Comment

## 6.5 `DFS`

1. `recursiveDFS()`
    ```java
    public static void recursiveDFS(Node node){
        if(node instanceOf TextNode){
            sout(node);
        }
        for (Node child: node.childNodes()){
            recursiveDFS(child);
        }
    }
    ```
    - visited를 check하지 않아도 되는 이유는
        1. Tree이므로 단방향 이동
        2. 부모를 통하지 않고는 다른 분포 Node들은 Mutually Exclusive이다. 다시말해서 2명 이상의 부모를 가지지 않는다.
2. `recursiveDFS()`


