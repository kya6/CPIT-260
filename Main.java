// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner choice = new Scanner(System.in);
		int algorithm = 0;
		algorithm = input(choice);
		do{
			if (algorithm == 2) {
				RoundRobin test = new RoundRobin();
				test.Round();

			} else if (algorithm == -1) {
				System.exit(0);
			} else {
				System.out.println("Invalid number. Use -1 to Exit, 1 for FCFS, 2 for RR");
			}
			algorithm = input(choice);


		} while (algorithm != 1);


		// This is for getting the number of processors from the user
		System.out.print("Enter number of processes: ");
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOFProc = scanner.nextInt();
			//This is for getting the important details(Arrival time, burstz time) of process
			//creating arrays for storing arrival time and the burst time of a process
			int[] ProcessArrivalTime = new int[numberOFProc];
			int[] ProcessBurstTime = new int[numberOFProc];
			// to chose if we do increamnet the loop or not
			boolean inc;
			for (int i = 0; i < numberOFProc; ) {
				inc = true;
				System.out.print("Enter the arrival time of the process: ");
				String pat = scanner.next();
				if (pat.matches(".*\\d.*")) {
					ProcessArrivalTime[i] = Integer.parseInt(pat);
					System.out.println();
					System.out.print("Enter the CPU brust  of the process: ");
					String pbt = scanner.next();
					if (pbt.matches(".*\\d.*")) {
						ProcessBurstTime[i] = Integer.parseInt(pbt);
						System.out.println();
					} else {
						System.out.println("Enter a number please!!");
						inc = false;
					}
				} else {
					System.out.println("Enter a number please!!");
					inc = false;
				}
				if (inc) i++;
			}
			//scheduling the processes according to the FCFS algorithm
			ProcessSchedular processSchedular = new FirstComeFirstServe();

			//calculating the turn arround time
			int[] turnAroundTime = processSchedular.calculateTurnAroundTime(ProcessBurstTime, ProcessArrivalTime);

			//calculating the response time
			int[] responceTime = processSchedular.calculateResponseTime(ProcessBurstTime, ProcessArrivalTime);

			//calculating the waiting time
			int[] waitingTime = processSchedular.calculateWaitingTime(ProcessBurstTime, ProcessArrivalTime);

			//calculating the average turn arround time
			double avgTurnAroundTime = processSchedular.calculateAvgTurnAroundTime(turnAroundTime);

			//calculating the average waiting time
			double avgWaitingTime = processSchedular.calculateAvgWaitingTime(waitingTime);

			//This is the output process of this program

			System.out.println("Process     |Turnaround time     |Response time     |Waiting time");

			for (int i = 0; i < numberOFProc; i++) {
				int ta = turnAroundTime[i];
				int rt = responceTime[i];
				int wt = waitingTime[i];

				System.out.println((i + 1) + "\t\t\t\t" + ta + "\t\t\t\t\t" + rt + "\t\t\t\t\t" + wt);

			}
			System.out.println("Average turnaround time: " + Math.round(avgTurnAroundTime) + "ms");
			System.out.println("Average waiting time: " + Math.round(avgWaitingTime) + "ms");
		}
	}

	public static int input(Scanner choice) {
		boolean stop = false;
    String sample;
    System.out.print("Enter the Algorithm you want to use: ");
    do {
        sample = choice.next();
        if (sample.matches("\\d+")) {  // Check if the input is a valid integer
            stop = true;
        } else {
            System.out.println("Please Enter an Integer Number!");
            stop = false;
        }
    } while (!stop);
    return Integer.parseInt(sample);
}
}