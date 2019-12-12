//package ch11.hashCode;
//
//import java.util.HashMap;
//
//public class KeyExample {
//    public static void main(String[] args) {
//        HashMap<Key, String> hashMap = new HashMap<>();
//        Key k1 = new Key(1);
//        Key k2 = new Key(2);
//
//        hashMap.put(k1, "Á¦¹Î¿í");
//        hashMap.put(k2, "Á¦¹ÎÈ£");
//
//        String value = hashMap.get(new Key(1));
//        String value2 = hashMap.get(k1);
//        String value3 = hashMap.get(k2);
//
//        System.out.println(value);
//        System.out.println(value2);
//        System.out.println(value3);
//    }
//}
