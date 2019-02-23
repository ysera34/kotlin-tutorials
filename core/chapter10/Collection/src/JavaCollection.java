import java.util.List;

public class JavaCollection {
    public static List<String> addOne(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            items.set(i, String.valueOf(Integer.valueOf(items.get(i)) + 1));
        }
        return items;
    }
}
