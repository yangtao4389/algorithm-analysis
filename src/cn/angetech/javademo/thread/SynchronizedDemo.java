package cn.angetech.javademo.thread;
/*
* 研究synchronized的作用
* 参考：https://snailclimb.gitee.io/javaguide-interview/#/./docs/b-3Java%E5%A4%9A%E7%BA%BF%E7%A8%8B?id=_2310-%e4%b8%ba%e4%bb%80%e4%b9%88%e6%88%91%e4%bb%ac%e8%b0%83%e7%94%a8-start-%e6%96%b9%e6%b3%95%e6%97%b6%e4%bc%9a%e6%89%a7%e8%a1%8c-run-%e6%96%b9%e6%b3%95%ef%bc%8c%e4%b8%ba%e4%bb%80%e4%b9%88%e6%88%91%e4%bb%ac%e4%b8%8d%e8%83%bd%e7%9b%b4%e6%8e%a5%e8%b0%83%e7%94%a8-run-%e6%96%b9%e6%b3%95%ef%bc%9f
*
* 首先注释掉 package cn.angetech.javademo.thread;
* 在命令行 使用 javac SynchronizedDemo.java
* 然后再使用分析工具：
*  javap -c -s -v -l SynchronizedDemo.class
*
Classfile /F:/yangtao/javalearn/algorithm-analysis/src/cn/angetech/javademo/thre                                                                                                                                                                                               ad/SynchronizedDemo.class
  Last modified 2020-4-15; size 528 bytes
  MD5 checksum ff40b822c1891f285790ea00dbfe055b
  Compiled from "SynchronizedDemo.java"
public class SynchronizedDemo
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#18         // java/lang/Object."<init>":()V
   #2 = Fieldref           #19.#20        // java/lang/System.out:Ljava/io/Print                                                                                                                                                                                               Stream;
   #3 = String             #21            // synchronized
   #4 = Methodref          #22.#23        // java/io/PrintStream.println:(Ljava/                                                                                                                                                                                               lang/String;)V
   #5 = Class              #24            // SynchronizedDemo
   #6 = Class              #25            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               method
  #12 = Utf8               StackMapTable
  #13 = Class              #24            // SynchronizedDemo
  #14 = Class              #25            // java/lang/Object
  #15 = Class              #26            // java/lang/Throwable
  #16 = Utf8               SourceFile
  #17 = Utf8               SynchronizedDemo.java
  #18 = NameAndType        #7:#8          // "<init>":()V
  #19 = Class              #27            // java/lang/System
  #20 = NameAndType        #28:#29        // out:Ljava/io/PrintStream;
  #21 = Utf8               synchronized
  #22 = Class              #30            // java/io/PrintStream
  #23 = NameAndType        #31:#32        // println:(Ljava/lang/String;)V
  #24 = Utf8               SynchronizedDemo
  #25 = Utf8               java/lang/Object
  #26 = Utf8               java/lang/Throwable
  #27 = Utf8               java/lang/System
  #28 = Utf8               out
  #29 = Utf8               Ljava/io/PrintStream;
  #30 = Utf8               java/io/PrintStream
  #31 = Utf8               println
  #32 = Utf8               (Ljava/lang/String;)V
{
  public SynchronizedDemo();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>                                                                                                                                                                                               ":()V
         4: return
      LineNumberTable:
        line 3: 0

  public void method();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=3, args_size=1
         0: aload_0
         1: dup
         2: astore_1
         3: monitorenter
         4: getstatic     #2                  // Field java/lang/System.out:Ljav                                                                                                                                                                                               a/io/PrintStream;
         7: ldc           #3                  // String synchronized
         9: invokevirtual #4                  // Method java/io/PrintStream.prin                                                                                                                                                                                               tln:(Ljava/lang/String;)V
        12: aload_1
        13: monitorexit
        14: goto          22
        17: astore_2
        18: aload_1
        19: monitorexit
        20: aload_2
        21: athrow
        22: return
      Exception table:
         from    to  target type
             4    14    17   any
            17    20    17   any
      LineNumberTable:
        line 5: 0
        line 6: 4
        line 7: 12
        line 8: 22
      StackMapTable: number_of_entries = 2
        frame_type = 255 //full_frame
          offset_delta = 17
                  locals = [ class SynchronizedDemo, class java/lang/Object ]
        stack = [ class java/lang/Throwable ]
        frame_type = 250   // chop
        offset_delta = 4
        }
        SourceFile: "SynchronizedDemo.java"


* */


public class SynchronizedDemo {
    public void method(){
        synchronized (this){
            System.out.println("synchronized ");
        }
    }
}
