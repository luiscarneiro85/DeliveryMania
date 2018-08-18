
package deliverymaniav1;

import jplay.Animation;
import jplay.Sprite;


public class Inimigo extends Sprite {
    
   Animation animacaoZumbi;
   Animation animacaoZumbiDead;
   boolean ativo;
    
/*
   classe dos zumbis, contra a animacao.
   */    
    public Inimigo(int x,int y, String caminho) {
        super(caminho,27);
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        ativo = true;
        
        
        this.setTotalDuration(1800);
        this.setSequence(1, 15);

    }
    
   
    
    public void setImagem(){
        this.setTotalDuration(1400);
        this.setSequence(16, 27);
        this.setLoop(false);
        
        
        
    }
        

            
    
}
        
    

