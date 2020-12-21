import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {

    // key and value pair -> Dictionary
    // Map Interface
    // contacts -> phoneBook -> key is unique , value can repeat
    // 1. HashMap 2. TreeMap

    public static void main(String[] args) {
        HashMap<String, Integer> phone = new HashMap<>();
        phone.put("Reshma", 781871290);
        phone.put("Resdshma", 781871291);
        phone.put("Ressdshma", 781871292);
        phone.put("Resdsdhma", 781871293);
        phone.put("Reshmdsda", 781871294);
        System.out.println(phone);
        System.out.println(phone.keySet());
        System.out.println(phone.entrySet());
        System.out.println(phone.size());
        System.out.println(phone.containsKey("Resdsdhma"));
        System.out.println(phone.containsValue(781871293));

        phone.remove("Reshma");
        System.out.println(phone);
        System.out.println("\nUsing  Itrartion :");
        Set<Map.Entry<String, Integer>> set = phone.entrySet();
        Iterator<Map.Entry<String, Integer>> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nUsing For Loop : ");

        for (Map.Entry<String, Integer> me : set) {
            System.out.println(me);
        }

    }
}
