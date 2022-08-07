package projetofinallpvs2;

/**
 *
 * @author Bruno Silvestre
 */
public class Obra {
    
    String tipo;
    String titulo;
    String autor1;
    String autor2;
    int ano;
    int qtd;
    
    public Obra(String type, String title, String a1, String a2, int year, int qtd){
        this.tipo = type;
        this.titulo = title;
        this.autor1 = a1;
        this.autor2 = a2;
        this.ano = year;
        this.qtd = qtd;  
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void minusQtd(){
        this.qtd--;
    }
    
    public void addQtd(){
        this.qtd++;
    }

    public String getTipo() {
        return tipo;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public String getAutor1() {
        return autor1;
    }

    public String getAutor2() {
        return autor2;
    }

    public int getAno() {
        return ano;
    }

    public int getQtd() {
        return qtd;
    }

    @Override
    public String toString() {
            return "Tipo: " + tipo + "\nTítulo: " + titulo + "\nAutor 1: " + autor1 + "\nAutor 2: " + autor2 + "\nAno de publicação: " + ano + "\nQuantidade Disponível: " + qtd;
    }
}
