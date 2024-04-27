package top.ytazwc.stream;

import org.junit.Test;
import top.ytazwc.lambda2.Employee;
import top.ytazwc.lambda2.EmployeeData;

import java.util.Arrays;
import java.util.List;

/**
 * @author 花木凋零成兰
 * @title TestStreamAPISorted
 * @date 2024/4/27 15:25
 * @package top.ytazwc.stream
 * @description 学习StreamAPI中间过程 —— 排序
 */
public class TestStreamAPISorted {
    @Test
    public void test4() {
        // Sorted —— 自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 87, 0, -32, 8);
        list.stream().sorted().forEach(System.out::println);
        // 涉及对象排序
        // 对象需要实现Comparable
        // 或使用 sorted(Comparator com) 定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        // employee 按年龄从小到大排序 相等时按照 salary从小到大排序
        employees.stream()
                .sorted( (e1, e2) -> {
                    int ageValue = Integer.compare(e1.getAge(), e2.getAge());
                    if (ageValue == 0) {
                        return Double.compare(e1.getSalary(), e2.getSalary());
                    } else {
                        return ageValue;
                    }
                } )
                .forEach(System.out::println);
    }
}
