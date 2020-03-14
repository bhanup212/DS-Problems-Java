package com.bhanu;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProblem {

    //count of lexicographically smaller characters
    static void countOfString(String s){
        for (int i=0;i<s.length();i++){
            int count = 0;
            for (int j=i+1;j<s.length();j++){
                if (s.charAt(j)<s.charAt(i)){
                    count+=1;
                }
            }
            System.out.print(count+" ");
        }
    }
    /**
     * vertical order of traversal in strings
     */
    static void strTraversal(String str){
        String[] strArray = str.split(" ");
        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int i = 0;i<strArray.length;i++){
            for (int j=0;j<strArray[i].length();j++){
                hashMap.put(j,hashMap.getOrDefault(j,"")+strArray[i].charAt(j));
            }
        }
        System.out.println("Hashmap is: "+hashMap.toString());
    }
    /**
     * print all sub strings of a given string
     */
    static void subString(String str){
        char strChar[] = str.toCharArray();

        for (int i = 0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
    /**
     * find all emails in a text file
     */
    static void findEmails(String emailTxt){
        String emailRegex = "[a-zA-Z0-9]"
                + "[a-zA-Z0-9_.]"
                +"*@[a-zA-Z0-9]"
                +"([.][a-zA-Z]+)+";
        Matcher matcher = Pattern.compile(emailRegex).matcher(emailTxt);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
    static void amendSentence(char ch){
        char amended = (char)(ch+32);
        System.out.println("char is: "+amended);
    }
}
