# Adapter Pattern
> 연관성 없는 두 객체 묶어 사용하기


## 요구 사항
- 두 수에 대한 다음 연산을 수행하는 객체를 만드시오.
    - 수의 두 배를 반환: `twiceOf(Float): Float`
    - 수의 1/2를 반환: `halfOf(Float): Float`
- 구현 객체 이름은 `Adapter`로 한다.
- 주어진 Math 클래스에 이미 구현되어 있다.
    - double type으로 구현되어있음.

## 요구 사항 2
- 강화된 doubled를 사용하도록 알고리즘을 변경한다.
- `half`연산에 대하여 추가적인 log를 찍는다.

- 위와 같은 요구사항들은 `Math`클래스에서 직접적으로 수정하지 않는다.
    - 왜냐하면 해당 Math 클래스는 다른 부서에서도 사용할 수 있기 때문
    - 이를 해결하기 위하여 Interface를 구현한 Impl 클래스에 수정을 하면된다.

## 사용 상황
- 오픈소스로 제공된 `radixSort()`클래스를 가져온다.
    - 이때 radixSort()가 array에 대해서 구현이 되어있다.
    - 나는 `ArrayList`타입이 필요하다.
- adapter 인터페이스와 adapterImpl 클래스를 구현한다.
    - `Impl`클래스에서 `ArrayList -> array -> ArrayList`를 제공하는 어댑터 method를 구현한다.

  
  

