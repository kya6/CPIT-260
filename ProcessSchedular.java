public interface ProcessSchedular {
    public abstract int[] calculateTurnAroundTime(int[] burstTime,int[] arrivalTime);
    public abstract int[] calculateResponseTime(int[] burstTime, int[] arrivalTime);
    public abstract int[] calculateWaitingTime(int[] burstTime, int[] arrivalTime);
    public abstract double calculateAvgTurnAroundTime(int[] turnAroundTime);
    public abstract double calculateAvgWaitingTime(int[] waitingTime);
}
