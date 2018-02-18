# 一天一个设计模式 - Template

## Template 模式

Template 字面上的含义就是模板的意思，比如朋友们喜欢的神秘花园。

只要用不同颜色的笔就能涂出美丽的效果，如果我们用纯色的笔来涂，那么它就是纯色的；如果我们用彩色的笔来涂，那么它就是五颜六色的。**但是无论我们用什么笔来涂，它都是模板给的样子，就像上边那只孔雀，不管是什么颜色的孔雀，都是一只孔雀。**

简单来说，Template 模式就是 **在父类中定义处理流程框架，在子类中实现具体处理** 的模式。

我们用一个简单的栗子来说明。

我们现在要打印字符或者字符串

- 如果是字符的话就让它循环打印10遍（不换行）并在前后加上“<>”，例如

```
<AAAAA>
```

- 如果是字符串的话，就让它循环打印10遍（换行）并在首尾行加上与字符串等长的“+”，例如

```
+++++++++++
Hello,world
Hello,world
Hello,world
...
Hello,world
+++++++++++
```

### DisplayTemplate

首先我们定义一个模板，也就是一个抽象类 DisplayTemplate，这里面有一系列抽象方法：`begin()`、`end()`、`print()` ，和一个**模板方法** `display()` 负责把这一系列抽象方法组成一个工作模板。

```java
/**
 * 抽象类 DisplayTemplate
 */
public abstract class DisplayTemplate {

    public abstract void print();
    public abstract void begin();
    public abstract void end();

    //  调用抽象方法组成模板
    public final void display() {
        begin();
        for(int i = 0 ; i < 10 ; i++) {
            print();
        }
        end();
    }
}
```

### DisplayChar

然后我们来实现模板中定义的抽象方法，展示一个字符。

```java
/**
 * 实现模板中的抽象方法，展示字符
 */
public class DisplayChar extends DisplayTemplate{

    private char ch;

    public DisplayChar(char ch) {
        this.ch = ch;
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void begin() {
        System.out.print("<");
    }

    @Override
    public void end() {
        System.out.println(">");
    }

}
```

### DisplayString

接着实现展示字符串。

```java
/**
 * 具体实现模板中的抽象方法，展示字符串
 */
public class DisplayString extends DisplayTemplate {

    private String str;

    public DisplayString(String str) {
        this.str = str;
    }

    private void printLine() {
        for(int i = 0 ; i < str.length(); i++) {
            System.out.print("+");
        }
        System.out.println();
    }

    @Override
    public void print() {
        System.out.println(str);
    }

    @Override
    public void begin() {
        printLine();
    }

    @Override
    public void end() {
        printLine();
    }
}
```

至此，我们就实现了不同方式展示字符和字符串，但又同样遵循同一种展示框架。

**代码地址：**https://github.com/MrNullPoint/TemplateExp

## 解惑

### 逻辑处理通用化

很多时候，我们的业务逻辑是可以抽象出来的，如果我们在父类中定义好了程序逻辑或者实现完了算法，在子类中就不用考虑程序逻辑和算法一类的问题，如果逻辑或者算法出现了 Bug，我们只需要找到父类修改 **模板方法** 即可。

