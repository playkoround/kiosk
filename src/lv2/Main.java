package lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // MenuItem 호출 생성 ??  menuItem > 인스턴스 인스턴스화한다
        MenuItem syBurger = new MenuItem("Sy Burger", 7900, "100% Angus Beef flame-grilled topped with fresh Rocket");
        MenuItem smokedBurger = new MenuItem("Smoked Burger", 8900, "Flamed-grilled beef patty topped with smoked bacon");
        MenuItem cheeseBurger = new MenuItem("Cheese Burger", 6900, "Flamed-grilled beef patty topped with melted cheese and tomato");
        MenuItem hamburger = new MenuItem("Hamburger", 6900, "Two flamed-grilled beef patties with lettuce");

        // List 활용위해 호출 생성 ?? //리스트 인터페이스 , arraylist가 list의 구현체임
        List<MenuItem>menuItems = new ArrayList<>();
        menuItems.add(syBurger);
        menuItems.add(smokedBurger);
        menuItems.add(cheeseBurger);
        menuItems.add(hamburger);

        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);

        // 환영 인사 및 메뉴 안내
        System.out.println("Welcome to Sy Burger! There is our menu below: ");
        // for 반복문으로 메뉴 출력
        for(int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getName() + " W " + menuItems.get(i).getPrice() + "\n" + menuItems.get(i).getDescription() + "\n");
        }
        System.out.println("0. Exit");


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
