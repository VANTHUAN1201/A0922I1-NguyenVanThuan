package stack_queue.demerging;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestDemergingQueue {
    public static void main(String[] args) {
        List<Demerging>demergings=new ArrayList<>();
        Queue<Demerging>nu=new LinkedList<>();
        Queue<Demerging>nam=new LinkedList<>();
        demergings.add(new Demerging("Thuan",true,"12/01/2001"));
        demergings.add(new Demerging("Nam",true,"12/01/2001"));
        demergings.add(new Demerging("Tuấn",true,"12/01/2001"));
        demergings.add(new Demerging("Nhi",false,"12/01/2001"));
        demergings.add(new Demerging("Lan",false,"12/01/2001"));
        demergings.add(new Demerging("Huế",false,"12/01/2001"));
        demergings.add(new Demerging("Anh",true,"12/01/2001"));
        demergings.add(new Demerging("Huy",true,"12/01/2001"));
        for (Demerging demerging:demergings) {
            if (demerging.isGender()){
                nam.add(demerging);
            }else {
                nu.add(demerging);
            }
        }
        String outPut="";
        while (!nu.isEmpty()){
            outPut = outPut+nu.remove()+"\n";
        }
        while (!nam.isEmpty()){
            outPut  = outPut+nam.remove()+"\n";
        }
        System.out.println(outPut);
    }
}
