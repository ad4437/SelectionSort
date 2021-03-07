// App.java

package selection;

import java.util.Scanner;

import javax.management.InvalidAttributeValueException;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        boolean inputFinalAvg = true;
        boolean sortByGrade = true;
        boolean statsReport = true;
        String repeat = "yes";
        int count = 0;
        Students students;
        
        repeatLoop: while (repeat.equals("yes")) {
            System.out.print("Input Quarter or Final Averages? (quarter or final): ");
            if (in.nextLine().toLowerCase().equals("quarter"))
                inputFinalAvg = false;

            System.out.print("Sort by Name (a-z) or Grade (100-0)? (name or grade): ");
            if (in.nextLine().toLowerCase().equals("name"))
                sortByGrade = false;
            
            System.out.print("Print Stats Report? (yes or no): ");
            if (in.nextLine().toLowerCase().equals("no"))
            	statsReport = false;

            try {
                System.out.print("Number of Students: ");
                count = in.nextInt();
                if (count > 15) {
                	System.out.println("Number of students cannot exceed 15");
                	in.nextLine();
    	            System.out.print("Repeat? (yes or no): ");
    	            repeat = in.nextLine();
    	            System.out.println();
    	            continue repeatLoop;
                }
                students = new Students(new Student[count]);
                in.nextLine();

    			for (int i = 0; i < count; i++) {
    				try {
    					students.setStudent(new Student(), i);
    					
    					System.out.print("Name: ");
    					String name = in.nextLine();
    					students.getStudent(i).setName(name);		
    					
    					System.out.print("Year of Graduation: ");
    					students.getStudent(i).setYog(in.nextInt());
    					in.nextLine();
    					
    					if (inputFinalAvg) {
    						System.out.print("Final Average: ");
    						students.getStudent(i).setFinalAvg(in.nextInt());
    						in.nextLine();
    					} else {
    						System.out.print("Quarter Averages (space seperated): ");
    						String input = in.nextLine() + " ";
    						int[] qavgs = new int[4];
    						for (int j = 0; j < 4; j++) {
    							qavgs[j] = Integer.parseInt(input.substring(0, input.indexOf(" ")));
    							input = input.substring(input.indexOf(" ")+1);
    						}
    						students.getStudent(i).setQuarterAvgs(qavgs);
    		            }
    	            } catch (InvalidAttributeValueException e) {
    	            	in.nextLine();
    		            System.out.println("Invalid Grade");
    		            System.out.print("Repeat? (yes or no): ");
    		            repeat = in.nextLine();
    		            System.out.println();
    		            continue repeatLoop; // java label
    	            }
                }
            } catch (Exception e) {
            	in.nextLine();
            	System.out.println("Invalid Input");
	            System.out.print("Repeat? (yes or no): ");
	            repeat = in.nextLine();
	            System.out.println();
	            continue repeatLoop; // java label
            }


        	if (sortByGrade) {
        		students.sortByGrade();
        	} else {
        		students.sortByName();
        	}
            	
        	System.out.println();
        	System.out.println(students.print(!inputFinalAvg));
        	
        	if (statsReport) {
        		for (int q = 0; q < 4 && !inputFinalAvg; q++) {
        			int[] quarterGrades = new int[count];
        			for (int i = 0; i < count; i++) {
        				quarterGrades[i] = students.getStudent(i).getQuarterAvgs()[q];
        			}
        			StatsReport report = new StatsReport(quarterGrades);
        			System.out.println("Q" + (q+1) + ":\n" + report.generate());
        			System.out.println();
        		}
    			int[] finalGrades = new int[count];
    			for (int i = 0; i < count; i++) {
    				finalGrades[i] = students.getStudent(i).getFinalAvg();
    			}
    			StatsReport report = new StatsReport(finalGrades);
    			System.out.println("Final Averages:" + "\n" + report.generate());
    			System.out.println();
        	}
        	
            System.out.print("Repeat? (yes or no): ");
            repeat = in.nextLine();
            System.out.println();
        }
        in.close();
    }
}