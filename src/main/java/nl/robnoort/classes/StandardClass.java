package nl.robnoort.classes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandardClass {

    private int employeeId;

    public static void main(String[] args) {
        System.out.println(testStreamIsPangramWithStreams("The quick brown fox jumps over the lazy dog"));
        StandardClass test = new StandardClass();

        test.testUnmodifiableSet();

    }

    public static boolean testStreamIsPangramWithStreams(String str) {
        final int ALPHABET_COUNT = 26;

        // Nieuwe

        if (str == null) {
            return false;
        }
        String strUpper = str.toUpperCase();

        Stream<Character> filteredCharStream = strUpper.chars()
                .filter(item -> ((item >= 'A' && item <= 'Z')))
                .mapToObj(c -> (char) c);


        Map<Character, Boolean> alphabetMap =
                filteredCharStream.filter(item -> ((item >= 'A' && item <= 'Z'))).collect(Collectors.toMap(item -> item, k -> Boolean.TRUE, (p1, p2) -> p1));


        return (alphabetMap.size() == ALPHABET_COUNT);
    }

    public void testUnmodifiableSet() {
        // create and initialize the set instance
        Set<String> set = new HashSet<>();
        set.add("Canada");
        set.add("USA");

        // create an unmodifiable set of this set
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
      //  unmodifiableSet.add("Costa Rica"); //runtime error java.lang.UnsupportedOperationException

    }


 @Override public int hashCode() {
     return employeeId;
 }


 // NOT VALID, CLASH
// 'equals(Object)' in 'nl.robnoort.OCPtest' clashes with 'equals(Object)' in 'java.lang.Object';
// attempting to assign weaker access privileges ('private'); was 'public'

//    @Override private boolean equals(Object ocPtest){
//        if(!(ocPtest instanceof OCPtest))return false;
//        return this.employeeId==((OCPtest) ocPtest).employeeId;
//    }

    // No override, wrong name @Override
    public boolean Equals(Object ocPtest){
        if(!(ocPtest instanceof StandardClass))return false;
        return this.employeeId==((StandardClass) ocPtest).employeeId;
    }

// VALID override correct name correct access right parameter correct return type
    @Override public boolean equals(Object object){
        if(!(object instanceof StandardClass))return false;
        return this.employeeId==((StandardClass) object).employeeId;
    }

    // NOT AN OVERRIDE AND CLASH WITH VALID equals
    // Method does not override method from its superclass
    // 'equals(OCPtest)' clashes with 'equals(OCPtest)'; both methods have same erasure
//    @Override public int equals(OCPtest ocPtest){
//        return this.employeeId;
//    }
 // not an @Override wrong parameter
   public boolean equals(StandardClass standardClass){
        return this.employeeId==standardClass.employeeId;
 }
}