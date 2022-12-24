package oop;

import java.util.Scanner;

class Watch{
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    Watch(){
        this.startTime=System.currentTimeMillis();
    }
    void start(){
        long a=System.currentTimeMillis();
        this.setStartTime(a);
    }
    void stop(){
        long b=System.currentTimeMillis();
        this.setEndTime(b);
    }
    long getElapsedTime(){
        long dif=this.getEndTime()-this.getStartTime();
        return dif;
    }
}
public class StopWatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Watch test=new Watch();
        test.start();
        try {
            Thread.sleep(10*60*10);
        }catch (InterruptedException d) {
            throw new RuntimeException(d);
        }
        test.stop();
        System.out.println("The Elapsed time is: "+ test.getElapsedTime()+" milisec");
    }
}
