
package deliverymaniav1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jplay.Sound;




public class CriadorEntregas extends Thread {
    
    Imagem seta;
    Imagem ganhaTempo;
    public static int entrega;
    Sound somEntrega;
    public static boolean ativo;
    int numero;
    int entregaAntiga;
    boolean entregou;
    public static boolean spriteTempo;
    
    
    public CriadorEntregas(){
        seta = new Imagem(0,0,"src/Imagens/seta.png");
        ganhaTempo = new Imagem(0,0,"src/Imagens/ganhaTempo2.png");
        entrega = 0;
        somEntrega = new Sound("src/Musicas/entrega1.wav");
        somEntrega.setVolume(5);
        ativo = true;
        entregou = false;
        spriteTempo = false;
        
    }

    @Override
    public void run(){
        Random gerador = new Random();
 /*
        seleciona um local pre indicado para pintar a seta de entrega
        */       
        while(true){
            if(Temporizador.piscaSeta){
              seta.draw(); 
            }
            if(spriteTempo){
                ganhaTempo.draw();
            }
            
            if(entrega<0){
                entrega = 0;
            }
            
            if(!entregou){
                
                numero = gerador.nextInt(59);
                //System.out.println("" + numero);
                switch(numero){
                    case 0:
                        seta.x = 859;
                        seta.y = 239;
                        break;
                    case 1:
                        seta.x = 932;
                        seta.y = 308;
                        break;
                    case 2:
                        seta.x = 986;
                        seta.y = 279;
                        break;
                    case 3:
                        seta.x = 993;
                        seta.y = 331;
                        break;
                    case 4:
                        seta.x = 1060;
                        seta.y = 369;
                        break;
                    case 5:
                        seta.x = 1130;
                        seta.y = 398;
                        break;
                    case 6:
                        seta.x = 1192;
                        seta.y = 432;
                        break;
                    case 7:
                        seta.x = 1228;
                        seta.y = 411;
                        break;
                    case 8:
                        seta.x = 1252;
                        seta.y = 463;
                        break;
                    case 9:
                        seta.x = 1317;
                        seta.y = 493;
                        break;
                    case 10:
                        seta.x = 1382;
                        seta.y = 523;
                        break;
                    case 11:
                        seta.x = 1444;
                        seta.y = 557;
                        break;
                    case 12:
                        seta.x = 1512;
                        seta.y = 524;
                        break;
                    case 13:
                        seta.x = 1198;
                        seta.y = 345;
                        break;
                    case 14:
                        seta.x = 1095;
                        seta.y = 300;
                        break;
                    case 15:
                        seta.x = 1383;
                        seta.y = 594;
                        break;
                    case 16:
                        seta.x = 1319;
                        seta.y = 621;
                        break;
                    case 17:
                        seta.x = 1254;
                        seta.y = 591;
                        break;
                    case 18:
                        seta.x = 804;
                        seta.y = 366;
                        break;
                    case 19:
                        seta.x = 738;
                        seta.y = 333;
                        break;
                    case 20:
                        seta.x = 838;
                        seta.y = 300;
                        break;
                    case 21:
                        seta.x = 685;
                        seta.y = 350;
                        break;
                    case 22:
                        seta.x = 612;
                        seta.y = 398;
                        break;
                    case 23:
                        seta.x = 676;
                        seta.y = 431;
                        break;
                    case 24:
                        seta.x = 1122;
                        seta.y = 654;
                        break;
                    case 25:
                        seta.x = 1191;
                        seta.y = 684;
                        break;
                    case 26:
                        seta.x = 1220;
                        seta.y = 621;
                        break;
                    case 27:
                        seta.x = 1130;
                        seta.y = 716;
                        break;
                    case 28:
                        seta.x = 1072;
                        seta.y = 670;
                        break;
                    case 29:
                        seta.x = 995;
                        seta.y = 717;
                        break;
                    case 30:
                        seta.x = 547;
                        seta.y = 493;
                        break;
                    case 31:
                        seta.x = 482;
                        seta.y = 461;
                        break;
                    case 32:
                        seta.x = 582;
                        seta.y = 431;
                        break;
                    case 33:
                        seta.x = 433;
                        seta.y = 480;
                        break;
                    case 34:
                        seta.x = 355;
                        seta.y = 526;
                        break;
                    case 35:
                        seta.x = 420;
                        seta.y = 560;
                        break;
                    case 36:
                        seta.x = 484;
                        seta.y = 586;
                        break;
                    case 37:
                        seta.x = 552;
                        seta.y = 624;
                        break;
                    case 38:
                        seta.x = 585;
                        seta.y = 557;
                        break;
                    case 39:
                        seta.x = 610;
                        seta.y = 657;
                        break;
                    case 40:
                        seta.x = 676;
                        seta.y = 686;
                        break;
                    case 41:
                        seta.x = 686;
                        seta.y = 600;
                        break;
                    case 42:
                        seta.x = 742;
                        seta.y = 719;
                        break;
                    case 43:
                        seta.x = 808;
                        seta.y = 752;
                        break;
                    case 44:
                        seta.x = 843;
                        seta.y = 680;
                        break;
                    case 45:
                        seta.x = 870;
                        seta.y = 785;
                        break;
                    case 46:
                        seta.x = 936;
                        seta.y = 809;
                        break;
                    case 47:
                        seta.x = 1002;
                        seta.y = 783;
                        break;
                    case 48:
                        seta.x = 933;
                        seta.y = 750;
                        break;
                    case 49:
                        seta.x = 900;
                        seta.y = 665;
                        break;
                    case 50:
                        seta.x = 963;
                        seta.y = 665;
                        break;
                    case 51:
                        seta.x = 713;
                        seta.y = 536;
                        break;
                    case 52:
                        seta.x = 645;
                        seta.y = 525;
                        break;
                    case 53:
                        seta.x = 808;
                        seta.y = 485;
                        break;
                    case 54:
                        seta.x = 935;
                        seta.y = 542;
                        break;
                    case 55:
                        seta.x = 843;
                        seta.y = 424;
                        break;
                    case 56:
                        seta.x = 875;
                        seta.y = 520;
                        break;
                    case 57:
                        seta.x = 998;
                        seta.y = 587;
                        break;
                    case 58:
                        seta.x = 1063;
                        seta.y = 613;
                        break;
                    case 59:
                        seta.x = 771;
                        seta.y = 613;
                        break;
                }
                entregaAntiga = numero;
                entregou = true;
            }
            
     /*
            verifica a colisao da entrega com o jogador e trava os eventos
            */       
            if(seta.collided(Jogador.hitPlayer) && entregou){
                ganhaTempo.x = seta.x;
                ganhaTempo.y = seta.y - 32;
                
                new Sound("src/Musicas/entrega1.wav").play();
                entrega ++;
                DeliveryManiaV1.vetorConquistas[2]++;
                DeliveryManiaV1.vetorConquistas[3]++;
                Temporizador.contagem += 2;
                try {
                    Thread.sleep(10);       // delay para nao dar pau
                } catch (InterruptedException ex) {
                    Logger.getLogger(CriadorEntregas.class.getName()).log(Level.SEVERE, null, ex);
                }
                CriadorHorda.entregaRealizada = true;
                entregou = false;
                spriteTempo = true;
            }
        }
        
    }
}
