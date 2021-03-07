// StatsREport.java

package selection;

import java.util.ArrayList;

public class StatsReport {
    private int[] list;

    public StatsReport(int[] list) {
        this.list = list;
    }

    public double mean() {
        double mean = 0;
        for (int i = 0; i < list.length; i++) {
            mean += list[i];
        }
        return mean / (double) list.length;
    }

    public double median() {
        if (list.length % 2 != 0)
            return list[list.length / 2];
        else
            return (double) (list[list.length / 2] + list[(list.length / 2) - 1]) / 2;
    }

    public ArrayList<Integer> modes() {
        // Returns ArrayList with all modes, if there are no modes (max freq = 1),
        // returns null
        int last = list[0];
        int freq = 1;
        int currentFreq = 1;
        ArrayList<Integer> modes = new ArrayList<Integer>();
        modes.add(last);

        for (int i = 1; i < list.length; i++) {
            if (list[i] == last)
                currentFreq++;
            else {
                last = list[i];
                currentFreq = 1;
            }
            if (currentFreq > freq) {
                modes.clear();
                modes.add(list[i]);
                freq = currentFreq;
            } else if (currentFreq == freq)
                modes.add(list[i]);
        }
        if (freq == 1)
            return null;
        return modes;
    }

    public double std() {
        double std = 0;
        double mean = this.mean();
        for (int num : list) {
            std += Math.pow((num - mean), 2);
        }
        return Math.pow(std /= (list.length), 0.5);
    }

    public String generate() {
        String modes = "" + modes();
        if (modes.equals("null"))
            modes = "No Modes";

        String summary = "";
        summary += "Mean: " + mean();
        summary += "\nMedian: " + median();
        summary += "\nMode(s): " + modes;
        summary += "\nStandard Deviation: " + std();
        return summary;
    }

}