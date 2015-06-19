package ch121_140;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/7 0007.
 */
public class Ch134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null|| gas.length==0||cost.length==0||gas.length!=cost.length)
            return -1;
        int len = gas.length-1;
        int index = len;
        int gasBox = gas[len]-cost[len];
        List<Integer> debyList = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(gasBox<0){
                debyList.add(gasBox);
                gasBox=0;
                index = i;
            }
            gasBox += gas[i]-cost[i];
        }
        for(Integer deby:debyList){
            gasBox += deby;
            if(gasBox<0){
                return -1;
            }

        }
        if(gasBox<0)
            return -1;
        return index;
    }

    public static void main(String[] args) {
        int[] gas = {5};
        int[] cost = {4};
        System.out.println(new Ch134().canCompleteCircuit(gas,cost));
    }
}
