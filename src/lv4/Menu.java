package lv4;
import java.util.List;

public class Menu {
    // 속성 | list 안에 있는 index마다의 이름, 가격, 설명  > menuItem의 게터를 키오스크에 가져와서 정제
    private String category;
    private List<MenuItem> menuItems;

    // 생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // 게터들
    public String getCategory() {
        return this.category;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}

