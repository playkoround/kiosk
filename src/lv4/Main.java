package lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk(dataSettings());
        kiosk.start();
    }

    // 현업에서는 데이터베이스나 클라이언트에서 다음 datasettings같은 데이터를 가져온다.
    public static List<Menu> dataSettings() {

        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("Sy Burger", 7900, "100% Angus Beef flame-grilled topped with fresh Rocket"));
        burgers.add(new MenuItem("Smoked Burger", 8900, "Flamed-grilled beef patty topped with smoked bacon"));
        burgers.add(new MenuItem("Cheese Burger", 6900, "Flamed-grilled beef patty topped with melted cheese and tomato"));
        burgers.add(new MenuItem("Hamburger", 6900, "Two flamed-grilled beef patties with lettuce"));

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Sy Beer", 8900, "100% home-made draft beer"));
        drinks.add(new MenuItem("Sprite", 3900, "Zero sprite with lemon slice"));
        drinks.add(new MenuItem("Coke", 3900, "Zero pepsi with lime slice"));
        drinks.add(new MenuItem("Orange juice", 4900, "Real fresh orange juice"));

        //메뉴를 카테고리와 함께 묶은 메뉴들
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("burgers", burgers));
        menus.add(new Menu("drinks", drinks));

        return menus;



    }


}
