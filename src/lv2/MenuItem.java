package lv2;

public class MenuItem {
        // 속성(=필드=상태)
        private String name;
        private int price;
        private String description;

        // 생성자
        public MenuItem(String name, int price, String description) {
                this.name = name;
                this.price = price;
                this.description = description;
        }

        // Getter 메서드
        public String getName() {
                return name;
        }

        public int getPrice() {
                return price;
        }

        public String getDescription() {
                return description;
        }

        // Setter 메서드 String name = "Cheeseburger";
        public void setName(String name) {
                this.name = name;
        }

        public void setPrice(int price) {
               this.price = price;
        }

        public void setDescription(String description) {
                this.description = description;
        }


}
