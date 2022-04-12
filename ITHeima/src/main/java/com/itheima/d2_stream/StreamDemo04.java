package com.itheima.d2_stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo04 {
    public static Double allMoney = 0D;
    public static Double allMoney2 = 0D;


    public static void main(String[] args) {

        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒", '男', 30000, 25000, null));
        one.add(new Employee("孙悟空", '男', 25000, 1000, "顶撞上司"));
        one.add(new Employee("沙僧", '男', 20000, 20000, null));
        one.add(new Employee("小白龙", '男', 20000, 25000, null));

        List<Employee> two = new ArrayList<>();
        two.add(new Employee("武松", '男', 15000, 9000, null));
        two.add(new Employee("李逵", '男', 20000, 10000, null));
        two.add(new Employee("西门庆", '男', 20000, 20000, "被打"));
        two.add(new Employee("潘金莲", '女', 20000, 25000, "被打"));
        two.add(new Employee("武大郎", '男', 20000, 25000, "下毒"));

        //1.开发一部的最高工资的员工
        //制定大小规则
        Employee employee = one.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getSalary() + e1.getBonus() > e2.getSalary() + e1.getBonus()) {
                    return 1;
                } else if (e1.getSalary() + e1.getBonus() < e2.getSalary() + e1.getBonus()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }).get();
        System.out.println("employee:" + employee);
        Employee employee1 = one.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus());
            }
        }).get();
        System.out.println("employee1:" + employee1);
        Employee topMoney = one.stream().max((e1, e2) -> Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus())).get();
        System.out.println(topMoney);

        //Map加工方法 第一个参数是原材料 第二个参数是加工后的结果
        TopPerformer topPerfermoer = (TopPerformer) one.stream().max((e1, e2) -> Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus()))
                .map(new Function<Employee, Object>() {
                    @Override
                    public Object apply(Employee employee) {
                        return new TopPerformer(employee.getName(), employee.getSalary() + employee.getBonus());
                    }
                }).get();
        System.out.println(topPerfermoer);

        TopPerformer topPerformer = one.stream().max((e1, e2) -> Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus())).map(e -> new TopPerformer(e.getName(), e.getSalary() + e.getBonus())).get();
        System.out.println("topPerformer2:" + topPerformer);

        System.out.println("========================");

        //2、统计平均工资 去掉最高工资和最低工资
        //注意 流里面无法用局部变量 应为虽然写的很简单 但是这这是一个新方法 是一个新方法就是在一个新的栈中
        one.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus());
            }
        }).forEach(e -> System.out.println(e));
        //skip(1)跳过最低的工资 总数-2 是应为去掉一个最高 去掉一个最低 总共去掉了2个
        one.stream().sorted((e1, e2) -> Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus())).skip(1L).limit(one.size() - 2)
                .forEach(e -> allMoney += (e.getSalary() + e.getBonus()));

        System.out.println("开发一部的平均工资是：" + allMoney / (one.size() - 2));

        Stream<Employee> s1 = one.stream();
        Stream<Employee> s2 = two.stream();
        Stream<Employee> s3 = Stream.concat(s1, s2);
        s3.sorted((e1, e2) -> Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary() + e2.getBonus())).skip(1L).limit(one.size() + two.size() - 2)
                .forEach(e -> allMoney2 += (e.getSalary() + e.getBonus()));
        BigDecimal a = BigDecimal.valueOf(allMoney2);
        BigDecimal b = BigDecimal.valueOf(one.size() + two.size() - 2);
        System.out.println("开发一部、二部的平均工资是：" + a.divide(b,2, RoundingMode.HALF_UP));

    }
}
