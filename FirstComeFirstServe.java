public class FirstComeFirstServe implements ProcessSchedular {
    @Override
    public int[] calculateTurnAroundTime(int[] burstTime,int[] arrivalTime) {
        //Once this method is called by the CPU, the turn arround times will be generated
        //In FCFS the turn around time is the sum of waiting time + I/O waiting time + burst time
        int length = burstTime.length;
        int[] waitingTime = calculateWaitingTime(burstTime,arrivalTime);
        int[] turnArroundTime = new int[length];


        turnArroundTime[0] = burstTime[0];

        for(int i = 1; i<length; i++){
            turnArroundTime[i] = burstTime[i]+waitingTime[i];
        }
        return turnArroundTime;

    }

    @Override
    public int[] calculateResponseTime(int[] burstTime,int[] arrivalTime) {
        // this method is responsible for calculating response time
        // the time that each process takes to generate its first out put since the zero
        int length = burstTime.length;
        int[] responseTime = new int[length];

        responseTime[0] = arrivalTime[0];

        for(int i = 1; i<length; i++){
            responseTime[i] = responseTime[i-1]+burstTime[i-1];
        }
        return responseTime;
    }


    @Override
    public int[] calculateWaitingTime(int[] burstTime, int[] arrivalTime) {
        /*this method calculates the waiting time of a process. Basically we defined that the waiting time
        of the first process is almost zero
         */

        int length = burstTime.length;
        int[] waitingtTime = new int[length];
        //waitingtTime[0] = 0;

        int [] responseTime = calculateResponseTime(burstTime,arrivalTime);
        for( int i = 0; i<length; i++){
            waitingtTime[i] = responseTime[i] - arrivalTime[i];
        }
        return waitingtTime;
    }



    @Override
    public double calculateAvgTurnAroundTime(int[] turnAroundTime) {
        //this method is created for calculating the average turn around time
        double totalTurnAroundTime = 0;
        double length = turnAroundTime.length;
        double avgTurnAroundTime ;

        for(int i = 0; i<length; i++){
            totalTurnAroundTime += turnAroundTime[i];
        }

        avgTurnAroundTime = totalTurnAroundTime/length;

        return avgTurnAroundTime;
    }


    @Override
    public double calculateAvgWaitingTime(int[] waitingTime) {
        //this method is created for calculating the average turn around time
        double totolWaitingTime = 0;
        double length = waitingTime.length;
        double avgWaitingTime;

        for (int i = 0; i < length; i++) {
            totolWaitingTime += waitingTime[i];
        }

        avgWaitingTime = totolWaitingTime / length;

        return avgWaitingTime;
    }
}
