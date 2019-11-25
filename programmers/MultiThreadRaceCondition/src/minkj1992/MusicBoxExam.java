package minkj1992;

public class MusicBoxExam {

    public static void main(String[] args) {
        // MusicBox 인스턴스, ciritical section (0)
//        MusicBox box = new MusicBox();
//        MusicPlayer kim = new MusicPlayer(1, box);
//        MusicPlayer lee = new MusicPlayer(2, box);
//        MusicPlayer kang = new MusicPlayer(3, box);

        // critical section (x), musicBox를 공유하지 않는다.
        MusicPlayer kim = new MusicPlayer(1);
        MusicPlayer lee = new MusicPlayer(2);
        MusicPlayer kang = new MusicPlayer(3);

//         MusicPlayer쓰레드를 실행합니다.
        kim.start();
        lee.start();
        kang.start();
    }
}
