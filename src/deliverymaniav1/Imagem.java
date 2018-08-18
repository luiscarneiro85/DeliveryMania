
package deliverymaniav1;

import jplay.Sprite;


public class Imagem extends Sprite{
  /*
    classe para carregar as imagens e aplicar fisica a elas.
    */  
    public Imagem(int x,int y, String caminho) {
        super(caminho);
        this.x = x;
        this.y = y;
    }
    
}
