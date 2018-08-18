
package deliverymaniav1;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jplay.Window;
import jplay.Keyboard;


public class DeliveryManiaV1 {

    public static Window janela;
    public static Keyboard teclado;
    public static Jogador player;
    public static Thread jogadorThread;
    public static CriadorHorda hordaThread;
    public static Temporizador tempoThread;
    public static CriadorEntregas entregaThread;
    public static Musica musicaThread;
    public static Fantasma[] vetorFantasma;
    public static Thread[] vetorThread;

    public static SalvaRanking ranking;
    
    // verificador - atropelamentos - entregas - cachorro - tempo - fantasma
    public static int[] vetorConquistas = new int []{0,0,0,0,0,0};
    public static String[] vetorTrofeu = new String[]{"nulo","nulo","nulo","nulo","nulo","nulo","nulo","nulo","nulo",};
    

    public static void main(String[] args) throws IOException {

    /*
    Cria a janela e o teclado do jplay
    */
       janela = new Window(1920,1080);
       //janela.setFullScreen();
       teclado = janela.getKeyboard(); 
       player = new Jogador(950,200);
       vetorFantasma = new Fantasma[5];
       vetorThread = new Thread[5];
       
       /*
       preenche o vetor de threads com objetos do tipo fantasma
       */
       for(int i=0;i<vetorFantasma.length;i++){
            vetorFantasma[i] = new Fantasma(28);
            vetorFantasma[i].ativo = false;
       }

       jogadorThread = new Thread(player);

       musicaThread = new Musica();
    
       /*
       faz leitura do arquivo que salva as conquistas
       */
        ranking = new SalvaRanking();
        ranking.lerArquivo("src/Save/save.txt");
        //ranking.lerArquivo2("src/Save/ranking.txt");
        
        ranking.organizaRanking();
        
     /*
     dispara a thread principal e a thread de musica   
     */   
       musicaThread.start();
       jogadorThread.start();
       
       
        
        while(true){
       
       }
        
    }
    


}
