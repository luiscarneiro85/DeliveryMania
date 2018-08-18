
package deliverymaniav1;


import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Sprite;



public class Jogador extends Sprite implements Runnable{
    


    public static Imagem hitPlayer;
    int posicaoAntigaX;
    int posicaoAntigaY;
    Sound alarme;
    Font fonte;
    int seletorFantasma = 0;
    
    Imagem relogio;
    Imagem fundoTempo;
    Imagem pizza;
    Imagem fundoPizza;
    Imagem fundo;
    Imagem fundoGame;
    Imagem titulo;
    Imagem telaGameover;
    Imagem fundoConquista;
    Imagem fundoRanking;
    Imagem trofeu;
    Imagem trofeu2;
    Imagem trofeu3;
    Imagem trofeu4;
    Imagem trofeu5;
    Imagem trofeu6;
    Imagem trofeu7;
    Imagem trofeu8;
    Imagem trofeu9;
    
    
    Imagem botaoJogar;
    Imagem botaoJogar2;
    Imagem botaoCreditos;
    Imagem botaoConquistas;
    Imagem botaoRanking;
    Imagem botaoSair;
    Imagem selecao;
    Imagem botaoVoltar;
    Imagem creditos;
    Imagem regras;
    
    Imagem caixaNomes;
    Imagem caixaTexto;
    Imagem caixaValente;
    Imagem caixaOusado;
    Imagem caixaHeroi;
    Imagem caixaAcidente;
    Imagem caixaPressa;
    Imagem caixaJeremias;
    Imagem caixaCachorro;
    Imagem caixaNinja;
    Imagem caixaGhost;
    
    Imagem mapa;
    Imagem selecao2;
    Imagem valente;
    Imagem ousado;
    Imagem heroi;
    Imagem acidente;
    Imagem cachorro;
    Imagem pressa;
    Imagem jeremias;
    Imagem ninja;
    Imagem ghost;

    double velocidadeX;
    double velocidadeY;

    boolean movendo;
    boolean tecla = true;
    boolean som;
    
    String estado;
    
    int indice; // indice para organizar pontuacao
    
    int posicaoX; //pintar ranking na tela
    int posicaoY;
    
    Color cor = Color.green;
    
    Sound selecaoBotao;
    
    JTextField field = new JTextField(10);
    
