package JasonSourceCodes;
import java.util.ArrayList;

public class Menu {
    private ArrayList<String> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public ArrayList<String> getItems() {
        return items;
    }
}