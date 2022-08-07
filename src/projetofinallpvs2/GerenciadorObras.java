package projetofinallpvs2;

import java.util.ArrayList;

/**
 *
 * @author Bruno Silvestre
 */
public class GerenciadorObras {
    
    ArrayList<Obra> obras;
    
    public GerenciadorObras(){    
        obras = new ArrayList<>();
    }
    
    public boolean push(Obra obra){
        return obras.add(obra);
    }
    
    public int buscarPeloNomeIndex(String nome) {
        int index = 0;
        for (Obra elemento : obras) {
            if (elemento.getTitulo().equals(nome)) {
                break;
            }
            index++;
        }
        return index;
    }
    
    public ArrayList<Obra> getObras(){
        return obras;
    }
}
