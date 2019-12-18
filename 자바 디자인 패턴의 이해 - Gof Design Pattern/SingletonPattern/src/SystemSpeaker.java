public class SystemSpeaker {
    static private SystemSpeaker instance;
    private int volume;

    private SystemSpeaker() {
        //싱글톤을 제외한 field값 init
        volume = 5;
    }

    public static SystemSpeaker getInstance() {
        if (instance == null) {
            // 시스템 스피커와 통신하기 위한 복잡한 작업 코드 생략
            instance = new SystemSpeaker();
        }
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
