package com.tahir.artificialintelligence.service;

import java.util.*;

public class Samples {
    public static void main(String[] args) {
        String str="Assalomu Alaykum va Rahmatullohu va Barakotu";

        // solution with Map
        Map<Character,Integer> map= new HashMap<>();

        char[] ch=str.replace(" ","").toLowerCase().toCharArray();

        for (char c:ch) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        map.entrySet().stream()
                .forEach(System.out::println);


        // solution with Set

        Set<Character> set=new HashSet<>();
        for (char s1 : ch) {
            set.add(s1);
        }

        for (char c:set) {
            long count = str.toLowerCase().chars().filter(a -> a == c).count();
            System.out.println("Occurance of character '" + c + "':" + count);
        }


    }
}
