package app;

public class App {
    public static void main(String[] args) throws Exception {
    	String path = "C:\\Users\\Lucas\\Downloads\\texto.txt";  // Não sei como transformar o diretório de modo que você também possa acessar
    															 // Usei o txt file do professor
    															
        boolean ascending = true; // Será utilizado quando for criado a lista com as palavras distintas
        
        LSEO<String> lseo = new LSEO<String>(ascending);
        
        					// ERROS ENCONTRADOS:
        lseo.reader(path); // Ele só está lendo metade do arquivo para baixo, como se existisse um limite de palavras
        				   // Não há no texto nenhum caracter especial a não ser o hífen. Ele lê a palavra "prepara-nos" que tem hífen, e não pode 
        
        lseo.findLongestWords();
    
    }
}