package lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 속성 | list 안에 있는 index마다의 이름, 가격, 설명  > menuItem의 게터를 키오스크에 가져와서 정제
    String 카테고리 = "이름";
    private List<MenuItem> menuItems = new ArrayList<>();


    // MenuItem 인스턴스화
    MenuItem syBurger = new MenuItem("Sy Burger", 7900, "100% Angus Beef flame-grilled topped with fresh Rocket");
    MenuItem smokedBurger = new MenuItem("Smoked Burger", 8900, "Flamed-grilled beef patty topped with smoked bacon");
    MenuItem cheeseBurger = new MenuItem("Cheese Burger", 6900, "Flamed-grilled beef patty topped with melted cheese and tomato");
    MenuItem hamburger = new MenuItem("Hamburger", 6900, "Two flamed-grilled beef patties with lettuce");

    public void menu() {
        //     MenuItem을 담을 menuItems에 리스트 인터페이스 구현한 ArrayList 인스턴스화하여 할당
        //     메서드 안에 있어야 활용이 가능하니, start 메서드에 우선 넣어주었다.
        menuItems.add(syBurger);
        menuItems.add(smokedBurger);
        menuItems.add(cheeseBurger);
        menuItems.add(hamburger);
    }

}