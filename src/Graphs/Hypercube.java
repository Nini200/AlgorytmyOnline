package Graphs;

import java.util.HashMap;
import java.util.*;

public class Hypercube implements IGraph{

    public static HashMap<Integer, int[]> binaryMapping = new HashMap<>();

    public Hypercube(){
        binaryMapping.put(0, new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        binaryMapping.put(1, new int[]{0, 0, 0, 0, 0, 0, 0, 1});
        binaryMapping.put(2, new int[]{0, 0, 0, 0, 0, 0, 1, 0});
        binaryMapping.put(3, new int[]{0, 0, 0, 0, 0, 0, 1, 1});
        binaryMapping.put(4, new int[]{0, 0, 0, 0, 0, 1, 0, 0});
        binaryMapping.put(5, new int[]{0, 0, 0, 0, 0, 1, 0, 1});
        binaryMapping.put(6, new int[]{0, 0, 0, 0, 0, 1, 1, 0});
        binaryMapping.put(7, new int[]{0, 0, 0, 0, 0, 1, 1, 1});
        binaryMapping.put(8, new int[]{0, 0, 0, 0, 1, 0, 0, 0});
        binaryMapping.put(9, new int[]{0, 0, 0, 0, 1, 0, 0, 1});
        binaryMapping.put(10, new int[]{0, 0, 0, 0, 1, 0, 1, 0});
        binaryMapping.put(11, new int[]{0, 0, 0, 0, 1, 0, 1, 1});
        binaryMapping.put(12, new int[]{0, 0, 0, 0, 1, 1, 0, 0});
        binaryMapping.put(13, new int[]{0, 0, 0, 0, 1, 1, 0, 1});
        binaryMapping.put(14, new int[]{0, 0, 0, 0, 1, 1, 1, 0});
        binaryMapping.put(15, new int[]{0, 0, 0, 0, 1, 1, 1, 1});
        binaryMapping.put(16, new int[]{0, 0, 0, 1, 0, 0, 0, 0});
        binaryMapping.put(17, new int[]{0, 0, 0, 1, 0, 0, 0, 1});
        binaryMapping.put(18, new int[]{0, 0, 0, 1, 0, 0, 1, 0});
        binaryMapping.put(19, new int[]{0, 0, 0, 1, 0, 0, 1, 1});
        binaryMapping.put(20, new int[]{0, 0, 0, 1, 0, 1, 0, 0});
        binaryMapping.put(21, new int[]{0, 0, 0, 1, 0, 1, 0, 1});
        binaryMapping.put(22, new int[]{0, 0, 0, 1, 0, 1, 1, 0});
        binaryMapping.put(23, new int[]{0, 0, 0, 1, 0, 1, 1, 1});
        binaryMapping.put(24, new int[]{0, 0, 0, 1, 1, 0, 0, 0});
        binaryMapping.put(25, new int[]{0, 0, 0, 1, 1, 0, 0, 1});
        binaryMapping.put(26, new int[]{0, 0, 0, 1, 1, 0, 1, 0});
        binaryMapping.put(27, new int[]{0, 0, 0, 1, 1, 0, 1, 1});
        binaryMapping.put(28, new int[]{0, 0, 0, 1, 1, 1, 0, 0});
        binaryMapping.put(29, new int[]{0, 0, 0, 1, 1, 1, 0, 1});
        binaryMapping.put(30, new int[]{0, 0, 0, 1, 1, 1, 1, 0});
        binaryMapping.put(31, new int[]{0, 0, 0, 1, 1, 1, 1, 1});
        binaryMapping.put(32, new int[]{0, 0, 1, 0, 0, 0, 0, 0});
        binaryMapping.put(33, new int[]{0, 0, 1, 0, 0, 0, 0, 1});
        binaryMapping.put(34, new int[]{0, 0, 1, 0, 0, 0, 1, 0});
        binaryMapping.put(35, new int[]{0, 0, 1, 0, 0, 0, 1, 1});
        binaryMapping.put(36, new int[]{0, 0, 1, 0, 0, 1, 0, 0});
        binaryMapping.put(37, new int[]{0, 0, 1, 0, 0, 1, 0, 1});
        binaryMapping.put(38, new int[]{0, 0, 1, 0, 0, 1, 1, 0});
        binaryMapping.put(39, new int[]{0, 0, 1, 0, 0, 1, 1, 1});
        binaryMapping.put(40, new int[]{0, 0, 1, 0, 1, 0, 0, 0});
        binaryMapping.put(41, new int[]{0, 0, 1, 0, 1, 0, 0, 1});
        binaryMapping.put(42, new int[]{0, 0, 1, 0, 1, 0, 1, 0});
        binaryMapping.put(43, new int[]{0, 0, 1, 0, 1, 0, 1, 1});
        binaryMapping.put(44, new int[]{0, 0, 1, 0, 1, 1, 0, 0});
        binaryMapping.put(45, new int[]{0, 0, 1, 0, 1, 1, 0, 1});
        binaryMapping.put(46, new int[]{0, 0, 1, 0, 1, 1, 1, 0});
        binaryMapping.put(47, new int[]{0, 0, 1, 0, 1, 1, 1, 1});
        binaryMapping.put(48, new int[]{0, 0, 1, 1, 0, 0, 0, 0});
        binaryMapping.put(49, new int[]{0, 0, 1, 1, 0, 0, 0, 1});
        binaryMapping.put(50, new int[]{0, 0, 1, 1, 0, 0, 1, 0});
        binaryMapping.put(51, new int[]{0, 0, 1, 1, 0, 0, 1, 1});
        binaryMapping.put(52, new int[]{0, 0, 1, 1, 0, 1, 0, 0});
        binaryMapping.put(53, new int[]{0, 0, 1, 1, 0, 1, 0, 1});
        binaryMapping.put(54, new int[]{0, 0, 1, 1, 0, 1, 1, 0});
        binaryMapping.put(55, new int[]{0, 0, 1, 1, 0, 1, 1, 1});
        binaryMapping.put(56, new int[]{0, 0, 1, 1, 1, 0, 0, 0});
        binaryMapping.put(57, new int[]{0, 0, 1, 1, 1, 0, 0, 1});
        binaryMapping.put(58, new int[]{0, 0, 1, 1, 1, 0, 1, 0});
        binaryMapping.put(59, new int[]{0, 0, 1, 1, 1, 0, 1, 1});
        binaryMapping.put(60, new int[]{0, 0, 1, 1, 1, 1, 0, 0});
        binaryMapping.put(61, new int[]{0, 0, 1, 1, 1, 1, 0, 1});
        binaryMapping.put(62, new int[]{0, 0, 1, 1, 1, 1, 1, 0});
        binaryMapping.put(63, new int[]{0, 0, 1, 1, 1, 1, 1, 1});
    }

    public int distance(int v1, int v2){
        int[] array1 = binaryMapping.get(v1);
        if(v2==64){
            System.out.println("Fuck it all");
        }
        int[] array2 = binaryMapping.get(v2);
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }

        int differenceCount = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                differenceCount++;
            }
        }

        return differenceCount;
    }

    @Override
    public String getName() {
        return "Hypercube";
    }


}



