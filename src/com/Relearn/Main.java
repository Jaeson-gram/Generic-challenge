package com.Relearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        QueryList<LPAStudents> queryList = new QueryList<>();

        for (int i = 0; i < 25; i++){
            queryList.add(new LPAStudents());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());

        printList(queryList);

        System.out.println("-".repeat(25));
        System.out.println("Matches students <= 50% done and takes the 'Complex Systems' Course");
        var matches = queryList.getMatches("percentageCOmplete", "50").getMatches("Course", "Complex Systems"); //make a list of the people whose input to this getMatches method in the LPAStudents class returns true

//      ordering the matches by the comparator we created for the LPAStudents Comparator, which sorts them by their percentage completed, from lowest to highest
        matches.sort(new LPAStudentComparator());
        printList(matches);

        System.out.println("Ordered");
        matches.sort(null); //this will just sort the list by our default Comparable's sort in the Student class, by ID
        printList(matches);

        System.out.println("-".repeat(25));
        Integer[] integerArray = {5, 3, 7, 15_000, 12_500, 6};
        String[] stringArray = {"Bean", "Jots","Cheese", "Books"};

        sortArray(stringArray);
        sortArray(integerArray);

    }

    public static void printList(List<?> students){

        for (var student : students){
            System.out.println(student);
        }
    }

    public static void sortArray(Object[] array){
//        Arrays.stream(array).sorted();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
