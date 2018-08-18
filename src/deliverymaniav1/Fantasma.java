
package deliverymaniav1;

import java.util.logging.Level;
import java.util.logging.Logger;
import jplay.Sound;
import jplay.Sprite;


public class Fantasma extends Sprite implements Runnable{
    
    boolean ativo;
    int tempo;
    
    public Fantasma(int numero) {
        super("src/Imagens/fantasma.png");
        this.x = 930;
        this.y = 520;
        ativo = true;
        tempo = numero;
    }

    @Override
    public void run() {
        /*
        se o fantasma estiver ativo no jogo, ele persegue o jogador
        trata a colisao e os eventos dessa colisao
        */
        while(true){
            if(ativo){
               this.moveTo(DeliveryManiaV1.player.x, DeliveryManiaV1.player.y, 1);
                if(this.collided(Jogador.hitPlayer)){
                    if(DeliveryManiaV1.vetorConquistas[5] < 2){
                       DeliveryManiaV1.vetorConquistas[5] = 0;
                    }
                   new Sound("src/Musicas/fantasmahit.wav").play();
                    this.hide();
                    this.ativo = false;
                    CriadorEntregas.entrega -= 2;
                    
                    
                } 
            }
            
            
/*
         fica em estado sleep por um determinado tempo, diferente para cada fantasma,   
*/
            
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Fantasma.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
