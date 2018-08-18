
package deliverymaniav1;

import java.util.Random;
import jplay.Sound;




public class CriadorHorda extends Thread{
    
    public static boolean entregaRealizada;
    
    Inimigo zumbi1;
    Inimigo zumbi2;
    int numero;
    
    Inimigo[] horda;
    int numeroZumbis;
    int[] vetorEscolha;
    
    Imagem numero5;
    public static boolean perdeTempo;
    int posY;
    
    Imagem colisaoJogador;
    public static int atropelamentos;
    
/*
    essa thread cria objetos do tipo inimigo e preenche um vetor,
    osposiciona no mapa, pinta e verifica a colisao 
    */
    public CriadorHorda(){
       numeroZumbis = 9;
       horda = new Inimigo[numeroZumbis];
       vetorEscolha = new int[]{99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,
       99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99};
       entregaRealizada = true;
       
       numero5 = new Imagem(0,0,"src/Imagens/perdeTempo.png");
       perdeTempo = false;
       posY = 0;
       
       colisaoJogador = new Imagem(0,0,"src/Imagens/vazio.png");
       colisaoJogador.width = 32;
       colisaoJogador.height = 32;
       
       atropelamentos = 0;
       
       
    }
    
    @Override
    public void run(){

        while(true){ 
         if(entregaRealizada){
             this.criarZumbi();
             entregaRealizada = false;
         }
         this.pintaZumbi();
         this.colisaoZumbi();
         
         if(perdeTempo){
             numero5.draw();
             
             
         }

          
        }
        
    }
  /*
    cria os objetos do tipo zumbi com posicao x, y diferentes no mapa
    e os coloca em um vetor
    */  
    public void criarZumbi(){
        Random gerador = new Random();
        boolean estado;
        int contador = 0;
        int seletorZumbi = 0;
        int x = 0;
        int y = 0;
        
        for(int i=1;i<=numeroZumbis;i++){
            
            estado = true;
            while(estado){
                contador = 0;
                seletorZumbi = gerador.nextInt(35); // numero de posicoes de respwan
                for(int j = 0;j<i;j++){
                    if(seletorZumbi != vetorEscolha[j]){
                        contador++;
                    }
                }
                if(contador == i){
                    estado = false;
                }
            }

            switch(seletorZumbi){
                case 0:
                    x = 950;
                    y = 200;
                    break;
                case 1:
                    x = 1055;
                    y = 260;
                    break;
                case 2:
                    x = 1186;
                    y = 324;
                    break;
                case 3:
                    x = 1313;
                    y = 389;
                    break;
                case 4:
                    x = 1440;
                    y = 450;
                    break;
                case 5:
                    x = 1570;
                    y = 515;
                    break;  
                case 6:
                    x = 815;
                    y = 260;
                    break;    
                case 7:
                    x = 940;
                    y = 325;
                    break;    
                case 8:
                    x = 1060;
                    y = 395;
                    break;   
                case 9:
                    x = 1195;
                    y = 455;
                    break;    
                case 10:
                    x = 1320;
                    y = 518;
                    break;    
                case 11:
                    x = 1445;
                    y = 583;
                    break;    
                case 12:
                    x = 685;
                    y = 323;
                    break;    
                case 13:
                    x = 810;
                    y = 386;
                    break;    
                case 14:
                    x = 940;
                    y = 455;
                    break;    
                case 15:
                    x = 1067;
                    y = 518;
                    break;    
                case 16:
                    x = 1195;
                    y = 578;
                    break;    
                case 17:
                    x = 1315;
                    y = 645;
                    break;    
                case 18:
                    x = 560;
                    y = 390;
                    break;    
                case 19:
                    x = 678;
                    y = 455;
                    break;    
                case 20:
                    x = 805;
                    y = 520;
                    break;    
                case 21:
                    x = 940;
                    y = 587;
                    break;
                case 22:
                    x = 1065;
                    y = 645;
                    break;    
                case 23:
                    x = 1190;
                    y = 707;
                    break;    
                case 24:
                    x = 430;
                    y = 452;
                    break;    
                case 25:
                    x = 552;
                    y = 517;
                    break;    
                case 26:
                    x = 680;
                    y = 577;
                    break;    
                case 27:
                    x = 810;
                    y = 642;
                    break;    
                case 28:
                    x = 940;
                    y = 705;
                    break;    
                case 29:
                    x = 1063;
                    y = 772;
                    break;    
                case 30:
                    x = 300;
                    y = 515;
                    break;   
                case 31:
                    x = 430;
                    y = 580;
                    break;    
                case 32:
                    x = 560;
                    y = 645;
                    break;    
                case 33:
                    x = 690;
                    y = 705;
                    break;    
                case 34:
                    x = 817;
                    y = 770;
                    break;    
                case 35:
                    x = 937;
                    y = 835;
                    break;    
            }
            colisaoJogador.x = x;
            colisaoJogador.y = y;
            
            if(colisaoJogador.collided(DeliveryManiaV1.player)){
                i -= 1;
            }else{
               vetorEscolha[i-1] = seletorZumbi;
            horda[i-1] = new Inimigo(x,y,"src/Imagens/vetorZumbi.png"); 
            }
            


        }
    }
    /*
    pinta os zumbis nos locais indicados
    */
    public void pintaZumbi(){
         for(int i=0;i<numeroZumbis;i++){
                 
                 if(horda[i].isPlaying() == false){
                    horda[i].hide();
                 }else{
                    horda[i].draw();
                    horda[i].update();
                 }
         }
    }
    /*
    verifica a colisao com o jogador, trata os eventos dessa colisao
    efeito sonoro, perca de tempo, animcao zumbi, vetor de conquistas
    */
    public void colisaoZumbi(){
        for(int i=0;i<numeroZumbis;i++){
            if(horda[i].collided(Jogador.hitPlayer)&& horda[i].ativo){
                atropelamentos ++;
                horda[i].setImagem();
                Temporizador.contagem -= 3;
                new Sound("src/Musicas/colisaoZumbi.wav").play();
                DeliveryManiaV1.vetorConquistas[1] ++;
                if(DeliveryManiaV1.vetorConquistas[3] < 7){
                   DeliveryManiaV1.vetorConquistas[3] = 0; 
                }
                numero5.x = horda[i].x;
                numero5.y = horda[i].y - 32;
                posY = (int)numero5.y;
                perdeTempo = true; 
                horda[i].ativo = false;
              
            }
        }
    }
    

    
}
