# AntzScript

🎓 The language executed in the Antz system.

> 基于以实现的内置vim，接下来需要实现Antz系统中内置语言AntzScript。

[Antz系统更新地址](https://www.cnblogs.com/LexMoon/category/1262287.html)

[Antz项目地址](https://github.com/CasterWx/AntzOS)

[AntzScript项目地址](https://github.com/CasterWx/AntzScript)


| vim |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_vim.gif"> |

 ---------

## <span id="ch01">一、概述</span>

#### 1. 解释器与编译器

##### 1.1 解释器

解释器根据程序中的算法执行运算。简单地说，它是一种用于执行程序的软件。

##### 1.2 编译器

编译器能将某种语言写成的程序转换为另一种语言的程序。通常它会将源程序转换为机器语言程序。编译器转换程序的行为称为编译，转换前的程序称为源程序。

* Java虚拟机为了提高性能，会在执行过程中通过编译器将一部分Java二进制代码直接转换为机器语言使用。

过去的编译器编译过程非常费时，不过由于编译后实际执行的是机器语言，因此执行速度很快。而解释器，会在程序输入的同时立即执行，执行速度较慢。这就是两者的基本区别。

在为Antz制作内置脚本语言时，因为是直接执行，处理器属于解释器，不过，为了提高性能，该解释器内部将采用编译器。

> 基本流程如下

| |
| ------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_1.png"> |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_step.png"> |


#### 2. Token

语言处理器的第一个组成部分是词法分析器（lexer）。程序的源代码最初只是一长串字符串，这样的字符串很难处理，语言处理器通常会首先将字符串中的字符以解析单元分组，切割成多个Token，这就是词法分析。


| 解析结果 |
| ------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_3.png"> |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_2.png"> |

Token类中需要对源代码分割成`最小单元`，并解析出`变量类型`，`数值量`，`符号`，`标识符`等

| Token |
| ------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_4.png"> |
| Token中k代表单元含义,lexeme代表其在代码中的内容。kindMap是一个提前预置关系转换符表。在需要添加其他关键字时可以直接在KindMap中添加。 |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_5.png"> |


词法解析器的实现方法有手工构造法和正则表达式的方法。

| 手工构造法-状态图 |
| ------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_6.png"> |

这种方法较为复杂，需要大量的代码，而正则表达式的方法较为便捷。


## <span id="ch02">二、实现词法解析</span>


借助正则表达式库能简单地实现词法分析器。下表列出的记号在大多数情况下都能使用。例如，`.*\.java`指的是以`.java`结束的任意长度的字符串模式。`.*\.`由两部分组成，`.*`表示由任意字符组成的任意长度的字符串模式，`\.`表示与句点字符相匹配的字符串模式。`(java|javax)\..*`则表示由`java.`或`javax.`起始的任意长度的字符串模式。

| 元字符 | 含义 |
| ------- | ------- |
| . | 与任意字符匹配 |
| [0-9] | 与0至9中的某个数字匹配 |
| [^0-9] | 与0至9这些数字之外的的某个字符匹配 |
| pattern* | 模式pattern至少重复出现0次 |
| pattern+ | 模式pattern至少重复出现1次 |
| pattern? | 模式pattern出现0次或1次 |
| pattern1|pattern2 | 与模式pattern1或模式pattern2匹配 |
| () | 将括号内视为一个完整的模式 |
| \c | 与单个字符c（元字符*或.等）匹配 |


整型字面量的匹配

```
[0-9]+
```

标识符的匹配

```
[A-Z_a-z][A-Z_a-z0-9]*
```

* 以字母、下划线开头，之后仅包含有字母、数字、下划线的就是标识符的定义规则。

```
[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\|\||\p{Punct}
```

最后的`\p{Punct}`表示与任意一个符号字符匹配。模式`\|\|`将会匹配`||`。由于|是正则表达式的元字符，因此在使用时必须添加反斜线转义。

最后需要定义的是字符串字面量。由于不得不处理各种转义字符，字符串字面量的定义略微复杂。

```
"(\\"|\\\\|\\n|[^"])*"
```

首先，从整体上看，这是一个`"(pattern)*"`形式的模式，即双引号内是一个与pattern重复出现至少0次的结果匹配的字符串。其中，模式pattern与`\"`、`\\`、`\n`匹配，同时也与除`"`之外任意一个字符匹配。

所以我们可以得到一个下图的匹配规则regexPat。

> <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_7.png">

`ArrayList<Token> tokens`是词法解析器`Lexer`中已解析的`Token`。

源码source作为参数传入`Lexer`的`add`方法中。

> <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_8.png">

在创建Token时，单元作为构造函数的参数。同时变量,数字值等单元我们无法通过`KindMap`类来判断k值，所以需要在这里判断。

> <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_9.png">

> <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_10.png">


| 判断是否是变量类型 |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_11.png"> |

| 判断是否是数值类型 |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_12.png"> |

| 判断是否是字符串类型 |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_13.png"> |


## <span id="ch03">三、效果</span>

| 测试代码 |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_14.png"> |


| Token解析 |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_15.png"> |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_16.png"> |

将源代码转换为了相应的Token单元，这就是词法解析的主要工作了。

接下来按照源代码获得转换后的直译代码。

| 效果图 |
| -------- |
| <img src="https://www.cnblogs.com/images/cnblogs_com/LexMoon/1391533/o_17.png"> |
