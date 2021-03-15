// Students.java

package selection;

public class Students {
    private Student[] students;
    private int size = 0;

    public Students(Student[] students) {
        this.students = students;
    }

    public Students() {
    }

    public Student getStudent(int index) {
        return students[index];
    }

    public void addStudent(Student student) {
        students[size] = student;
        size++;
    }

    public void setStudent(Student student, int index) {
        students[index] = student;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getSize() {
        return size;
    }

    public void swap(int a, int b) {
        Student temp = students[a];
        students[a] = students[b];
        students[b] = temp;
    }

    public Student[] sortByGrade() {
        // Selection Sort Implementation
        for (int i = 0; i < size - 1; i++) {
            int max = i;
            for (int j = i + 1; j < size; j++) {
                if (students[j].getFinalAvg() > students[max].getFinalAvg())
                    max = j;
            }
            swap(i, max);
        }
        return students;
    }

    public Student[] sortByName() {
        // Selection Sort Implementation
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (students[j].getName().compareToIgnoreCase(students[min].getName()) < 0)
                    min = j;
            }
            swap(i, min);
        }
        return students;
    }

    public int maxNamelen() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (students[i].getName().length() > max)
                max = students[i].getName().length();
        }
        if (max < 5)
            return 5;
        return max;
    }

    public String spaces(int max, int current) {
        String str = "";
        for (int i = 0; i < (max - current); i++) {
            str += " ";
        }
        return str;
    }

    public String print(boolean quarterAverages) {
        String str = "";
        int max = maxNamelen();
        str += "Name:" + spaces(max + 5, 5);
        for (int q = 0; q < 4 && quarterAverages; q++) {
            str += "Q" + (q + 1) + spaces(5, 2);
        }
        str += "EOY" + spaces(5, 3);
        str += "YOG" + "\n";

        for (int i = 0; i < size; i++) {
            str += students[i].getName() + spaces(max + 5, students[i].getName().length());
            for (int q = 0; q < 4 && quarterAverages; q++) {
                str += students[i].getQuarterAvgs()[q]
                        + spaces(5, (Integer.toString(students[i].getQuarterAvgs()[q])).length());
            }
            str += students[i].getFinalAvg() + spaces(5, (Integer.toString(students[i].getFinalAvg())).length());
            str += students[i].getYog() + "\n";
        }
        return str;
    }

}