package gerenciamentopedidos.utils;

public class StringUtils {
    
    public String formatarTexto(String texto){
    StringBuilder sb = new StringBuilder();
    boolean quebraLinha = false;
        for (int i = 0; i < texto.length(); i++) {
            sb.append(texto.charAt(i));
            if(!quebraLinha && i>18 && texto.charAt(i) == ' '){
            sb.append("\n");
            quebraLinha = true;
            continue;    
            }
        }
    
    return sb.toString();
    
    }
    
    
    
    
}
