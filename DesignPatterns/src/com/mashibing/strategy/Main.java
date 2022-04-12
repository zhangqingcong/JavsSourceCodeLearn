package com.mashibing.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] a = {9,2,3,5,7,1,4};
        Cat[] a = {new Cat(2,2),new Cat(3,3),new Cat(1,1)};
        Dog dog0 = new Dog();
        dog0.setHeight(8);
        Dog dog1 = new Dog();
        dog1.setHeight(5);
        Dog dog2 = new Dog();
        dog2.setHeight(9);
//        Dog[] a ={dog0,dog1,dog2};
        Sorter<Cat> sorter = new Sorter<>();
//        sorter.sort(a,new CatHeightComparator());
        sorter.sort(a,((o1, o2) -> {
            if (o1.weight<o2.weight) return -1;
            else if (o1.weight>o2.weight) return 1;
            else return 0;
        }));
        System.out.println(Arrays.toString(a));
    }
}
