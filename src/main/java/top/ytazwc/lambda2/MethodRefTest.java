package top.ytazwc.lambda2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1. 使用情景： 当传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 方法引用 本质上就是Lambda表达式 而Lambda表达式是作为函数式接口的实例出现
 * 所有 方法引用 也是函数式接口的实例
 *
 * 3. 使用格式：类(或对象)::调用方法名
 * 4. 具体分为如下三种情况：
 * 		对象 :: 非静态方法
 * 		类 :: 静态方法
 * 		类 :: 非静态方法
 * 5. 方法引用使用的要求：
 * 	  要求接口中的 抽象方法的形参列表和返回值类型 与 方法引用的方法的参数列表和返回值类型相同(主要是情况1和情况2)
 * @author 花木凋零成兰
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		// 使用Lambda表达式
		Consumer<String> con1 = s -> System.out.println(s);
		con1.accept("北京");

		System.out.println("************方法引用************");
		Consumer<String> con2 = System.out::println;
		con2.accept("南京");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1010, "tom", 21, 5699);
		Supplier<String> sup1 = () -> emp.getName();
		System.out.println(sup1.get());

		System.out.println("************方法引用************");
		Supplier<String> sup2 = emp::getName;
		System.out.println(sup1.get());
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(com1.compare(12, 21));

		System.out.println("************方法引用************");
		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(12, 3));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> func1 = d -> Math.round(d);
		System.out.println(func1.apply(12.3));

		System.out.println("************方法引用************");
		Function<Double, Long> func2 = Math::round;
		System.out.println(func2.apply(12.6));
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int compare(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
		System.out.println(com1.compare("abc", "abd"));

		System.out.println("************方法引用************");
		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("abd", "abm"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
		System.out.println(pre1.test("abc", "abc"));
		System.out.println("************方法引用************");
		BiPredicate<String, String> pre2 = String::equals;
		System.out.println(pre2.test("abc", "abd"));
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee emp = new Employee(1001, "Jerry", 23, 6000);
		Function<Employee, String> func1 = e -> e.getName();
		System.out.println(func1.apply(emp));
		System.out.println("************方法引用************");
		Function<Employee, String> func2 = Employee::getName;
		System.out.println(func2.apply(emp));
	}

}
