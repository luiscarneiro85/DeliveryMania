
package deliverymaniav1;


import jplay.Sound;


public class Musica extends Thread{
    
    public static Sound bgm;
    
    /*
    carrega e toca a musica de fundo
    */
    
    public Musica(){
        bgm = new Sound("src/Musicas/bgmFinal.wav");
        bgm.decreaseVolume(7);
        bgm.setRepeat(true);
        
       
    }
    
    @Override
    public void run(){
       bgm.play();
       
       while(true){
           
       }

    }
    
}