    public Jogador(int x, int y) throws IOException {
        
        super("src/Imagens/vetorPlayer.png",8);
        this.x = 950;
        this.y = 210;
        movendo = false;

        hitPlayer = new Imagem(0,0,"src/Imagens/vazio.png");
        hitPlayer.width = 10;
        hitPlayer.height = 10;
        posicaoAntigaX = 0;
        posicaoAntigaY = 0;
        fonte = new Font("arial",Font.BOLD,30);
        
        relogio = new Imagem(1400,0,"src/Imagens/relogio.png");
        fundoTempo = new Imagem(1480,0,"src/Imagens/fundoTempo.png");
        pizza = new Imagem(1650,15,"src/Imagens/pizza.png");
        fundoPizza = new Imagem(1730,0,"src/Imagens/fundoTempo.png");
        mapa = new Imagem(150,150,"src/Imagens/mapa4.png");
        fundo = new Imagem(0,0,"src/Imagens/fundofinal.jpg");
        titulo = new Imagem(0,0,"src/Imagens/titulo.png");
        fundoGame = new Imagem(0,0,"src/Imagens/fundomapa.png");
        telaGameover = new Imagem(0,0,"src/Imagens/gameover2.png");
        fundoConquista = new Imagem(0,0,"src/Imagens/fudoConquistas.png");
        fundoRanking = new Imagem(0,0,"src/Imagens/ranking.png");
                
        caixaNomes = new Imagem((DeliveryManiaV1.janela.getWidth()/2) - 250,(DeliveryManiaV1.janela.getHeight()/2) -250,"src/Imagens/caixanomes.png");
        caixaTexto = new Imagem((DeliveryManiaV1.janela.getWidth()/2) - 250,(DeliveryManiaV1.janela.getHeight()/2) + 300,"src/Imagens/caixaTexto.png");
        caixaValente = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/valente2.png");
        caixaOusado = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/ousado2.png");
        caixaHeroi = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/heroi2.png");
        caixaAcidente = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/acidente2.png");
        caixaPressa = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/pressa2.png");
        caixaJeremias = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/jeremias2.png");
        caixaCachorro = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/cachorro2.png");
        caixaGhost = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/ghost2.png");
        caixaNinja = new Imagem((int)caixaTexto.x,(int)caixaTexto.y,"src/Imagens/ninja2.png");
        
        
        botaoJogar = new Imagem((DeliveryManiaV1.janela.getWidth()/2)-57,(DeliveryManiaV1.janela.getHeight()/2)-50,"src/Imagens/botaojogar.png");
        botaoJogar2 = new Imagem((DeliveryManiaV1.janela.getWidth()-130),(DeliveryManiaV1.janela.getHeight() - 70),"src/Imagens/botaojogar.png");
        botaoCreditos = new Imagem((int)botaoJogar.x - 125,(int)botaoJogar.y + 75,"src/Imagens/botaocreditos.png");
        botaoConquistas = new Imagem((int)botaoJogar.x + 125,(int)botaoJogar.y + 75,"src/Imagens/conquistas.png");
        botaoSair = new Imagem((int)botaoJogar.x,(int)botaoCreditos.y + 75,"src/Imagens/botaosair.png");
        selecao = new Imagem((int)botaoJogar.x -5,(int)botaoJogar.y + 70,"src/Imagens/selecao.png");
        botaoVoltar = new Imagem((DeliveryManiaV1.janela.getWidth()-130),(DeliveryManiaV1.janela.getHeight() - 70),"src/Imagens/botaovoltar.png");
        botaoRanking = new Imagem((int)botaoVoltar.x, (int)botaoVoltar.y - 100,"src/Imagens/botaoranking.png");
        creditos = new Imagem(0,0,"src/Imagens/creditos.png");
        regras = new Imagem(0,0,"src/Imagens/regrasA.png");
        selecao2 = new Imagem(0,0,"src/Imagens/selecao2.png");
        valente = new Imagem((DeliveryManiaV1.janela.getWidth()/2) - 600,(DeliveryManiaV1.janela.getHeight()/2) - 250,"src/Imagens/valente.png");
        ousado = new Imagem((int)valente.x + 440, (int)valente.y,"src/Imagens/ousado.png");
        heroi = new Imagem((int)ousado.x + 440,(int)valente.y,"src/Imagens/heroi.png");
        acidente = new Imagem((int)valente.x,(int)valente.y + 170,"src/Imagens/acidente.png");
        cachorro = new Imagem((int)valente.x,(int)acidente.y + 170,"src/Imagens/cachorro.png");
        pressa = new Imagem((int)ousado.x,(int)ousado.y + 170,"src/Imagens/pressa.png");
        jeremias = new Imagem((int)heroi.x,(int)heroi.y + 170,"src/Imagens/jeremias.png");
        ninja = new Imagem((int)pressa.x,(int)pressa.y + 170,"src/Imagens/ninja.png");
        ghost = new Imagem((int)jeremias.x,(int)jeremias.y + 170,"src/Imagens/ghost.png");
        trofeu = new Imagem((int)valente.x - 90,(int)valente.y - 45,"src/Imagens/trofeu.png");
        trofeu2 = new Imagem((int)ousado.x - 90,(int)ousado.y - 45,"src/Imagens/trofeu.png");
        trofeu3 = new Imagem((int)heroi.x - 90,(int)heroi.y - 45,"src/Imagens/trofeu.png");
        trofeu4 = new Imagem((int)acidente.x - 90,(int)acidente.y - 45,"src/Imagens/trofeu.png");
        trofeu5 = new Imagem((int)pressa.x - 90,(int)pressa.y - 45,"src/Imagens/trofeu.png");
        trofeu6 = new Imagem((int)jeremias.x - 90,(int)jeremias.y - 45,"src/Imagens/trofeu.png");
        trofeu7 = new Imagem((int)cachorro.x - 90,(int)cachorro.y - 45,"src/Imagens/trofeu.png");
        trofeu8 = new Imagem((int)ninja.x - 90,(int)ninja.y - 45,"src/Imagens/trofeu.png");
        trofeu9 = new Imagem((int)ghost.x - 90,(int)ghost.y - 45,"src/Imagens/trofeu.png");

        velocidadeX = 0.8;
        velocidadeY = 0.4;
        estado = "Titulo";
        
        //alarme = new Sound("src/Musicas/alarme2.wav");
        //alarme.decreaseVolume(5);

        selecaoBotao = new Sound("src/Musicas/selcaoBotao.wav");
        selecaoBotao.setVolume(1);
        selecaoBotao.setRepeat(false);
        
        
                field.setAlignmentX(0);
                field.setAlignmentY(15);
                field.setSize(50,15);
        
        
    }

