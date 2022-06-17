package com.imooc.lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.imooc.utils.JsonUtils;

import springfox.documentation.spring.web.json.Json;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-04-27
 */
public class Solution {

    private static Map<Character, Character> map = new HashMap<>();
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k == 0 || input == null) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1)); // 默认是小根堆
        //
        for(int i=0; i<input.length; i++) {
            if(pq.size() < k) {
                pq.offer(input[i]);
                continue;
            }
            if(pq.peek() > input[i]) {
                pq.poll();
                pq.offer(input[i]);
            }
        }
        ArrayList<Integer> res = new ArrayList();

        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }


    public static void main(String[] args) {
        //String s = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        //StringBuffer s = new StringBuffer();
        //s.reverse()
        ////StringUtils.reverse()
        //String[] split = s.split(":", -1);
        //String[] split1 = s.split(":");
        //ArrayList<Integer> list = new ArrayList<>();
        //list.sort(Comparator.comparingInt());
        //
        //System.out.println(JsonUtils.objectToJson(split));
        //System.out.println(JsonUtils.objectToJson(split1));

        //int[] a = new int[12];
        //List<Integer> listS = Lists.
        //ArrayList<int[]> ints = Lists.newArrayList(a);
        //int[] clone = a.clone();

        System.out.println(Long.MAX_VALUE);
    }
}
