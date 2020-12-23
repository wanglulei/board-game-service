package com.dl.board.game.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wanglulei
 * @Date 2020/6/12  10:31
 **/
public class RandomNumUtil {

    public static int getNum(int min, int max) {
        if (max == min) {
            return max;
        }
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int getNum(int max) {

        return getNum(0, max);
    }


    public static int[] getNumArray(int min, int max, int total) {
        int arr[] = new int[total];// total 个数的数组
        for (int i = 0; i < total; i++) {
            //生产一个随机数
            int index = getNum(min, max);
            arr[i] = index;//把随机数赋值给下标为数组下标为i的值
            //（遍历数组中储存进去的值，i中有几个值则循环几次）
            for (int j = 0; j < i; j++) {
                //把储存在数组中的值j 和 随机出的值i 做比较
                if (arr[j] == arr[i]) {
                    i--; //数组的值下标-1，i的循环次数回到上次
                    break;
                }
            }
        }
        return arr;
    }

    public static List<Integer> getNums(int min, int max, int total) {
        List<Integer> ids = new ArrayList<>(total);

        for (int i = 0; i < total; i++) {
            //生产一个随机数
            int index = getNum(min, max);
            if (ids.contains(index)){
                i--;
            } else {
                ids.add(index);
            }
        }
        return ids;
    }

}