    /*
    movimento o jogador na direcao x e y e troca o sprite
    */
    public void movimento(){
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.RIGHT_KEY)){
            this.setSequence(7, 8);
            this.x += velocidadeX;
            this.y += velocidadeY;
            movendo = true;
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.LEFT_KEY)){
            this.setSequence(3, 4);
            this.x -= velocidadeX;
            this.y -= velocidadeY;
            movendo = true;
            
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.DOWN_KEY)){
            this.setSequence(1, 2);
            this.x -= velocidadeX;
            this.y += velocidadeY;
            movendo = true;
        }
        if( DeliveryManiaV1.teclado.keyDown(Keyboard.UP_KEY)){
            this.setSequence(5, 6);
            this.x += velocidadeX;
            this.y -= velocidadeY;
            movendo = true;
        }

    }

    public void mover(){
        moveX(.6);
        moveY(.6);
    }
    
    @Override
    public void run() { 
        /*
        pinta as respectivas telas do jogo de acordo com o estado
        */
        while(true){
            //pinta o menu principal
            if(estado.equals("Titulo")){
                titulo.draw();
                if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY)){
                    estado = "Menu";
                }
            }
            if(estado.equals("Menu")){
               DeliveryManiaV1.janela.add(field);
               fundo.draw();
               
               botaoJogar.draw();
               botaoCreditos.draw();
               botaoConquistas.draw();
               botaoSair.draw();
               selecao.draw();
               
               this.movimentaMenu();
               this.escolheMenu();
            }
            
            if(estado.equals("Creditos")){
                creditos.draw();
                botaoVoltar.draw();
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                selecao.draw();
                this.retornaMenu();
            }
            
            if(estado.equals("Conquista")){  
                fundoConquista.draw();
                valente.draw();
                ousado.draw();
                heroi.draw();
                acidente.draw();
                cachorro.draw();
                pressa.draw();
                jeremias.draw();
                ninja.draw();
                ghost.draw();
                selecao2.draw();
                this.pintaCaixaTexto();
                this.pintaTrofeu();
                botaoRanking.draw();
                botaoVoltar.draw();
                selecao.draw();
                this.moveConquista();
                //this.retornaMenu();
            }
            if(estado.equals("Ranking")){
                
                fundoRanking.draw();
                caixaNomes.draw();
                botaoVoltar.draw();
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                selecao.draw();
                posicaoX = (int)caixaNomes.x +40 ;
                posicaoY = (int)caixaNomes.y + 80 ;
                for(int i = 0; i<5;i++){     
                    DeliveryManiaV1.janela.drawText(SalvaRanking.scores.get(i),posicaoX,posicaoY, Color.BLACK, fonte);
                    posicaoY += 80;
                }
                
                posicaoX = ((int)caixaNomes.x + (int)caixaNomes.width) - 100 ;
                posicaoY = (int)caixaNomes.y + 80 ;
                for(int i = 0; i<5;i++){     
                    DeliveryManiaV1.janela.drawText(" " + SalvaRanking.pontuacao.get(i),posicaoX,posicaoY, Color.BLACK, fonte);
                    posicaoY += 80;
                }
                if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY)){
                    if(selecao.collided(botaoVoltar)){
                        new Sound("src/Musicas/entrega2.wav").play();
                        estado = "Conquista";
                    }
                }
            }
            
            if(estado.equals("Regras")){
                regras.draw();
                botaoJogar2.draw();
                selecao.x = botaoJogar2.x - 5;
                selecao.y = botaoJogar2.y - 5;
                selecao.draw();
                if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY) && selecao.collided(botaoJogar2)){
                    new Sound("src/Musicas/entrega2.wav").play();
                    DeliveryManiaV1.hordaThread = new CriadorHorda();
                    DeliveryManiaV1.tempoThread = new Temporizador();
                    DeliveryManiaV1.entregaThread = new CriadorEntregas();

                    DeliveryManiaV1.player.x = 950;
                    DeliveryManiaV1.player.y = 200;
                    
                    seletorFantasma = 0;
                    for(int i=0;i<DeliveryManiaV1.vetorFantasma.length;i++){
                        DeliveryManiaV1.vetorFantasma[i].ativo = false;
                    }

                    DeliveryManiaV1.hordaThread.start();
                    DeliveryManiaV1.tempoThread.start();
                    DeliveryManiaV1.entregaThread.start();
                    
                    for(int i=0;i<DeliveryManiaV1.vetorConquistas.length;i++){
                        DeliveryManiaV1.vetorConquistas[i] = 0;
                    }

                    estado = "Jogando";
                    som = true;
                }
            }
            
            if(estado.equals("Jogando")){
                fundoGame.draw();
                mapa.draw();
                relogio.draw();
                fundoTempo.draw();
                pizza.draw();
                fundoPizza.draw();
                /*
                muda a cor do contador de tempo
                */            
                if(Temporizador.contagem >= 30){
                    cor = Color.green;
                }
                if(Temporizador.contagem >= 15 && Temporizador.contagem < 30 ){
                    cor = Color.yellow;
                }
                if(Temporizador.contagem < 15){
                    
                    if(som){
                       new Sound("src/Musicas/alarme2.wav").play(); 
                       som = false;
                    }
                    
                    cor = Color.red;
                }
                
                DeliveryManiaV1.janela.drawText("" + Temporizador.contagem, 1515, 45,cor, fonte);
                DeliveryManiaV1.janela.drawText("" + CriadorEntregas.entrega, 1790, 45, Color.RED, fonte);
                this.draw();
                if(movendo){
                    this.update();
                    movendo = false;
                }
                //this.mover();
                this.liberaMovimento();
                this.sairJogo();
                this.criaFantasma();
                this.verificaGameOver();
                
                //DeliveryManiaV1.janela.drawText("X" + (int)DeliveryManiaV1.player.x, 500, 500, Color.RED, fonte);
                //DeliveryManiaV1.janela.drawText("Y" + (int)DeliveryManiaV1.player.y, 500, 550, Color.RED, fonte);
                //DeliveryManiaV1.janela.drawText("Atropelamentos" + CriadorHorda.atropelamentos, 500, 600, Color.RED, fonte); 

              for(int i=0;i<DeliveryManiaV1.vetorFantasma.length;i++){
                  if(DeliveryManiaV1.vetorFantasma[i].ativo){
                        DeliveryManiaV1.vetorFantasma[i].draw();
                  }
              }
                
            }
            
            if(estado.equals("GameOver")){
                
                telaGameover.draw();
                caixaTexto.draw();
                this.setaConquista();
                DeliveryManiaV1.janela.drawText("Pizzas Entregues: " + CriadorEntregas.entrega, (int)caixaTexto.x + 100, (int)caixaTexto.y + 70,Color.BLACK, fonte);
                if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY)){
                    DeliveryManiaV1.musicaThread = new Musica();
                    DeliveryManiaV1.musicaThread.start();
                    String texto = "";
                    texto = JOptionPane.showInputDialog("Digite seu nome");
                    SalvaRanking.scores.add(texto);
                    SalvaRanking.pontuacao.add(CriadorEntregas.entrega);

                    DeliveryManiaV1.ranking.organizaRanking();
                    
                        try {
                            DeliveryManiaV1.ranking.gravaArquivo("src/Save/save.txt");
                           // DeliveryManiaV1.ranking.gravaArquivo2("src/Save/ranking.txt");
                        } catch (IOException ex) {
                            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    estado = "Menu"; 
     
                }
            }
            
            
            DeliveryManiaV1.janela.update(); 
        }
    }
 /*
    verifica quais conquistas foram alcancadas pelo jogador
    e indica com um trofeu
    */   
    public void pintaTrofeu(){
        if(DeliveryManiaV1.vetorTrofeu[0].equals("Valente")){
            trofeu.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[1].equals("Ousado")){
            trofeu2.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[2].equals("Heroi")){
            trofeu3.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[3].equals("Acidente")){
            trofeu4.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[4].equals("Pressa")){
            trofeu5.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[5].equals("Jeremias")){
            trofeu6.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[6].equals("Cachorro")){
            trofeu7.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[7].equals("Ninja")){
            trofeu8.draw();
        }
        if(DeliveryManiaV1.vetorTrofeu[8].equals("Ghost")){
            trofeu9.draw();
        }
        
    }
  /*
    pinta as descricoes de cada conquista
    */  
    public void pintaCaixaTexto(){
        if(selecao2.collided(valente)){
                   caixaValente.draw();  
                }
                if(selecao2.collided(ousado)){
                    caixaOusado.draw();
                }
                if(selecao2.collided(heroi)){
                   caixaHeroi.draw();  
                }
                if(selecao2.collided(acidente)){
                   caixaAcidente.draw();  
                }
                if(selecao2.collided(pressa)){
                   caixaPressa.draw();  
                }
                if(selecao2.collided(jeremias)){
                   caixaJeremias.draw();  
                }
                if(selecao2.collided(cachorro)){
                   caixaCachorro.draw();  
                }
                if(selecao2.collided(ghost)){
                   caixaGhost.draw();  
                }
                if(selecao2.collided(ninja)){
                   caixaNinja.draw();  
                }
                if(selecao.collided(botaoVoltar)){
                    caixaTexto.draw();
                }
                if(selecao.collided(botaoRanking)){
                    caixaTexto.draw();
                }
        
    }
  /*
    verifica se a condicao da conquista foi alcancada pelo jogador e 
    salva no vetor para ser gravado em txt
    */  
    public void setaConquista(){
        if((DeliveryManiaV1.vetorConquistas[2] > 9 ) && (DeliveryManiaV1.vetorConquistas[2] < 17)){ //10
            DeliveryManiaV1.vetorTrofeu[0] = "Valente";
        }
        if((DeliveryManiaV1.vetorConquistas[2] > 16 ) && (DeliveryManiaV1.vetorConquistas[2] < 24)){    //17
            DeliveryManiaV1.vetorTrofeu[0] = "Valente";
            DeliveryManiaV1.vetorTrofeu[1] = "Ousado";
        }
        if(DeliveryManiaV1.vetorConquistas[2] > 24){
            DeliveryManiaV1.vetorTrofeu[0] = "Valente";
            DeliveryManiaV1.vetorTrofeu[1] = "Ousado";
            DeliveryManiaV1.vetorTrofeu[2] = "Heroi";
        }
        if(DeliveryManiaV1.vetorConquistas[1] > 5 && DeliveryManiaV1.vetorConquistas[1] < 10){
            DeliveryManiaV1.vetorTrofeu[3] = "Acidente";
        }
        if(DeliveryManiaV1.vetorConquistas[1] > 9 && DeliveryManiaV1.vetorConquistas[1] < 15){
            DeliveryManiaV1.vetorTrofeu[3] = "Acidente";
            DeliveryManiaV1.vetorTrofeu[4] = "Pressa";
        }
        if(DeliveryManiaV1.vetorConquistas[1] > 14){
            DeliveryManiaV1.vetorTrofeu[3] = "Acidente";
            DeliveryManiaV1.vetorTrofeu[4] = "Pressa";
            DeliveryManiaV1.vetorTrofeu[5] = "Jeremias";
        }
        if(DeliveryManiaV1.vetorConquistas[3] > 6){
            DeliveryManiaV1.vetorTrofeu[6] = "Cachorro";
        }
        if(DeliveryManiaV1.vetorConquistas[5] >= 2){
            DeliveryManiaV1.vetorTrofeu[8] = "Ghost";
        }
        if(DeliveryManiaV1.vetorConquistas[4] >= 110){
            DeliveryManiaV1.vetorTrofeu[7] = "Ninja";
        }
        
    }
  
    /*
    movimenta o cursor na tela de menu principal 
    */
    public void movimentaMenu(){
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.DOWN_KEY)){    
           selecao.x = botaoSair.x -5;
           selecao.y = botaoSair.y -5; 
           new Sound("src/Musicas/selcaoBotao.wav").play();
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.UP_KEY)){
            selecao.x = botaoJogar.x -5;
            selecao.y = botaoJogar.y -5; 
            new Sound("src/Musicas/selcaoBotao.wav").play();
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.LEFT_KEY)){
            selecao.x = botaoCreditos.x -5;
            selecao.y = botaoCreditos.y -5;
            new Sound("src/Musicas/selcaoBotao.wav").play();
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.RIGHT_KEY)){
            selecao.x = botaoConquistas.x - 5;
            selecao.y = botaoConquistas.y -5;
            new Sound("src/Musicas/selcaoBotao.wav").play();
        }
    }
 /*
    seleciona as opcoes do menu principal
    */   
    public void escolheMenu(){
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY) && estado.equals("Menu")){
            if(selecao.collided(botaoJogar)){
                new Sound("src/Musicas/entrega2.wav").play();
                estado = "Regras";
            }
            if(selecao.collided(botaoCreditos) && estado.equals("Menu")){
                new Sound("src/Musicas/entrega2.wav").play();
                estado = "Creditos";
            }
            if(selecao.collided(botaoConquistas) && estado.equals("Menu")){
                new Sound("src/Musicas/entrega2.wav").play();
                selecao2.x = valente.x - 5;
                selecao2.y = valente.y - 5;
                selecao.x = 0;
                selecao.y = 0;
                selecao.hide();
                selecao2.unhide();
                estado = "Conquista";
            }
            if(selecao.collided(botaoSair) && estado.equals("Menu")){
                new Sound("src/Musicas/entrega2.wav").play();
                DeliveryManiaV1.janela.exit();
            }   
        }
        
    }
  /*
    retorna para o menu principal
    */  
    public void retornaMenu(){
        
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY) && selecao.collided(botaoVoltar)){
            selecao.x = botaoJogar.x-5;
            selecao.y = botaoJogar.y-5;
            new Sound("src/Musicas/entrega2.wav").play();
            estado = "Menu";
        }
    }
    /*
    verifica se o hitbox do jogador esta colidindo com a parte andaveldo mapa,
    se for verdade, libera o movimento
    */
    public void liberaMovimento(){
        hitPlayer.x = this.x + (this.width/2) - 5;
                hitPlayer.y = this.y + (this.height/2) - 10;
                if(colisao(hitPlayer)){
                    posicaoAntigaX = (int)this.x;
                    posicaoAntigaY = (int)this.y;
                   this.movimento();
                }else if(colisao(hitPlayer) == false){
                    this.x = posicaoAntigaX;
                    this.y = posicaoAntigaY;
                }

    }
   /*
    para as threads que sao criadas para o game play e retorna para o menu
    principal do jogo
    */ 
    public void sairJogo(){
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.ESCAPE_KEY) && estado.equals("Jogando")){
            DeliveryManiaV1.hordaThread.stop();
            DeliveryManiaV1.hordaThread.interrupt();
            DeliveryManiaV1.tempoThread.stop();
            DeliveryManiaV1.tempoThread.interrupt();
            DeliveryManiaV1.entregaThread.stop();
            DeliveryManiaV1.entregaThread.interrupt();
            for(int i=0;i<DeliveryManiaV1.vetorFantasma.length;i++){
                if(DeliveryManiaV1.vetorFantasma[i].ativo){
                    DeliveryManiaV1.vetorThread[i].stop();
                    DeliveryManiaV1.vetorThread[i].interrupt();
                }
            }
            selecao.x = botaoJogar.x-5;
            selecao.y = botaoJogar.y+70;
            estado = "Menu";
        }
    }
