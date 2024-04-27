package top.ytazwc.stream;

import org.junit.Test;
import top.ytazwc.lambda2.Employee;
import top.ytazwc.lambda2.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 花木凋零成兰
 * @title StreamApiTest3
 * @date 2024/4/27 10:32
 * @package top.ytazwc.stream
 * @description StreamAPI 中间操作 —— 映射
 */
public class TestStreamApiThree {

    @Test
    public void test1() {
        // map(Function f)
        // 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        // 将列表中的字符串 都转化为大写字母
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        // 练习1：获取员工姓名长度大于3的员工的姓名
        // 1.获取员工列表
        List<Employee> employees = EmployeeData.getEmployees();
        // 2.获取Stream对象
        // 然后将员工列表转化为 员工姓名字符串列表 接着进行过滤并输出
        employees.stream()
                .map(Employee::getName)
                .filter(name -> name.length() > 3)
                .forEach(System.out::println);

        // 练习2：
        // fromStringToStream方法：将字符串的多个字符 构成一个集合 并转化为对应的Stream的实例
        Stream<Stream<Character>> streamStream = list.stream().map(this::fromStringToStream);
        // 如果需要遍历streamStream中的Character变量 需要使用两层for循环 比如List<List<Character>>
        // 即第一个forEach获得一个Stream<Character>
        // 然后接着对Stream<Character> 继续forEach
        streamStream.forEach(s -> s.forEach(System.out::println));
        // flatMap(Function f)
        // 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        // 比如说一个集合有三个元素 将其转化为三个流 而不是和map一样一个流进行处理
        // 即上述list则直接将第一层的Stream打开
        Stream<Character> characterStream = list.stream().flatMap(this::fromStringToStream);
        // 此时只需一个forEach
        characterStream.forEach(System.out::println);

    }
    // 将字符串的多个字符 构成一个集合 并转化为对应的Stream的实例
    public Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

}
