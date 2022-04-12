package com.company.test;

import java.util.HashMap;
import java.util.Map;

public class HashTest {
    public static void main(String[] args){
        Map<String,Integer> hashMap =  new HashMap<>();
        hashMap.put("k1",1);
        hashMap.put("k2",1);
        hashMap.put("k3",1);
        hashMap.put("k4",1);
        hashMap.put("k5",1);
        System.out.println(hashMap.toString());
    }
}
