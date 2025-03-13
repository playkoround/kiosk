package lv4;

import lv3.MenuItem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
        // start 메서드
        // 메서드 5요소 접근제어자 반환타입 메서드이름 (매개변수) {바디}
        public void start(){
            // 스캐너 변수를 선언해서, 스캐너 객체를 만들어 할당
            Scanner scanner = new Scanner(System.in);

            // 환영 인사 및 메뉴 안내
            System.out.println("Welcome to Sy Burger! There is our menu below: ");
            // for 반복문으로 메뉴 출력
            for(int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).getName() + " W " + menuItems.get(i).getPrice() + "\n" + menuItems.get(i).getDescription() + "\n");
            }
            System.out.println("0. Exit");

            // 유효한 입력값 체크하는 불리안
            boolean isValidInt = false;
            while (!isValidInt) {
                // 유효한 입력값이 안들어오는 예외 처리
                try {
                    System.out.println("Please type the number to order your food: ");

                    // 입력값 받기
                    int order = scanner.nextInt();

                    // 입력값이 0부터 메뉴종류수까지인지 확인
                    if (order >= 0 && order <= menuItems.size()) {
                        // 올바른 숫자이면 반복 종료
                        isValidInt = true;
                    } else {
                        System.out.println("Please enter a valid number");
                        continue; //continue로 밑에 스위치까지 안 읽고, 바로 입력값 받게 만들기
                    }

                    // 주문 내역 안내
                    System.out.print("You ordered: ");
                    switch (order) {
                        case 1:
                            System.out.print(menuItems.get(0).getName()+ " W " + menuItems.get(0).getPrice());
                            break;
                        case 2:
                            System.out.print(menuItems.get(1).getName()+ " W " + menuItems.get(1).getPrice());
                            break;
                        case 3:
                            System.out.println(menuItems.get(2).getName()+ " W " + menuItems.get(2).getPrice());
                            break;
                        case 4:
                            System.out.println(menuItems.get(3).getName()+ " W " + menuItems.get(3).getPrice());
                            break;
                        case 0:
                            System.out.println("nothing");
                            break;
                    }
                } catch (InputMismatchException e) {
                    // 입력값이 숫자가 아닌 예외 처리
                    System.out.println("Please enter a number");
                    scanner.nextLine(); // 개행문자 > 버퍼에는 계속 입력값이 남아있음 > 그래서 nextLine이 엔터(컴퓨터 = \n)를 통해 없앤다.
                }
            }
        }
}
