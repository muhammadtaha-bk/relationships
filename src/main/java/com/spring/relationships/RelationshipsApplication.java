package com.spring.relationships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.*;

@SpringBootApplication
public class RelationshipsApplication {
    public static void main(String[] args) {
        System.out.println("Bismillah");
//        countFreq("every day in every way i am getting better and better");
//        int[][] a = {{1, 2}, {4, 7, 6}};
//        int[] b = {1, 2, 3, 4, 5, 7, 8, 9, 10};
//        LinkedList<Integer> list =  new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);

//        isPalindrome("madam");
//        nxnSum(a);
//        missing(b);
//        findMiddle(list);
		SpringApplication.run(RelationshipsApplication.class, args);
    }

    private static void isPalindrome(String str) {
        String temp = "";
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            characterStack.push(str.charAt(i));
        }
        for (int i = characterStack.size(); i > 0; i--) {
            temp += characterStack.pop();
        }
        if (str.equals(temp)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static void findMiddle(LinkedList<Integer> list) {
        System.out.println(list.get((int) Math.ceil(list.size() / 2)));
    }

    private static void missing(int[] b) {
        int result = ((b.length + 1) * (b.length + 2)) / 2;
        for (int i = 0; i < b.length; i++) {
            result -= b[i];
        }
        System.out.println("missing number is " + result);
    }

    static void nxnSum(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    static void countFreq(String str) {
        Map<String, Integer> mp = new HashMap<>();
        String arr[] = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
