
package deliverymaniav1;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Temporizador extends Thread {
    
    public static int contagem;
    public static int contagemConquista;
    public static boolean piscaSeta;
    public static int marcadorTempo;
    public static int marcadorTempo2;
    
    public Temporizador(){

        contagem = 90;
        contagemConquista = 0;
        piscaSeta = true;
        marcadorTempo = 0;
        marcadorTempo2 = 0;
    }
    
     @Override
    public void run(){
    /*
    alterna entre acordada e dormindo essa thread conta o tempo e faz
    sinalizacoes para alguns eventos, como o piscar da seta. conta 1 seg
        */
        while(true){
            try {
                Thread.sleep(1000);     // 1 segundo
            } catch (InterruptedException ex) {
                Logger.getLogger(CriadorEntregas.class.getName()).log(Level.SEVERE, null, ex);
            }
            contagem--;
            contagemConquista++;
            DeliveryManiaV1.vetorConquistas[4] = contagemConquista;
            
            if(CriadorEntregas.spriteTempo){
                marcadorTempo2++;
                if(marcadorTempo2 > 1){
                    marcadorTempo2 = 0;
                    CriadorEntregas.spriteTempo = false;
                }
            }
            
            if(CriadorHorda.perdeTempo){
                marcadorTempo++;
                if(marcadorTempo > 1){
                    marcadorTempo = 0;
                    CriadorHorda.perdeTempo = false;
                }
            }
            
            if(piscaSeta){
                piscaSeta = false;
            }else{
                piscaSeta = true;
            }
        }
       
    }
    
}
