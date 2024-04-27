package top.ytazwc.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author 花木凋零成兰
 * @title LambdaTest2
 * @date 2024/4/17 9:10
 * @package top.ytazwc.lambda
 * @description TODO
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了,休息一会吧,去买点吃的,花了: " + aDouble);
            }
        });

        System.out.println("\n**********Lambda表达式**********");
        happyTime(500, a -> System.out.println("学习太累了, 请自己吃一份大餐,花了: " + a));

    }
    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        // 获取字符串中有 “京” 的字符串
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString);

        System.out.println("\n**********Lambda表达式**********");
        List<String> stringList = filterString(list, s -> s.contains("京"));
        System.out.println(stringList);

    }
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        List<String> filterList = new ArrayList<>();
        for (String s : list) {
            // 过滤符合条件的字符串
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

}
