package org.example;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

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
        Scanner sc = new Scanner(System.in);
        System.out.println("몇명이서 플레이할건가요?");
        int n = sc.nextInt();
        ArrayList<String>[] player_card = new ArrayList[n];

        System.out.println("사용자 이름을 입력해주세요.");
        for(int i = 0; i < n; i=i+1) {
            System.out.println((i+1) + "번째 유저 : ");
            String s = sc.next();
            map.put(i, s);
        }

        // 순서대로 카드 배부 (2중 배열로 저장)
        for(int i = 0; i < map.size(); i=i+1) {
            String cardGet = list.get(0);
            list.remove(0);
            player_card[i].add(cardGet);
            cardGet = list.get(0);
            list.remove(0);
            player_card[i].add(cardGet);
        }

        // 현재 가지고있는 카드 출력
        for(int i = 0; i < n; i= i+1) {
            System.out.print(map.get(i) + "가 보유한 카드");
            for(int j = 0; j < 2; j = j+1) {
                System.out.println(player_card[i].get(j));
            }
        }

    }
}