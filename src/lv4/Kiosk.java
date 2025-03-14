package lv4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 스캐너 변수를 선언해서, 스캐너 객체를 만들어 할당
    Scanner scanner = new Scanner(System.in);

        //속성
        private List<Menu> menus;
        public Kiosk(List<Menu> menus) {
            this.menus = menus;
        }

        // 카테고리 보여주는 메서드
        public void viewMenuCategories() {
            System.out.println("categories: ");
            int i = 1;
            for (Menu menu : menus) {
                String category = menu.getCategory();
                System.out.println(i + ". " + category);
                i++;
            }
            System.out.println("0. Exit");
        }

        // 메뉴 보여주는 메서드
        public void viewMenus(Menu chosenMenu) {
            System.out.println("menus in " + chosenMenu.getCategory() + ": ");

            // MenuItem들을 모아둔 리스트 만들기
            List<MenuItem> items = chosenMenu.getMenuItems();
            for (int i = 0; i < items.size(); i++) {
                MenuItem item = items.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " - W " + item.getPrice());
                System.out.println(item.getDescription() + "\n");
            }
            System.out.println("0. Go back to Categories");
        }


        // 카테고리별 메뉴들을 보여주는 메서드 Fixed
        public <T> T getUserSelection(String prompt, List<T> options) {

            while (true) {
                try {
                    // 사용자에게 안내 메세지 출력
                    System.out.println(prompt);

                    // 입력값 받기
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리

                    if (choice == 0) {
                        return null; // 0 입력 시 뒤로 가기 or 종료
                    }

                    // 입력값 검증
                    if (choice >= 0 && choice <= options.size()) {
                        return options.get(choice - 1); // 1부터 시작하는 인덱스로 변환
                    } else {
                        System.out.println("Please enter a valid number.");
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a number.");
                    scanner.nextLine(); // 버퍼 비우기

                }
//                throw new Exception();
                // return options.get(choice); // return이 여기 위치하면, while문을 안탈경우 return이 없는 메서드라고 생각해서 오류가 남
            }
        }



        // start 메서드
        // 메서드 5요소 접근제어자 반환타입 메서드이름 (매개변수) {바디}
        public void start(){

            // 환영 인사
            System.out.println("Welcome to Sy Burger! \n");

            // 0 선택시 종료 및 이전으로 돌아가기 설정
            while (true) {
                // 카테고리 보여주기
                viewMenuCategories();
                // 카테고리 선택 및 그에 따른 안내
                Menu chosenMenu = getUserSelection("Please select a category: ", menus);

                if (chosenMenu == null) {
                    System.out.println("Exiting program...");
                    break; // 0 입력 시 프로그램 종료
                }

                while (true) {
                    // 메뉴 보여주기
                    // menu int x
                    viewMenus(chosenMenu);

                    // 메뉴 선택 및 그에 따른 안내
                    MenuItem chosenItem = getUserSelection("Please select a menu item:", chosenMenu.getMenuItems());
                    if (chosenItem == null) {
                        System.out.println("Returning to category selection...");
                        break; // 0 입력 시 카테고리 선택으로 돌아감
                    }
                    System.out.println("\nYou ordered: " + chosenItem.getName() + " - W " + chosenItem.getPrice());
                    // 종료 안내 문구
                    System.out.println("\nIf you want to finish your order, please type 0");
                }
            }



            /**
            // 메뉴 보여주기
             while~
            viewMenus();

            // 메뉴 선택 Scanner로 inputNumber 받아주고, 해당 메뉴를 가져온다

            // 햄버거(1), 이런 식으로 입력값도 저장하고 나눠서 출력하고 해야함 (두번이상 쓸거면 담아놓고 쓰는게 나음)
            Menu menu = menus.get( inputNumber-0);
             List<MenuItem> menuItems = menu.getMenuItems();

             // menuItems를 for문 돌려 출력

             //리팩토링하지말고 그냥 처음부터 코드 짜기
            */

//            // 환영 인사 및 메뉴 안내
//            System.out.println("Welcome to Sy Burger! There is our menu below: ");
//            // for 반복문으로 메뉴 출력
//            for(int i = 0; i < menu.menuItems.size(); i++) {
//                System.out.println((i + 1) + ". " + menu.get(i).getName() + " W " + menuItems.get(i).getPrice() + "\n" + menuItems.get(i).getDescription() + "\n");
//            }
//            System.out.println("0. Exit");
//
//            // 유효한 입력값 체크하는 불리안
//            boolean isValidInt = false;
//            while (!isValidInt) {
//                // 유효한 입력값이 안들어오는 예외 처리
//                try {
//                    System.out.println("Please type the number to order your food: ");
//
//                    // 입력값 받기
//                    int order = scanner.nextInt();
//
//                    // 입력값이 0부터 메뉴종류수까지인지 확인
//                    if (order >= 0 && order <= menuItems.size()) {
//                        // 올바른 숫자이면 반복 종료
//                        isValidInt = true;
//                    } else {
//                        System.out.println("Please enter a valid number");
//                        continue; //continue로 밑에 스위치까지 안 읽고, 바로 입력값 받게 만들기
//                    }
//
//                    // 주문 내역 안내
//                    System.out.print("You ordered: ");
//                    switch (order) {
//                        case 1:
//                            System.out.print(menuItems.get(0).getName()+ " W " + menuItems.get(0).getPrice());
//                            break;
//                        case 2:
//                            System.out.print(menuItems.get(1).getName()+ " W " + menuItems.get(1).getPrice());
//                            break;
//                        case 3:
//                            System.out.println(menuItems.get(2).getName()+ " W " + menuItems.get(2).getPrice());
//                            break;
//                        case 4:
//                            System.out.println(menuItems.get(3).getName()+ " W " + menuItems.get(3).getPrice());
//                            break;
//                        case 0:
//                            System.out.println("nothing");
//                            break;
//                    }
//                } catch (InputMismatchException e) {
//                    // 입력값이 숫자가 아닌 예외 처리
//                    System.out.println("Please enter a number");
//                    scanner.nextLine(); // 개행문자 > 버퍼에는 계속 입력값이 남아있음 > 그래서 nextLine이 엔터(컴퓨터 = \n)를 통해 없앤다.
//                }
//            }
        }
}
