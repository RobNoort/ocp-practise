package nl.robnoort.lambda;

import java.util.function.Predicate;

public class TestLambda {

    public TestLambda() {
    }

    public static void main(String[] args) {

        Predicate<Integer> greaterThanTen = (i) -> i > 10; 
  
        // Creating predicate 
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;  

        // chaining
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15); 
        System.out.println(result); 
  
        // Calling Predicate method 
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15); 
        System.out.println(result2); 

        // using method
        printDependingOnPredicate(10, (i) -> i > 7); 

    }
    static void printDependingOnPredicate(int number, Predicate<Integer> predicate) 
    { 
        if (predicate.test(number)) { 
            System.out.println("Number " + number); 
        } 
    } 

}