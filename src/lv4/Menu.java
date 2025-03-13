package lv4;

import lv3.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<lv3.MenuItem> menuItems = new ArrayList<>();


    // MenuItem 인스턴스화
    lv3.MenuItem syBurger = new lv3.MenuItem("Sy Burger", 7900, "100% Angus Beef flame-grilled topped with fresh Rocket");
    lv3.MenuItem smokedBurger = new lv3.MenuItem("Smoked Burger", 8900, "Flamed-grilled beef patty topped with smoked bacon");
    lv3.MenuItem cheeseBurger = new lv3.MenuItem("Cheese Burger", 6900, "Flamed-grilled beef patty topped with melted cheese and tomato");
    lv3.MenuItem hamburger = new MenuItem("Hamburger", 6900, "Two flamed-grilled beef patties with lettuce");

    public void menu() {
        //     MenuItem을 담을 menuItems에 리스트 인터페이스 구현한 ArrayList 인스턴스화하여 할당
        //     메서드 안에 있어야 활용이 가능하니, start 메서드에 우선 넣어주었다.
        menuItems.add(syBurger);
        menuItems.add(smokedBurger);
        menuItems.add(cheeseBurger);
        menuItems.add(hamburger);
    }

}
