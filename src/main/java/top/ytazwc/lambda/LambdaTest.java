package top.ytazwc.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author 花木凋零成兰
 * @title LambdaTest
 * @date 2024/4/16 14:04
 * @package top.ytazwc.lambda
 * @description TODO
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        System.out.println("***********Lambda表达式*************");
        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
    }

    @Test
    public void test2() {

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("***********Lambda表达式*************");
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(32, 21);
        System.out.println(compare2);

        // 方法引用的写法
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(21, 21);
        System.out.println(compare3);

    }

}
