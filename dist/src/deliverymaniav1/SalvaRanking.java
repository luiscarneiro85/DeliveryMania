
package deliverymaniav1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SalvaRanking {
    
    
    public static ArrayList<String> scores = new ArrayList<String>();
    public static ArrayList<Integer> pontuacao = new ArrayList<Integer>();

    
    File save = new File("src/Save/save.txt");
    String texto;
    FileReader ler;
    BufferedReader lerb;
    FileWriter escrever;
    BufferedWriter escreverb;
    
    public SalvaRanking() throws IOException{
        pontuacao.add(15);
        pontuacao.add(9);
        pontuacao.add(21);
        pontuacao.add(17);
        pontuacao.add(5);
        
        scores.add("Luis");
        scores.add("Larissa");
        scores.add("Felipe");
        scores.add("Artur");
        scores.add("Luan");
        
        if(save.exists()){
            
        }else{
            save.createNewFile();
            this.gravaArquivo("src/Save/save.txt");
        }
        
    }
/*
    le o arquivo txt com as conquistas e as coloca no vetor
    */
    public void lerArquivo(String path) throws IOException{
        ler = new FileReader(path);
        lerb = new BufferedReader(ler);
        
        int j = 0;
        try {
            while((texto = lerb.readLine()) != null){
                DeliveryManiaV1.vetorTrofeu[j] = texto;
               // System.out.println(texto);
                j++;
            }
        } catch (IOException ex) {
    
        }

    }
    
    public void lerArquivo2(String path) throws IOException{
        ler = new FileReader(path);
        lerb = new BufferedReader(ler);
        int j = 0;
        try {
            while((texto = lerb.readLine()) != null){
                scores.add(texto);
                
            }
        } catch (IOException ex) {
    
        }

    }
    
 /*
    grava o arquivos txt com as conquistas
    */   
    public void gravaArquivo(String path) throws IOException{
        escrever = new FileWriter(path);
        escreverb = new BufferedWriter(escrever);
        try {
            for(int i=0;i<DeliveryManiaV1.vetorTrofeu.length;i++){
                escreverb.write(DeliveryManiaV1.vetorTrofeu[i]);
                escreverb.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(SalvaRanking.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            escreverb.close();
            escrever.close();
        } catch (IOException ex) {
            Logger.getLogger(SalvaRanking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void gravaArquivo2(String path) throws IOException{
        escrever = new FileWriter(path);
        escreverb = new BufferedWriter(escrever);
        try {
            for(String nome : scores){
                escreverb.write(nome);
                escreverb.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(SalvaRanking.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            escreverb.close();
            escrever.close();
        } catch (IOException ex) {
            Logger.getLogger(SalvaRanking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void organizaRanking(){
        int indiceAux = 0;
        String textoAux;
        
        for(int i = 0;i < pontuacao.size();i++){
            for(int j = 0; j < pontuacao.size() - 1;j++){
                if(pontuacao.get(j) < pontuacao.get(j+1))
                {
  
                    indiceAux = pontuacao.get(j+1);
                    pontuacao.set(j+1,pontuacao.get(j));
                    pontuacao.set(j,indiceAux);
                 
                    textoAux = scores.get(j+1);
                    scores.set(j+1, scores.get(j));
                    scores.set(j, textoAux);
                
                }
            }
        }
        
        for(int i = 0;i<5;i++){
           System.out.println(scores.get(i) + "-----" + pontuacao.get(i));
        }
        
    }
}
