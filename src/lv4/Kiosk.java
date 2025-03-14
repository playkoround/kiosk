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

        // 메뉴 카테고리 보여주는 메서드
        public void viewMenuCategories() {
            System.out.println("category: ");
            int i = 1;
            for (Menu menu : menus) {
                String category = menu.getCategory();
                System.out.println(i + ". " + category);
                i++;
            }
        }
        // 카테고리별 메뉴들을 보여주는 메서드
        public <T> T getUserSelection(String prompt, List<T> options) throws Exception {
            boolean isValid = false;
            int choice = -1; // 유효값이 아니라는 것을 뜻하기 위해 -1로 초기화

            while (!isValid) {
                try {
                    // 사용자에게 안내 메세지 출력
                    System.out.println(prompt);
                    for (int i = 0; i < options.size(); i++) {
                        System.out.println((i + 1) + ". " + options.get(i).toString()); // 메모리 주소 toString 테스트
                    }

                    // 입력값 받기
                    System.out.print("\nPlease enter the number: ");
                    choice = scanner.nextInt() - 1;

                    // 입력값 검증
                    if (choice >= 0 && choice <= options.size()) {
                        isValid = true; // 올바른 입력이면 반복 종료
                    } else {
                        System.out.println("Please enter a valid number.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a number.");
                    scanner.nextLine(); // 버퍼 비우기

                }
                // return options.get(choice); // return이 여기 위치하면, while문을 안탈경우 return이 없는 메서드라고 생각해서 오류가 남
            }
            return options.get(choice);
        }



        // start 메서드
        // 메서드 5요소 접근제어자 반환타입 메서드이름 (매개변수) {바디}
        public void start(){

            // 환영 인사
            System.out.println("Welcome to Sy Burger! \n");

            // 카테고리 보여주기
            viewMenuCategories();

            // 카테고리 선택 및 그에 따른 안내
            boolean isValidCategoryInt = false;
            while (!isValidCategoryInt) {
                // 유효한 입력값이 안들어오는 예외 처리
                try {
                    // 입력값 받기
                    System.out.println("\nPlease select the category's number: ");
                    int chosenCategory = scanner.nextInt();

                    // 입력값이 1부터 카테고리 종류수까지인지 확인
                    if (chosenCategory >= 1 && chosenCategory <= menus.size()) {
                        // 올바른 숫자이면 반복 종료
                        isValidCategoryInt = true;
                    } else {
                        System.out.println("Please enter a valid number");
                        continue; //continue로 밑에 스위치까지 안 읽고, 바로 입력값 받게 만들기
                    }
                    // 카테고리 선택에 따른 메뉴 안내
                    System.out.print("There are our menus below: \n");
                    int i = 1;
                    Menu menu = menus.get(chosenCategory - 1); // 선택한 카테고리(Menu) 가져오기
                    List<MenuItem> menuItems = menu.getMenuItems();
                    for (MenuItem item : menuItems) {
                        System.out.println(i + ". " + item.getName() + " - W " + item.getPrice());
                        System.out.println(item.getDescription() + "\n");
                        i++;
                    }
                }
                catch (InputMismatchException e) {
                    // 입력값이 숫자가 아닌 예외 처리
                    System.out.println("Please enter a number");
                    scanner.nextLine(); // 개행문자 > 버퍼에는 계속 입력값이 남아있음 > 그래서 nextLine이 엔터(컴퓨터 = \n)를 통해 없앤다.
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
