package Ch141_160;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/9 0009.
 */
public class LRUCache {
    Map<Integer,Integer> map = new HashMap<>();
    int[] keyArr ;
    int size = 0;
    int capacity;
    int lastIndex = 0;
    public LRUCache(int capacity) {
        keyArr = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if(value==null)
            return -1;
        else{
            update(key);
            return value;
        }
    }

    public void set(int key, int value) {

        if(map.get(key)!=null){
            update(key);
        }else if(size<capacity){
            keyArr[size++] = key;
        }else{
            map.remove(keyArr[0]);
            keyArr[lastIndex++] = key;
            if(lastIndex==2048)
                lastIndex=0;
        }
        map.put(key,value);
    }

    public void update(int key){
        int index = 0;
        for(;index<size;index++){
            if(keyArr[index] == key)
                break;
        }
        if(lastIndex==0)
            System.arraycopy(keyArr,index+1,keyArr,index,size-index-1);
        else{
            if(index==lastIndex-1)
                return;
            int[] keyArrCopy = new int[keyArr.length];
            if(index<lastIndex){
                System.arraycopy(keyArr,lastIndex,keyArrCopy,0,size-lastIndex+1);
                System.arraycopy(keyArr,0,keyArrCopy,size-lastIndex+1,index);
                System.arraycopy(keyArr,index+1,keyArrCopy,size-lastIndex+1+index,lastIndex-index);
                keyArrCopy[size-1] = key;
            }else{
                System.arraycopy(keyArr,lastIndex,keyArrCopy,0,index -lastIndex);
                System.arraycopy(keyArr,index+1,keyArrCopy,index -lastIndex,size-index-1);
                System.arraycopy(keyArr,0,keyArrCopy,index -lastIndex+(size-index-1),lastIndex+1);
                keyArrCopy[size-1] = key;
            }
            keyArr = keyArrCopy;
            lastIndex = 0;
        }
        keyArr[size-1] = key;
    }

    public static void  test(){
        long beginTime = System.currentTimeMillis();
        LRUCache cache = new LRUCache(2048);
        for(int i=1;i<500000;i++){
            cache.set(i,i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//        int key =1;
//        int index = 0;
//        for(;index<arr.length;index++){
//            if(arr[index] == key)
//                break;
//        }
//        System.arraycopy(arr,index+1,arr,index,arr.length-index-1);
//        arr[arr.length-1] = key;
//        System.out.println();


        //LRUCache cache = new LRUCache(4);
//        for(int i=0;i<4;i++){
//            cache.set(i,i);
//        }
//        cache.set(5,5);
//        System.out.println(cache.get(1));
//        cache.set(6, 6);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        test();

        LRUCache cache = new LRUCache(10);
        for(int i=0;i<15;i++){
            cache.set(i-4,i-4);
        }
        for(int i=0;i<6;i++){
            cache.get(i+1);
        }
        System.out.println();
    }
}
