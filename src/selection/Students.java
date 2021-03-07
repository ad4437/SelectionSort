// Students.java

package selection;

public class Students {
    private Student[] students;

    public Students(Student[] students) {
        this.students = students;
    }
    
    public Students() {
    }

    public Student getStudent(int index) {
        return students[index];
    }
    
    public void setStudent(Student student, int index) {
    	students[index] = student;
    }
    
    public Student[] getStudents() {
    	return students;
    }

    public void swap(int a, int b) {
        Student temp = students[a];
        students[a] = students[b];
        students[b] = temp;
    }

    public Student[] sortByGrade() {
        // Selection Sort Implementation
        for (int i = 0; i < students.length; i++) {
            int split = 0;
            int max = 0;
            for (int j = split; j < students.length; j++) {
                if (students[j].getFinalAvg() > students[max].getFinalAvg())
                	max = j;
            }
            swap(split, max);
            split++;
        }
        return students;
    }

    public Student[] sortByName() {
        // Selection Sort Implementation
        for (int i = 0; i < students.length; i++) {
            int split = 0;
            int min = 0;
            for (int j = split; j < students.length; j++) {
                if (students[j].getName().compareToIgnoreCase(students[min].getName()) < 0)
                    min = j;
            }
            swap(split, min);
            split++;
        }
        return students;
    }
    
    public int maxNamelen() {
    	int max = 0;
    	for (Student s : students) {
    		if (s.getName().length() > max) max = s.getName().length();
    	}
    	if (max < 5) return 5;
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
		str += "Name:" + spaces(max+5, 5);
		for (int q = 0; q < 4 && quarterAverages; q++) {
			str += "Q" + (q+1) + spaces(5, 2);
		}
		str += "EOY" + spaces(5, 3);
		str += "YOG" + "\n";
    	
    	for (int i = 0; i < students.length; i++) {
    		str += students[i].getName() + spaces(max+5, students[i].getName().length());
    		for (int q = 0; q < 4 && quarterAverages; q++) {
    			str += students[i].getQuarterAvgs()[q] + spaces(5, (Integer.toString(students[i].getQuarterAvgs()[q])).length());
    		}
    		str += students[i].getFinalAvg() + spaces(5, (Integer.toString(students[i].getFinalAvg())).length());
    		str += students[i].getYog() + "\n";
    	}
    	return str;
    }

}