package top.ytazwc.stream;

import org.junit.Test;
import top.ytazwc.lambda2.Employee;
import top.ytazwc.lambda2.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 花木凋零成兰
 * @title TestStreamAPIEnd
 * @date 2024/4/27 15:49
 * @package top.ytazwc.stream
 * @description TODO
 */
public class TestStreamAPIEnd {

    // 匹配和查找(1)
    @Test
    public void test1() {
        // 员工列表
        List<Employee> employees = EmployeeData.getEmployees();
        // 练习1：是否所有员工的年龄都大于18
        // allMatch(Predicate p) 检查是否 匹配所有元素
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        // 练习2：是否存在员工的工资大于10000
        // anyMatch(Predicate p) 检查是否 至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);
        // 练习3：是否存在员工姓“雷”
        // noneMatch(Predicate p) 检查是否 没有匹配所有元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);
        // findFirst() 返回第一个元素
        // 返回员工列表的第一个员工
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        // findAny() 返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    // 匹配和查找(2)
    @Test
    public void test2() {
        // 员工列表
        List<Employee> employees = EmployeeData.getEmployees();
        // count() 返回流中元素总数
        // 返回员工列表中 员工工资大于5000 的员工个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        // 练习1：返回最高的工资
        // max(Comparator c) 返回流中最大值
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(max);
        // 练习2：返回最低工资的员工
        // min(Comparator c) 返回流中最小值
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        // forEach(Consumer c)
        // 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        employees.stream().forEach(System.out::println);
    }

    // 归约
    @Test
    public void test3() {
        // reduce(T identify, BinaryOperator b)
        // 可以将流中元素反复结合起来，得到一个值。返回 T
        // 练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        // reduce(BinaryOperator b)
        // 可以将流中元素反复结合起来，得到一个值。返回 Optional< T>
        // 练习2：计算公司所有员工工资的综合
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduceDouble = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduceDouble);
    }

    // 收集
    @Test
    public void test4() {
        // collect(Collector c)
        // 将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        // 练习：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        // 返回结果为List
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        // 返回结果为Set
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }

}
