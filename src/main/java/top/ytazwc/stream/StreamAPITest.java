package top.ytazwc.stream;

import org.junit.Test;
import top.ytazwc.lambda2.Employee;
import top.ytazwc.lambda2.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 花木凋零成兰
 * @title StreamAPITest
 * @date 2024/4/23 15:13
 * @package top.ytazwc.stream
 * @description 测试Stream的实例化
 */
public class StreamAPITest {

    @Test
    public void test1() {
        // 创建 Stream方式一：通过集合
        List<Employee> employees = EmployeeData.getEmployees();
        // 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        // 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    @Test
    public void test2() {
        // 创建 Stream方式二：通过数组
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
        Employee[] arr1 = new Employee[] {new Employee(1001, "Tom")};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    @Test
    public void test3() {
        // 创建 Stream方式三：通过Stream的of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void test4() {
        // 创建 Stream方式四：创建无限流
        // 迭代
        // 遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }



}
