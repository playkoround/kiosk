import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 메뉴 자동 출력, 코드 가독성을 위해 """ """을 이용
        System.out.println("""
                [ Sy's Burger ]
                1. SyBurger      | W 6.9 | 100% Angus Beef flame-grilled topped with fresh Rocket
                2. Smoked burger | W 8.9 | Flamed-grilled beef patty topped with smoked bacon
                3. Cheeseburger  | W 6.9 | Flamed-grilled beef patty topped with melted cheese and tomato
                4. Hamburger     | W 5.4 | Two flamed-grilled beef patties with lettuce
                0. Exit""");

        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        // 메뉴 선택
        System.out.println("Choose your choice: ");
        int choice = sc.nextInt();

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



    }
}
