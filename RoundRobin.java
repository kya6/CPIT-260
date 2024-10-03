import java.util.Scanner;
public class RoundRobin {
    public void Round()
    {
        int n = 0;
        int i, qt = 0, count = 0, temp, sq = 0;
        int[] bt, wt, tat, rem_bt, at;
        float awt = 0, atat = 0;
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rem_bt = new int[10];
        at = new int[10];
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of process (maximum 10) = ");
        boolean stop = false;
        do {
            String num = s.next();
            if (num.matches(".*\\d.*")) {
                n = Integer.parseInt(num);
                stop = true;
            } else {
                System.out.println("Please Enter A Number!!!!");
            }
        } while (!stop);

        System.out.print("Enter the arrival time of the process\n");
        for (i = 0; i < n; ) {
            System.out.print("P" + i + " = ");
            String num = s.next();
            if (num.matches(".*\\d.*")) {
                at[i] = Integer.parseInt(num);
                i++;
            } else {
                System.out.println("Please Enter A Number!!!!");
            }
        }

        System.out.print("Enter the burst time of the process\n");
        for (i = 0; i < n; ) {
            System.out.print("P" + i + " = ");
            String num = s.next();
            if (num.matches(".*\\d.*")) {
                bt[i] = Integer.parseInt(num);
                rem_bt[i] = bt[i];
                i++;
            } else {
                System.out.println("Please Enter A Number!!!!");
            }
        }

        System.out.print("Enter the quantum time: ");
        stop = false;
        do {
            String num = s.next();
            if (num.matches(".*\\d.*")) {
                qt = Integer.parseInt(num);
                stop = true;
            } else {
                System.out.println("Please Enter A Number!!!!");
            }
        } while (!stop);

        int time = 0;
        while (true) {
            boolean done = true;
            for (i = 0; i < n; i++) {
                if (rem_bt[i] > 0 && at[i] <= time) {
                    done = false;
                    if (rem_bt[i] > qt) {
                        time += qt;
                        rem_bt[i] -= qt;
                    } else {
                        time += rem_bt[i];
                        tat[i] = time - at[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done) break;
        }

        System.out.print("Process     |Turnaround time     |Response time     |Waiting time\n");
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt += wt[i];
            atat += tat[i];
            System.out.println((i + 1) + "\t\t\t\t" + tat[i] + "\t\t\t\t\t" + bt[i] + "\t\t\t\t\t" + wt[i]);
        }

        awt = awt / n;
        atat = atat / n;
        System.out.println("\nAverage waiting Time = " + awt + "\n");
        System.out.println("Average turnaround time = " + atat);
    }
}
