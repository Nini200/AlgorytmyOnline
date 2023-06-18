package Graphs;

import java.util.HashMap;

import static java.lang.Math.abs;

public class Torus implements IGraph{

    HashMap<Integer, int[]> base4Mapping = new HashMap<>();

    public Torus(){
        base4Mapping.put(0, new int[]{0, 0, 0, 0});
        base4Mapping.put(1, new int[]{0, 0, 0, 1});
        base4Mapping.put(2, new int[]{0, 0, 0, 2});
        base4Mapping.put(3, new int[]{0, 0, 0, 3});
        base4Mapping.put(4, new int[]{0, 0, 1, 0});
        base4Mapping.put(5, new int[]{0, 0, 1, 1});
        base4Mapping.put(6, new int[]{0, 0, 1, 2});
        base4Mapping.put(7, new int[]{0, 0, 1, 3});
        base4Mapping.put(8, new int[]{0, 0, 2, 0});
        base4Mapping.put(9, new int[]{0, 0, 2, 1});
        base4Mapping.put(10, new int[]{0, 0, 2, 2});
        base4Mapping.put(11, new int[]{0, 0, 2, 3});
        base4Mapping.put(12, new int[]{0, 0, 3, 0});
        base4Mapping.put(13, new int[]{0, 0, 3, 1});
        base4Mapping.put(14, new int[]{0, 0, 3, 2});
        base4Mapping.put(15, new int[]{0, 0, 3, 3});
        base4Mapping.put(16, new int[]{0, 1, 0, 0});
        base4Mapping.put(17, new int[]{0, 1, 0, 1});
        base4Mapping.put(18, new int[]{0, 1, 0, 2});
        base4Mapping.put(19, new int[]{0, 1, 0, 3});
        base4Mapping.put(20, new int[]{0, 1, 1, 0});
        base4Mapping.put(21, new int[]{0, 1, 1, 1});
        base4Mapping.put(22, new int[]{0, 1, 1, 2});
        base4Mapping.put(23, new int[]{0, 1, 1, 3});
        base4Mapping.put(24, new int[]{0, 1, 2, 0});
        base4Mapping.put(25, new int[]{0, 1, 2, 1});
        base4Mapping.put(26, new int[]{0, 1, 2, 2});
        base4Mapping.put(27, new int[]{0, 1, 2, 3});
        base4Mapping.put(28, new int[]{0, 1, 3, 0});
        base4Mapping.put(29, new int[]{0, 1, 3, 1});
        base4Mapping.put(30, new int[]{0, 1, 3, 2});
        base4Mapping.put(31, new int[]{0, 1, 3, 3});
        base4Mapping.put(32, new int[]{0, 2, 0, 0});
        base4Mapping.put(33, new int[]{0, 2, 0, 1});
        base4Mapping.put(34, new int[]{0, 2, 0, 2});
        base4Mapping.put(35, new int[]{0, 2, 0, 3});
        base4Mapping.put(36, new int[]{0, 2, 1, 0});
        base4Mapping.put(37, new int[]{0, 2, 1, 1});
        base4Mapping.put(38, new int[]{0, 2, 1, 2});
        base4Mapping.put(39, new int[]{0, 2, 1, 3});
        base4Mapping.put(40, new int[]{0, 2, 2, 0});
        base4Mapping.put(41, new int[]{0, 2, 2, 1});
        base4Mapping.put(42, new int[]{0, 2, 2, 2});
        base4Mapping.put(43, new int[]{0, 2, 2, 3});
        base4Mapping.put(44, new int[]{0, 2, 3, 0});
        base4Mapping.put(45, new int[]{0, 2, 3, 1});
        base4Mapping.put(46, new int[]{0, 2, 3, 2});
        base4Mapping.put(47, new int[]{0, 2, 3, 3});
        base4Mapping.put(48, new int[]{0, 3, 0, 0});
        base4Mapping.put(49, new int[]{0, 3, 0, 1});
        base4Mapping.put(50, new int[]{0, 3, 0, 2});
        base4Mapping.put(51, new int[]{0, 3, 0, 3});
        base4Mapping.put(52, new int[]{0, 3, 1, 0});
        base4Mapping.put(53, new int[]{0, 3, 1, 1});
        base4Mapping.put(54, new int[]{0, 3, 1, 2});
        base4Mapping.put(55, new int[]{0, 3, 1, 3});
        base4Mapping.put(56, new int[]{0, 3, 2, 0});
        base4Mapping.put(57, new int[]{0, 3, 2, 1});
        base4Mapping.put(58, new int[]{0, 3, 2, 2});
        base4Mapping.put(59, new int[]{0, 3, 2, 3});
        base4Mapping.put(60, new int[]{0, 3, 3, 0});
        base4Mapping.put(61, new int[]{0, 3, 3, 1});
        base4Mapping.put(62, new int[]{0, 3, 3, 2});
        base4Mapping.put(63, new int[]{0, 3, 3, 3});
    }

    @Override
    public int distance(int v1, int v2) {
        int[] array1 = base4Mapping.get(v1);
        int[] array2 = base4Mapping.get(v2);
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }

        int differenceCount = 0;
        for (int i = 0; i < array1.length; i++) {
            switch (abs(array1[i] - array2[i])) {
                case 1, 3 -> differenceCount += 1;
                case 2 -> differenceCount += 2;
            }

        }

        return differenceCount;
    }

    @Override
    public String getName() {
        return "Torus";
    }

}