package jianZhiOffer.sumIsSdeArray;

import java.util.ArrayList;
import java.util.Collections;

/***
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        int x = sum / 2 + 1;
        for (int i = 1; i <= x; i++) {
            double temp = sum * 2 + Math.pow((i - 0.5), 2);
            int end = (int) (Math.sqrt(temp) - 0.5);
            if (Math.pow(end + 0.5, 2) == temp) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i; j <= end; j++) {
                    list.add(j);
                }
                arrays.add(list);
            }
        }
        Collections.sort(arrays, (a, b) -> b.size() - a.size());
        return arrays;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> arrays = sol.FindContinuousSequence(3);
        for (int i = 0; i < arrays.size(); i++) {
            ArrayList<Integer> list = arrays.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.printf(" " + list.get(j));
            }
            System.out.println();
        }
    }
}
