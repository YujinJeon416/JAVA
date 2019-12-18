public class Main {
    public static void main(String[] args) {
        SystemSpeaker speaker1 = SystemSpeaker.getInstance();
        SystemSpeaker speaker2 = SystemSpeaker.getInstance();

        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());
        speaker2.setVolume(7);
        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());

        // 동일한 instance로 보인다.
    }
}
