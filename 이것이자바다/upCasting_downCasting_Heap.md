# 캐스팅과 heap영역 관리
> https://stackoverflow.com/questions/47390220/upcasting-and-its-effect-on-the-heap

```
[요약]
- instance는 new를 통해서만 생성된다.
- upCasting, downCasting 모두 같은 instance를 ref가 가리킨다.
- 다만, 변수 타입이나 접근제한을 두어, 자식과 부모 사이의 관계를 정립한다.
- 즉 캐스팅에 따른 heap에서의 **오버헤드가 발생하지 않는다.**
```
**"Normal" Upcasting and Downcasting of Reference Types**

For reference types, casting variables doesn't change the type of the object already allocated on the heap, it just affects the type of the variable which references the object.

So no, there isn't any additional heap overhead with casting reference types (i.e. object instances from classes).

Consider the following class hierarchy:

    public class Fruit
    {
    	public Color Colour {get; set;}
    	public bool Edible {get; set;}
    }

    public class Apple : Fruit
    {
        public Apple { Color = Green; Edible = true; KeepsDoctorAtBay = true;}
    	public bool KeepsDoctorAtBay{get; set;}
    }

Which, when used with both upcasting and downcasting:

[![Example of variables pointing to same heap object][1]][1]

There is only ever one allocation on the heap, which is the initial `var foo = new Apple()`.

After the various variable assignments, all three variables, `foo`, `bar` and `baz` point to the same object (an `Apple` instance on the heap). 

Upcasting (`Fruit bar = foo`) will simply restrict the variable's available access to only `Fruit` methods and properties, and if the `(Apple)bar` downcast is successful all methods, properties and events of the downcast type will be available to the variable. If the downcast fails, an `InvalidCastException` will be thrown, as the type system will check the type of the heap object's compatability with the variable's type at run time.

**Conversion Operators**

As per tolanj's comment, all bets about the heap are off if an [explicit conversion operator](https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/statements-expressions-operators/using-conversion-operators) replaces the default casting of reference types.

For instance, if we add an unrelated class:

    public class WaxApple // Not inherited from Fruit or Apple
    {
    	public static explicit operator Apple(WaxApple wax)
    	{
    		return new Apple
    		{
    			Edible = false,
    			Colour = Color.Green,
    			KeepsDoctorAtBay = false
    		};
    	}
    }

As you can imagine, WaxApple's `explicit operator Apple` can do whatever it likes, including allocate new objects on the heap.

	var wax = new WaxApple();
	var fakeApple = (Apple)wax;
    // Explicit cast operator called, new heap allocation as per the conversion code. 


  [1]: https://i.stack.imgur.com/2TUS6.png