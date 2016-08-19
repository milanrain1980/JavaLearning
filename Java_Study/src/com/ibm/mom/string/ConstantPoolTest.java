package com.ibm.mom.string;

/**
 *	内存一个非常重要的区域：常量池，它维护了一个已加载类的常量。 
 *	基本类型和基本类型的包装类：基本类型有：byte、short、char、int、long、float, double, boolean；
 *	基本类型的包装类分别是：Byte、Short、Character、Integer、Long、Float, Double, Boolean。
 *	二者的区别是：基本类型体现在程序中是普通变量，基本类型的包装类是类，体现在程序中是引用变量。
 *	因此二者在内存中的存储位置不同：基本类型存储在栈中，而基本类型包装类存储在堆中。
 *	上边提到的这些包装类都实现了常量池技术，而两种浮点数类型的包装类(Float&Double)则没有实现。另外，String类型也实现了常量池技术。
 */
public class ConstantPoolTest {

	public static void main(String[] args) {
		objPoolTest();
	}

	/**
	 * 
	 * 结果分析：

1.i和i0均是普通类型(int)的变量，所以数据直接存储在栈中，而栈有一个很重要的特性：栈中的数据可以共享。当我们定义了int i = 40;，再定义int i0 = 40;这时候会自动检查栈中是否有40这个数据，如果有，i0会直接指向i的40，不会再添加一个新的40。

2.i1和i2均是引用类型，在栈中存储指针，因为Integer是包装类。由于Integer包装类实现了常量池技术，因此i1、i2的40均是从常量池中获取的，均指向同一个地址，因此i1==12。

3.很明显这是一个加法运算，Java的数学运算都是在栈中进行的，Java会自动对i1、i2进行拆箱操作转化成整型，因此i1在数值上等于i2+i3。

4.i4和i5均是引用类型，在栈中存储指针，因为Integer是包装类。但是由于他们各自都是new出来的，因此不再从常量池寻找数据，而是从堆中各自new一个对象，然后各自保存指向对象的指针，所以i4和i5不相等，因为他们所存地址不同，所引用到的对象不同。

5.这也是一个加法运算，和3同理。

6.d1和d2均是引用类型，在栈中存储指针，因为Double是包装类。但Double包装类没有实现常量池技术，因此Doubled1=1.0;相当于Double d1=new Double(1.0);，是从堆new一个对象，d2同理。因此d1和d2存放的指针不同，指向的对象不同，所以不相等。

小结：

1.以上提到的几种基本类型包装类均实现了常量池技术，但他们维护的常量仅仅是【-128至127】这个范围内的常量，如果常量值超过这个范围，就会从堆中创建对象，不再从常量池中取。比如，把上边例子改成Integer i1 = 400; Integer i2 = 400;，很明显超过了127，无法从常量池获取常量，就要从堆中new新的Integer对象，这时i1和i2就不相等了。

2.String类型也实现了常量池技术，但是稍微有点不同。String型是先检测常量池中有没有对应字符串，如果有，则取出来；如果没有，则把当前的添加进去。
	 */
	public static void objPoolTest() {
		int i = 40;
		int i0 = 40;
		Integer i1 = 40;
		Integer i2 = 40;
		Integer i3 = 0;
		Integer i4 = new Integer(40);
		Integer i5 = new Integer(40);
		Integer i6 = new Integer(0);
		Integer i7 = 400;
		Integer i8 = 400;
		Double d1 = 1.0;
		Double d2 = 1.0;
		
		// 在java中对于引用变量来说“==”就是判断这两个引用变量所引用的是不是同一个对象
		System.out.println("i==i0\t" + (i == i0));
		System.out.println("i1==i2\t" + (i1 == i2));
		System.out.println("i1==i2+i3\t" + (i1 == i2 + i3));
		System.out.println("i4==i5\t" + (i4 == i5));
		System.out.println("i4==i5+i6\t" + (i4 == i5 + i6));
		System.out.println("i7==i8\t" + (i7 == i8));
		System.out.println("d1==d2\t" + (d1 == d2));
	}
}
