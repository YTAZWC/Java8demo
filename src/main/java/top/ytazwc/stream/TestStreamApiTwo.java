package top.ytazwc.stream;

import org.junit.Test;
import top.ytazwc.lambda2.Employee;
import top.ytazwc.lambda2.EmployeeData;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title StreamAPITest2
 * @date 2024/4/23 16:39
 * @package top.ytazwc.stream
 * @description 测试Stream的中间操作——筛选与切片
 */
public class TestStreamApiTwo {

    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        // 查询员工表中 薪资大于7000的员工信息
        list.stream().filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();
        // 查询员工表中 前三条数据
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        // 获得员工表中 跳过前n个元素的数据
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
        // 筛选 去重
        list.add(new Employee(1010, "刘强东", 40, 8000.32));
        list.add(new Employee(1010, "刘强东", 40, 8000.32));
        list.add(new Employee(1010, "刘强东", 40, 8000.32));
        list.add(new Employee(1010, "刘强东", 40, 8000.32));
        list.stream().distinct().forEach(System.out::println);
    }

}
