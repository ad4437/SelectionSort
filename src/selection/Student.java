// Student.java

package selection;

import javax.management.InvalidAttributeValueException;

public class Student {
    private String name = "";
    private int yog = 0; // Year of Graduation
    private int finalAvg = -1;
    private int[] quarterAvgs = new int[4];

    public Student(String name, int yog, int finalAvg) throws InvalidAttributeValueException {
        this.name = name;
        this.yog = yog;
        setFinalAvg(finalAvg);
    }

    public Student(String name, int yog, int[] quarterAvgs) throws InvalidAttributeValueException {
        this.name = name;
        this.yog = yog;
        setQuarterAvgs(quarterAvgs);
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public int getYog() {
        return yog;
    }

    public int getFinalAvg() {
        return finalAvg;
    }

    public int[] getQuarterAvgs() {
        return quarterAvgs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYog(int yog) {
        this.yog = yog;
    }

    public void setFinalAvg(int finalAvg) throws InvalidAttributeValueException {
        if (finalAvg < 0 || finalAvg > 100)
            throw new InvalidAttributeValueException();
        this.finalAvg = finalAvg;
    }

    public void setQuarterAvgs(int[] quarterAvgs) throws InvalidAttributeValueException {
        for (int grade : quarterAvgs) {
            if (grade < 0 || grade > 100)
                throw new InvalidAttributeValueException();
        }
        this.quarterAvgs = quarterAvgs;
        this.finalAvg = (quarterAvgs[0] + quarterAvgs[1] + quarterAvgs[2] + quarterAvgs[3]) / 4;
    }

}
