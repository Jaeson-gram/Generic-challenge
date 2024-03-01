package com.Relearn;

import java.util.Comparator;

public class LPAStudents extends Student{
    private double percentComplete;

    public LPAStudents() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
//        return super.toString();
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentageComplete")){
            return percentComplete <= Integer.parseInt(value); //return true if percentageComplete...
        }

        return super.matchFieldValue(fieldName, value);
    }
}

class LPAStudentComparator implements Comparator<LPAStudents>{

    @Override
    public int compare(LPAStudents student1, LPAStudents student2) {
//        return 0;
        return (int) (student1.getPercentComplete() - student2.getPercentComplete()); //get the students by percentage
    }
}
