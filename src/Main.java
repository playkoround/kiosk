import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 메뉴 자동 출력, 코드 가독성을 위해 """ """을 이용
        System.out.println("""
                [ Sy's Burger ]
                1. SyBurger      | W 6.9 | 100% Angus Beef flame-grilled topped with fresh Rocket
                2. Smoked burger | W 8.9 | Flamed-grilled beef patty topped with smoked bacon
                3. Cheeseburger  | W 6.9 | Flamed-grilled beef patty topped with melted cheese and tomato
                4. Hamburger     | W 5.4 | Two flamed-grilled beef patties with lettuce
                0. Exit""");

        // while문을 위한 불리안 변수 생성 (유효한 입력 들어올 때까지 반복)
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("Choose your choice: ");
                int choice = sc.nextInt();
                // 입력값 0~4인지 확인
                if (choice >= 0 && choice <= 4) {
                    flag = false; // 올바른 입력이면 반복 종료
                } else {
                    System.out.println("Please enter a number between 0 and 4");
                }
                    switch (choice) {
                        case 1:
                            System.out.println("You ordered: SyBurger");
                            break;
                        case 2:
                            System.out.println("You ordered: smoked burger");
                            break;
                        case 3:
                            System.out.println("You ordered: cheeseburger");
                            break;
                        case 4:
                            System.out.println("You ordered: hamburger");
                            break;
                        case 0:
                            break;
                    }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 0 and 4");
                sc.nextLine(); // 개행문자 > 버퍼에는 계속 입력값이 남아있음 > 그래서 nextLine이 엔터(컴퓨터 = \n)를 통해 없앤다.
            }
        }
    }
}

