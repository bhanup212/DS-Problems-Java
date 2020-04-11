package com.bhanu;

import java.util.*;
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
    /**
     * Reverse vowels in string
     */
    static void reverseVowels(String s){
       int i =0;
       int j = s.length()-1;
       char[] charArray = s.toCharArray();
       while (i<j){

           if (!isVowel(charArray[i])){
               i++;
               continue;
           }
           if (!isVowel(charArray[j])){
               j--;
               continue;
           }
           char temp = charArray[i];
           charArray[i] = charArray[j];
           charArray[j] = temp;

           i++;
           j--;
       }
        System.out.println("Reverse of Vowel String: "+ String.copyValueOf(charArray));
    }
    static boolean isVowel(char c){
        return ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0,i=0,j=0;
        Set<Character> set = new HashSet<>();
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public static int reverse(int x) {
        int rev_num = 0;
        while (x != 0){
            System.out.println("modules: "+(rev_num % 10));
            System.out.println("divide: "+(x / 10));
            rev_num = rev_num * 10 + x % 10;
            x = x/10;
        }
        System.out.println("reverse no: "+rev_num);
        return rev_num;
    }


    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;

        if (str.length() == 0) return 0;
        str.trim();
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }else if (str.charAt(index) == '+'){
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            index++;
        }

        return total * sign;
    }
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackA = new Stack();
        Stack<Character> stackB = new Stack();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) != '#'){
                stackA.push(S.charAt(i));
            }else{
                stackA.pop();
            }
        }

        for(int j=0;j<T.length();j++){
            if(T.charAt(j) != '#'){
                stackB.push(T.charAt(j));
            }else{
                stackB.pop();
            }
        }
        String A = "", B = "";

        while(!stackA.isEmpty()){
            A+=stackA.pop();
        }

        while(!stackB.isEmpty()){
            B+=stackB.pop();
        }
        System.out.println("A: "+A+" B: "+B);
        return A.equals(B);
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0) return 0;

        for(int i=0;i<haystack.length();i++){
            int j=0;
            int startIndex = i;
            while(startIndex <haystack.length() && j <needle.length() && haystack.charAt(startIndex) == needle.charAt(j)){
                startIndex++;
                j++;
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }

}
