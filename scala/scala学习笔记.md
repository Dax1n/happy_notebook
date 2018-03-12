### Scala学习笔记

##### 偏函数

- 引用地址：http://blog.csdn.net/bluishglc/article/details/50995939  

    def func = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }
      override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 2
    }  

PartialFunction是偏函数的数据结构定义，通常需要写两个方法：isDefinedAt与apply，各个方法含义如下：  

isDefinedAt：  Checks if a value is contained in the function's domain.(检查value是否在函数的符合参数范围之内，返回是一个波尔类型，此处结合模式匹配联想你会想明白。)

apply：偏函数的计算逻辑

<font color=red>注意：</font> 上述定义的偏函数与val addFunc = (i:Int) =>x+1 是不同的 ，偏函数可以传入非Int类型，但是addFunc是不可以的，例如：  

		List(1, 3, 5, "seven") map { case i: Int => i + 1 } // won't work ，map的参数是一个普通参数
		
		// scala.MatchError: seven (of class java.lang.String)
		List(1, 3, 5, "seven") collect { case i: Int => i + 1 } // collect函数的参数是一个偏函数


<font color=red>注意：</font> 好处就是偏函数会根据正确类型进行处理，如果类型错误的话则不会进行处理。正如模式匹配一样，之后当匹配条件符合时候才会执行具体逻辑。  


- 偏函数与普通函数区别：  

		在Scala的scala包里，有一系列Function trait，它们实际上就是函数字面量作为“对象”存在时对应的类型。Function类型有多个版本，Function0表示无参数函数，  
		Function1表示只有一个参数的函数，以此类推。至此我们解释的是一个普遍性问题：是函数就是对象，是对象就有类型。那么，接下来我们看一下偏函数又应该是什么样的一种“类型”？  
		从语义上讲，偏函数区别于普通函数的唯一特征就是：偏函数会自主地告诉调用方它的处理参数的范围，范围既可是值也可以是类型。针对这样的场景，我们需要给函数安插一种明确的“标识”，告诉编译器：这个函数具有这种特征。  
		所以特质PartialFunction就被创建出来用于“标记”这类函数的(类似于Clonable接口)，这个特质最主要的方法就是isDefinedAt！同时你也记得PartialFunction还是Function1的子类，   
		所以它也要有apply方法，这是非常自然的，偏函数本身首先是一个函数  。
		

		从另一个角度思考，偏函数的逻辑是可以通过普通函数去实现的，只是偏函数是更为优雅的一种方式，同时偏函数特质PartialFunction的存在对调用方和实现方都是一种语义更加丰富的约定，
		比如collect方法声明使用一个偏函数就暗含着它不太可能对每一个元素进行操作，它的返回结果仅仅是针对偏函数“感兴趣”的元素计算出来的


		
- 为什么偏函数只能有一个参数  

		为什么只有针对单一参数的偏函数，而不是像Function特质那样，拥有多个版本的PartialFunction呢？在刚刚接触偏函数时，这也让我感到费解，但看透了偏函数的实质之后就会觉得很合理了。   
		我们说所谓的偏函数本质上是由多个case语句组成的针对每一种可能的参数分别进行处理的一种“结构较为特殊”的函数，那特殊在什么地方呢？对，就是case语句，前面我们提到，case语句声明的变量就是偏函数的参数，  
		既然case语句只能声明一个变量，那么偏函数受限于此，也只能有一个参数！说到底，类型PartialFunction无非是为由一组case语句描述的函数字面量提供一个类型描述而已，case语句只接受一个参数，  
		则偏函数的类型声明自然就只有一个参数。但是，上这并不会对编程造成什么阻碍，如果你想给一个偏函数传递多个参数，完全可以把这些参数封装成一个Tuple传递过去！  

		
		