/*
 verifica se o tempo de jogo acabou, 
 se tempo de jogo acabaou para as threds que estao rodando
 e muda o estado do jogo para gameover
*/
    public void verificaGameOver(){
         
        if(Temporizador.contagem <=0){  
            DeliveryManiaV1.hordaThread.stop();
            DeliveryManiaV1.hordaThread.interrupt();
            DeliveryManiaV1.tempoThread.stop();
            DeliveryManiaV1.tempoThread.interrupt();
            DeliveryManiaV1.entregaThread.stop();
            DeliveryManiaV1.entregaThread.interrupt();

            for(int i=0;i<DeliveryManiaV1.vetorFantasma.length;i++){
                if(DeliveryManiaV1.vetorFantasma[i].ativo){
                    DeliveryManiaV1.vetorThread[i].stop();
                    DeliveryManiaV1.vetorThread[i].interrupt();
                }
            }
            selecao.x = botaoJogar.x-5;
            selecao.y = botaoJogar.y+70;
            //tocaMusica = true;
            Musica.bgm.pause();
            DeliveryManiaV1.musicaThread.stop();
            new Sound("src/Musicas/gameover3.wav").play();
            estado = "GameOver";
        }
    }
 /*
    verifica a quantidade de atropelamentos, e cria um objeto do tipo fantasma
    na posicao especifica do vetor, e da start na thread
    */   
    public void criaFantasma(){
        Random gerador = new Random();
        int tempoFantasma;
        if(CriadorHorda.atropelamentos >=5){
            DeliveryManiaV1.vetorConquistas[5]++;
            tempoFantasma = gerador.nextInt(2);
            switch(tempoFantasma){
                case 0:
                    tempoFantasma = 25;
                    break;
                case 1:
                    tempoFantasma = 30;
                    break;
                case 2:
                    tempoFantasma = 35;
                    break;
            }
            DeliveryManiaV1.vetorFantasma[seletorFantasma] = new Fantasma(tempoFantasma);
            DeliveryManiaV1.vetorThread[seletorFantasma] = new Thread(DeliveryManiaV1.vetorFantasma[seletorFantasma]);
            DeliveryManiaV1.vetorThread[seletorFantasma].start();
            new Sound("src/Musicas/risada.wav").play();
            CriadorHorda.atropelamentos = 0;
            seletorFantasma++;
            if(seletorFantasma>5){
                seletorFantasma = 0;
            }
        }
    }
 /*
    movimento o cursor na tela de conquistas
    */   
    public void moveConquista(){
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.ENTER_KEY)){
            if(selecao.collided(botaoRanking)){
                new Sound("src/Musicas/entrega2.wav").play();
                estado = "Ranking";
            }
            if(selecao.collided(botaoVoltar)){
                selecao.x = botaoJogar.x-5;
                selecao.y = botaoJogar.y-5;
                new Sound("src/Musicas/entrega2.wav").play();
                estado = "Menu";
            }
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if(selecao2.collided(valente) && tecla){
                selecao2.x = ousado.x - 5;
                selecao2.y = ousado.y - 5;
                tecla = false;
            }
            if(selecao2.collided(ousado) && tecla){
                selecao2.x = heroi.x - 5;
                selecao2.y = heroi.y - 5;
                tecla = false;
            }
            if(selecao2.collided(acidente) && tecla){
                selecao2.x = pressa.x - 5;
                selecao2.y = pressa.y - 5;
                tecla = false;
            }
            if(selecao2.collided(pressa) && tecla){
                selecao2.x = jeremias.x - 5;
                selecao2.y = jeremias.y - 5;
                tecla = false;
            }
            if(selecao2.collided(cachorro) && tecla){
                selecao2.x = ninja.x - 5;
                selecao2.y = ninja.y - 5;
                tecla = false;
            }
            if(selecao2.collided(ninja) && tecla){
                selecao2.x = ghost.x - 5;
                selecao2.y = ghost.y - 5;
                tecla = false;
            }
            if(selecao2.collided(heroi) && tecla){
                selecao2.hide();
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                new Sound("src/Musicas/selcaoBotao.wav").play();
                selecao.unhide();
                tecla = false;
            }
            if(selecao2.collided(jeremias) && tecla){
                selecao2.hide();
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                new Sound("src/Musicas/selcaoBotao.wav").play();
                selecao.unhide();
                tecla = false;
            }
            if(selecao2.collided(ghost) && tecla){
                selecao2.hide();
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                selecao.unhide();
                new Sound("src/Musicas/selcaoBotao.wav").play();
                tecla = false;
            }
            if(!DeliveryManiaV1.teclado.keyDown(Keyboard.RIGHT_KEY)){
                tecla = true;
            }
        }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.DOWN_KEY)) {
            if(selecao.collided(botaoRanking)){
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                new Sound("src/Musicas/selcaoBotao.wav").play();
                tecla = false;
            }
            if(selecao2.collided(valente) && tecla){
                selecao2.x = acidente.x - 5;
                selecao2.y = acidente.y - 5;
                tecla = false;
            }
            if(selecao2.collided(acidente) && tecla){
                selecao2.x = cachorro.x - 5;
                selecao2.y = cachorro.y - 5;
                tecla = false;
            }
            if(selecao2.collided(ousado) && tecla){
                selecao2.x = pressa.x - 5;
                selecao2.y = pressa.y - 5;
                tecla = false;
            }
            if(selecao2.collided(pressa) && tecla){
                selecao2.x = ninja.x - 5;
                selecao2.y = ninja.y - 5;
                tecla = false;
            }
            if(selecao2.collided(heroi) && tecla){
                selecao2.x = jeremias.x - 5;
                selecao2.y = jeremias.y - 5;
                tecla = false;
            }
            if(selecao2.collided(jeremias) && tecla){
                selecao2.x = ghost.x - 5;
                selecao2.y = ghost.y - 5;
                tecla = false;
            }
            if(selecao2.collided(ghost) && tecla){
                selecao2.hide();
                selecao.unhide();
                selecao.x = botaoVoltar.x - 5;
                selecao.y = botaoVoltar.y - 5;
                new Sound("src/Musicas/selcaoBotao.wav").play();
                tecla = false;
            }
            
            if(!DeliveryManiaV1.teclado.keyDown(Keyboard.DOWN_KEY)){
                tecla = true;
            }
        }
         if(DeliveryManiaV1.teclado.keyDown(Keyboard.LEFT_KEY)) {
             if(selecao.collided(botaoVoltar) || selecao.collided(botaoRanking) && tecla){
                selecao2.unhide();
                selecao2.x = ghost.x - 5;
                selecao2.y = ghost.y - 5;
                selecao.x = 0;
                selecao.y = 0;
                selecao.hide();
                tecla = false;
            }
            else{
                if(selecao2.collided(heroi) && tecla){
                selecao2.x = ousado.x - 5;
                selecao2.y = ousado.y - 5;
                tecla = false;
                }
            if(selecao2.collided(ousado) && tecla){
                selecao2.x = valente.x - 5;
                selecao2.y = valente.y - 5;
                tecla = false;
                }
            if(selecao2.collided(jeremias) && tecla){
                selecao2.x = pressa.x - 5;
                selecao2.y = pressa.y - 5;
                tecla = false;
                }
            if(selecao2.collided(pressa) && tecla){
                selecao2.x = acidente.x - 5;
                selecao2.y = acidente.y - 5;
                tecla = false;
                }
            if(selecao2.collided(ghost) && tecla){
                selecao2.x = ninja.x - 5;
                selecao2.y = ninja.y - 5;
                tecla = false;
                }
            if(selecao2.collided(ninja) && tecla){
                selecao2.x = cachorro.x - 5;
                selecao2.y = cachorro.y - 5;
                tecla = false;
                }
             }
            if(!DeliveryManiaV1.teclado.keyDown(Keyboard.LEFT_KEY)){
                tecla = true;
            }
      
         }
        if(DeliveryManiaV1.teclado.keyDown(Keyboard.UP_KEY)) {
            if(selecao.collided(botaoVoltar)){             
                selecao.x = botaoRanking.x - 5;
                selecao.y = botaoRanking.y - 5;
                new Sound("src/Musicas/selcaoBotao.wav").play();
                tecla = false;
            }
            if(selecao.collided(botaoRanking) && tecla){
                selecao2.x = ghost.x - 5;
                selecao2.y = ghost.y - 5;
                selecao.x = 0;
                selecao.y = 0;
                selecao2.unhide();
                selecao.hide();
                tecla = false;
            }
            else{
                if(selecao2.collided(cachorro) && tecla){
                selecao2.x = acidente.x - 5;
                selecao2.y = acidente.y - 5;
                tecla = false;
                }
            if(selecao2.collided(acidente) && tecla){
                selecao2.x = valente.x - 5;
                selecao2.y = valente.y - 5;
                tecla = false;
                }
            if(selecao2.collided(ninja) && tecla){
                selecao2.x = pressa.x - 5;
                selecao2.y = pressa.y - 5;
                tecla = false;
                }
            if(selecao2.collided(pressa) && tecla){
                selecao2.x = ousado.x - 5;
                selecao2.y = ousado.y - 5;
                tecla = false;
                }
            if(selecao2.collided(ghost) && tecla){
                selecao2.x = jeremias.x - 5;
                selecao2.y = jeremias.y - 5;
                tecla = false;
                }
            if(selecao2.collided(jeremias) && tecla){
                selecao2.x = heroi.x - 5;
                selecao2.y = heroi.y - 5;
                tecla = false;
                }
            }

            if(!DeliveryManiaV1.teclado.keyDown(Keyboard.UP_KEY)){
            tecla = true;
            }
        }

    }
/*
    cria uma matriz de rects onde é permitido o jogador se mover,
    quando o jogador colide com esses rects o movimeto é liberado.
    */
    public boolean colisao(Imagem jogador){
        int x = 950;
        int y = 200;
        
        int posX = 0;
        int posY = 0;
        
        Imagem andavel = new Imagem(x,y,"src/Imagens/vazio.png");
        andavel.height = 12;
        andavel.width = 12;
        
        for(int i = 0;i<6;i++){
            posX = x;
            posY = y;
            for(int j = 0;j<55;j++){
                andavel.x = x;
                andavel.y = y;
                if(jogador.collided(andavel)){
                    return true;
                }
            x += 12;
            y += 6;   
            }
            x = posX;
            y = posY;
            x -= 130;
            y += 65;
            
        }
        
        x = 950;
        y = 200;
        for(int i = 0;i<6;i++){
            posX = x;
            posY = y;
            for(int j = 0;j<55;j++){
                andavel.x = x;
                andavel.y = y;
                if(jogador.collided(andavel)){
                    return true;
                }
            x -= 12;
            y += 6;   
            }
            x = posX;
            y = posY;
            x += 130;
            y += 65;
            
        }
    
        return false;
    }
   
}

