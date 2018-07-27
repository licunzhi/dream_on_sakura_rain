package com.meimei;

/**
 * @author licunzhi
 * @desc 冒泡排序算法
 * @date 2018-07-27
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrary = new int[] {7, 9, 45, 4, 1, 12, 32, 121}; // 修改参数来源

        for (int i = 0; i < arrary.length - 1; i++) {
            for (int j = 0; j < arrary.length - i - 1; j++) {//-1为了防止溢出
                if (arrary[j] > arrary[j + 1]) {
                    int temp = arrary[j];

                    arrary[j] = arrary[j + 1];

                    arrary[j + 1] = temp;
                }
            }
        }

        //打印新的排序之后信息
        for (int i : arrary) {
            System.out.println(i);
        }
    }
}
