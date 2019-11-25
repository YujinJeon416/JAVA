package minkj1992;

public class MusicBox {
    int type;

    public MusicBox(int type){
        this.type = type;
    }

    //신나는 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public void playMusicA(){
        for(int i = 0; i < 10; i ++){
            System.out.println(this.type+": 신나는 음악!!!");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    } //playMusicA

    //슬픈 음악!!!이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public void playMusicB(){
        for(int i = 0; i < 10; i ++){
            System.out.println(this.type+": 슬픈 음악!!!");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    } //playMusicB
    //카페 음악!!! 이란 메시지가 1초이하로 쉬면서 10번 반복출력
    public void playMusicC(){
        for(int i = 0; i < 10; i ++){
            System.out.println(this.type+": 카페 음악!!!");
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    } //playMusicC
}