 Last modified 2021-8-8; size 1185 bytes
  MD5 checksum 4695a393b9d066b7f8901418dd4329b6
  Compiled from "Hello.java"
public class Hello
  minor version: 0
  major version: 49
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #15.#38        // java/lang/Object."<init>":()V
   #2 = Class              #39            // java/util/ArrayList
   #3 = Methodref          #2.#38         // java/util/ArrayList."<init>":()V
   #4 = Methodref          #9.#40         // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   #5 = InterfaceMethodref #41.#42        // java/util/List.add:(Ljava/lang/Object;)Z
   #6 = InterfaceMethodref #41.#43        // java/util/List.iterator:()Ljava/util/Iterator;
   #7 = InterfaceMethodref #44.#45        // java/util/Iterator.hasNext:()Z
   #8 = InterfaceMethodref #44.#46        // java/util/Iterator.next:()Ljava/lang/Object;
   #9 = Class              #47            // java/lang/Integer
  #10 = Methodref          #9.#48         // java/lang/Integer.intValue:()I
  #11 = InterfaceMethodref #41.#49        // java/util/List.get:(I)Ljava/lang/Object;
  #12 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
  #13 = Methodref          #52.#53        // java/io/PrintStream.println:(I)V
  #14 = Class              #54            // Hello
  #15 = Class              #55            // java/lang/Object
  #16 = Utf8               <init>
  #17 = Utf8               ()V
  #18 = Utf8               Code
  #19 = Utf8               LineNumberTable
  #20 = Utf8               LocalVariableTable
  #21 = Utf8               this
  #22 = Utf8               LHello;
  #23 = Utf8               main
  #24 = Utf8               ([Ljava/lang/String;)V
  #25 = Utf8               sum
  #26 = Utf8               I
  #27 = Utf8               result
  #28 = Utf8               num
  #29 = Utf8               Ljava/lang/Integer;
  #30 = Utf8               args
  #31 = Utf8               [Ljava/lang/String;
  #32 = Utf8               nums
  #33 = Utf8               Ljava/util/List;
  #34 = Utf8               LocalVariableTypeTable
  #35 = Utf8               Ljava/util/List<Ljava/lang/Integer;>;
  #36 = Utf8               SourceFile
  #37 = Utf8               Hello.java
  #38 = NameAndType        #16:#17        // "<init>":()V
  #39 = Utf8               java/util/ArrayList
  #40 = NameAndType        #56:#57        // valueOf:(I)Ljava/lang/Integer;
  #41 = Class              #58            // java/util/List
  #42 = NameAndType        #59:#60        // add:(Ljava/lang/Object;)Z
  #43 = NameAndType        #61:#62        // iterator:()Ljava/util/Iterator;
  #44 = Class              #63            // java/util/Iterator
  #45 = NameAndType        #64:#65        // hasNext:()Z
  #46 = NameAndType        #66:#67        // next:()Ljava/lang/Object;
  #47 = Utf8               java/lang/Integer
  #48 = NameAndType        #68:#69        // intValue:()I
  #49 = NameAndType        #70:#71        // get:(I)Ljava/lang/Object;
  #50 = Class              #72            // java/lang/System
  #51 = NameAndType        #73:#74        // out:Ljava/io/PrintStream;
  #52 = Class              #75            // java/io/PrintStream
  #53 = NameAndType        #76:#77        // println:(I)V
  #54 = Utf8               Hello
  #55 = Utf8               java/lang/Object
  #56 = Utf8               valueOf
  #57 = Utf8               (I)Ljava/lang/Integer;
  #58 = Utf8               java/util/List
  #59 = Utf8               add
  #60 = Utf8               (Ljava/lang/Object;)Z
  #61 = Utf8               iterator
  #62 = Utf8               ()Ljava/util/Iterator;
  #63 = Utf8               java/util/Iterator
  #64 = Utf8               hasNext
  #65 = Utf8               ()Z
  #66 = Utf8               next
  #67 = Utf8               ()Ljava/lang/Object;
  #68 = Utf8               intValue
  #69 = Utf8               ()I
  #70 = Utf8               get
  #71 = Utf8               (I)Ljava/lang/Object;
  #72 = Utf8               java/lang/System
  #73 = Utf8               out
  #74 = Utf8               Ljava/io/PrintStream;
  #75 = Utf8               java/io/PrintStream
  #76 = Utf8               println
  #77 = Utf8               (I)V
{
  public Hello();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0                           ## 加载本地变量表第0个位置元素
         1: invokespecial #1                  ## 调用Object的初始化方法// Method java/lang/Object."<init>":()V
         4: return                            ## 返回
      LineNumberTable:                         
        line 4: 0
      LocalVariableTable:                     ## 本地变量表 将Hello Class 引用放入到本地变量表第0个位置
        Start  Length  Slot  Name   Signature
            0       5     0  this   LHello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=6, args_size=1          ##栈的深度2，本地变量表6个， 参数1个
         0: new           #2                  ## new ArrayList// class java/util/ArrayList
         3: dup                               ## 压栈
         4: invokespecial #3                  ##调用ArrayList的初始化方法 //Method java/util/ArrayList."<init>":()V
         7: astore_1                          ## 存入本地变量表第1个位置
         8: aload_1                           ## 加载本地变量表第1个位置（引用类型）
         9: iconst_1                          ## 加载常量1到操作数栈
        10: invokestatic  #4                  ## 调用Integer.valueOf // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        13: invokeinterface #5,  2            ## 调用ArrayList的add方法// InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
        18: pop                               ## 从栈顶弹出一个字长的数据。
        19: aload_1                           ## 加载本地变量表第1个位置（引用类型）ArrayList
        20: bipush        10                  ## 加载常量10到操作数栈
        22: invokestatic  #4                  ## 调用Integer.valueOf  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        25: invokeinterface #5,  2            ## 调用ArrayList的add方法// InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
        30: pop                               ## 从栈顶弹出一个字长的数据。
        31: aload_1                           ## 加载本地变量表第1个位置（引用类型）ArrayList
        32: bipush        12                  ## 加载常量12到操作数栈
        34: invokestatic  #4                  ## 调用Integer.valueOf   // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        37: invokeinterface #5,  2            ## 调用ArrayList的add方法 // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
        42: pop                               ##从栈顶弹出一个字长的数据。
        43: aload_1                           ## 加载本地变量表第1个位置（引用类型）ArrayList
        44: invokeinterface #6,  1            ##调用 List.iterator // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
        49: astore_2                          ## Iterator 存入本地变量表第2个
        50: aload_2                           ## 加载本地变量表第2个
        51: invokeinterface #7,  1            ## 调用Iterator.hasNext // InterfaceMethod java/util/Iterator.hasNext:()Z
        56: ifeq          116                 ## 遍历完List 返回 
        59: aload_2                           ## 加载 本地变量表第2个 Iterator
        60: invokeinterface #8,  1            ## 调用Iterator.next // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
        65: checkcast     #9                  ## 校验类型强转Integer// class java/lang/Integer
        68: astore_3                          ## iterator.next的数据存入本地变量表第3个
        69: aload_3                           ## 加载本地变量表第3个
        70: invokevirtual #10                 ## 调用Integer.intValue，获取int// Method java/lang/Integer.intValue:()I
        73: bipush        10                  ## 加载常量10到本地变量表
        75: if_icmple     113                 ## 如果next<10 return
        78: aload_1                           ## 加载ArrayList
        79: iconst_0                          ## 加载常量0到操作数栈
        80: invokeinterface #11,  2           ## 调用List.get// InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
        85: checkcast     #9                  ## 校验类型强转Integer// class java/lang/Integer
        88: invokevirtual #10                 ## 调用Integer.intValue ，获取int// Method java/lang/Integer.intValue:()I
        91: aload_3                           ## 加载 next 
        92: invokevirtual #10                 ## 调用Integer.intValue // Method java/lang/Integer.intValue:()I
        95: iadd                              ## Integer 相加
        96: istore        4                   ## 存入本地本量表第四个
        98: iload         4                   ## 加载本地变量表第四个
       100: bipush        30                  ## 加载常量30
       102: isub                              ## 相减
       103: istore        5                   ## 存入本地变量表第5个
       105: getstatic     #12                 ## 调用静态犯法// Field java/lang/System.out:Ljava/io/PrintStream;
       108: iload         5                   ## 加载 本地变量表第5个
       110: invokevirtual #13                 ## 调用PrintStream.println// Method java/io/PrintStream.println:(I)V
       113: goto          50                  ## 调转50 偏移量
       116: return                            ## 返回
      LineNumberTable:
        line 6: 0
        line 7: 8
        line 8: 19
        line 9: 31
        line 10: 43
        line 11: 69
        line 12: 78
        line 13: 98
        line 14: 105
        line 16: 113
        line 17: 116
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           98      15     4   sum   I
          105       8     5 result   I
           69      44     3   num   Ljava/lang/Integer;
            0     117     0  args   [Ljava/lang/String;
            8     109     1  nums   Ljava/util/List;
      LocalVariableTypeTable:
        Start  Length  Slot  Name   Signature
            8     109     1  nums   Ljava/util/List<Ljava/lang/Integer;>;
}
SourceFile: "Hello.java"