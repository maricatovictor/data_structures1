package app;

public class App {
    public static void main(String[] args) throws Exception {
    	String path = "C:\\Users\\Lucas\\Downloads\\texto.txt";  // N�o sei como transformar o diret�rio de modo que voc� tamb�m possa acessar
    															 // Usei o txt file do professor
    															
        boolean ascending = true; // Ser� utilizado quando for criado a lista com as palavras distintas
        
        LSEO<String> lseo = new LSEO<String>(ascending);
        
        					// ERROS ENCONTRADOS:
        lseo.reader(path); // Ele s� est� lendo metade do arquivo para baixo, como se existisse um limite de palavras
        				   // N�o h� no texto nenhum caracter especial a n�o ser o h�fen. Ele l� a palavra "prepara-nos" que tem h�fen, e n�o pode 
        
        lseo.findLongestWords();
    
    }
}