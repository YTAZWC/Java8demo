package top.ytazwc.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author 花木凋零成兰
 * @title LambdaTest1
 * @date 2024/4/16 14:35
 * @package top.ytazwc.lambda
 * @description 测试Lambda表达式
 */
public class LambdaTest1 {

    @Test
    public void test1() {
        // 语法格式一：无参，无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        System.out.println("**************Lambda表达式*************");
        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
    }

    @Test
    public void test2() {
        // 语法格式二：Lambda 需要一个参数，但是没有返回值。
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("Lambda表达式的本质是什么呢?");

        System.out.println("**************Lambda表达式*************");
        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("Lambda表达式的本质就是: 作为接口的实例");

    }

    @Test
    public void test3() {
        // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为 “类型推断”
        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("Lambda表达式的本质是什么呢?");

        System.out.println("**************Lambda表达式*************");
        Consumer<String> con2 = (s) -> System.out.println(s);
        con1.accept("Lambda表达式的本质就是: 作为接口的实例");

    }

    @Test
    public void test4() {
        // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("Lambda表达式的本质是什么呢?");

        System.out.println("**************Lambda表达式*************");
        Consumer<String> con2 = s -> System.out.println(s);
        con1.accept("Lambda表达式的本质就是: 作为接口的实例");
    }

    @Test
    public void test5() {
        // 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        System.out.println("**************Lambda表达式*************");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(22, 43));

    }

    @Test
    public void test6() {
        // 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(32, 21));

        System.out.println("**************Lambda表达式*************");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(22, 43));

    }


}
