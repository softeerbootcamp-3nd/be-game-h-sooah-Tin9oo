package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        String[] mark = {"Diamond", "Spade", "Heart", "Clover"};
        String[] straight = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        List<String> list = new ArrayList<>();

        for(int i = 0; i < 1; ++i) {
            for(String m: mark) {
                for(String s: straight) {
                    list.add(m+" "+s);
//                    System.out.println(m+" "+s);
                }
            }
        }

        Collections.shuffle(list);

//        for(String l: list) {
//            System.out.println(l);
//        }

        Map<Integer, String> map = new HashMap<>();

        // 플레이어 입력 (명수, 이름)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("몇명이서 플레이할건가요?");
        int n = Integer.parseInt(reader.readLine());
        ArrayList<String>[] player_card = new ArrayList[n];

        System.out.println("사용자 이름을 입력해주세요.");
        for(int i = 0; i < n; i=i+1) {
            System.out.println((i+1) + "번째 유저 : ");
            String s = reader.readLine();
            map.put(i, s);
            player_card[i] = new ArrayList<>();
        }

        // 순서대로 카드 배부 (2중 배열로 저장)
        for(int i = 0; i < map.size(); i++) {
            String cardGet = list.get(0);
            list.remove(0);
            player_card[i].add(cardGet);
            cardGet = list.get(0);
            list.remove(0);
            player_card[i].add(cardGet);
        }

        // 현재 가지고있는 카드 출력
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(map.get(i) + "가 보유한 카드  ");
            for(int j = 0; j < 2; j++) {
                System.out.print(player_card[i].get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        // natural인지 판단
        boolean flag_natural = false;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < 2; j++) {
                String tmp = player_card[i].get(j);
                String tmp2 = tmp.substring(tmp.length()-1, tmp.length());
                if(tmp2.equals("K") || tmp2.equals("Q") || tmp2.equals("J")) {
                    continue;
                }
                if(tmp2.equals("A")) {
                    sum++;
                    continue;
                }
                sum += Integer.parseInt(tmp2);
            }

            if((sum%10) <= 7) {
                flag_natural = true;
                String cardGet = list.get(0);
                list.remove(0);
                player_card[i].add(cardGet);
            }
        }

        if(flag_natural) {
            System.out.printf("Natural입니다. 카드를 추가로 받으려면 키를 입력하세요.");
            reader.readLine();
        }

        // 현재 가지고있는 카드 출력
        for(int i = 0; i < n; i++) {
            System.out.print(map.get(i) + "가 보유한 카드  ");
            for(int j = 0; j < player_card[i].size(); j++) {
                System.out.print(player_card[i].get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 최종 합
        Map<String, Integer> rank = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < player_card[i].size(); j++) {
                String tmp = player_card[i].get(j);
                String tmp2 = tmp.substring(tmp.length()-1, tmp.length());
                if(tmp2.equals("K") || tmp2.equals("Q") || tmp2.equals("J")) {
                    continue;
                }
                if(tmp2.equals("A")) {
                    sum++;
                    continue;
                }
                sum += Integer.parseInt(tmp2);
            }

            rank.put(map.get(i), sum%10);
        }

        List<String> keySet = new ArrayList<>(rank.keySet());
        keySet.sort((o1, o2) -> rank.get(o2).compareTo(rank.get(o1)));

        for(String key: keySet) {
            System.out.println(key + " " + rank.get(key));
        }

    }
}