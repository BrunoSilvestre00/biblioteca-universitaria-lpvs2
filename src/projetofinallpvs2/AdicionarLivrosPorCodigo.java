/*
 * Essa Classe foi usada somente para praticidade durante os testes do programa.
 * Seus métodos não seriam usados no projeto final.
 * Para utiliza-la basta somente declarar um objeto dessa classe no construtor da Janela Principal e passar o Gerenciador de Obras como parâmetro.
 * As outras funcionalidade do programa , como Insere Obra, funcionam normalmente mesmo com a utilização dessa classe
 *
 * PS: Decidi deixar ela aqui porque as vezes é meio chato ficar adicionando os objetos toda vez que entrar no programa.
 */
package projetofinallpvs2;

/**
 *
 * @author Bruno Silvestre
 */
public class AdicionarLivrosPorCodigo {
    
    
    public AdicionarLivrosPorCodigo(GerenciadorObras gerenciador){
        Obra ol1 = new Obra("Livro", "LIVRO 1", "Autor 1.1.1", "Autor 1.2.1", 2020, 01);
        Obra ol2 = new Obra("Livro", "LIVRO 2", "Autor 2.1.1", "Autor 2.2.1", 2005, 60);
        Obra ol3 = new Obra("Livro", "LIVRO 3", "Autor 3.1.1", "Autor 3.2.1", 2000, 10);
        Obra ol4 = new Obra("Livro", "LIVRO 4", "Autor 4.1.1", "Autor 4.2.1", 2002, 15);
        Obra ol5 = new Obra("Livro", "LIVRO 5", "Autor 5.1.1", "Autor 5.2.1", 2010, 80);
        
        Obra ot1 = new Obra("Trabalho Acadêmico", "TRABALHO 1", "Autor 1.1.2", "Autor 1.2.2", 2017, 50);
        Obra ot2 = new Obra("Trabalho Acadêmico", "TRABALHO 2", "Autor 2.1.2", "Autor 2.2.2", 2006, 60);
        Obra ot3 = new Obra("Trabalho Acadêmico", "TRABALHO 3", "Autor 3.1.2", "Autor 3.2.2", 2001, 10);
        Obra ot4 = new Obra("Trabalho Acadêmico", "TRABALHO 4", "Autor 4.1.2", "Autor 4.2.2", 1999, 15);
        Obra ot5 = new Obra("Trabalho Acadêmico", "TRABALHO 5", "Autor 5.1.2", "Autor 5.2.2", 1978, 80);
        
        Obra or1 = new Obra("Revista", "REVISTA 1", "Autor 1.1.3", "Autor 1.2.3", 2018, 10);
        Obra or2 = new Obra("Revista", "REVISTA 2", "Autor 2.1.3", "Autor 2.2.3", 2019, 18);
        Obra or3 = new Obra("Revista", "REVISTA 3", "Autor 3.1.3", "Autor 3.2.3", 2020, 14);
        Obra or4 = new Obra("Revista", "REVISTA 4", "Autor 4.1.3", "Autor 4.2.3", 2021, 16);
        Obra or5 = new Obra("Revista", "REVISTA 5", "Autor 5.1.3", "Autor 5.2.3", 2020, 17);
        
        Obra ol6 = new Obra("Livro", "JAVA: COMO PROGRAMAR", "Paul Deitel", "Harvey Deitel", 2016, 05);
        Obra ol7 = new Obra("Livro", "TEORIA DAS MÍDIAS DIGITAIS", "Luis Mauro Sá Martino", "", 2014, 10);
        Obra ol8 = new Obra("Livro", "CIÊNCIA E PSEUDOCIÊNCIA", "Ronaldo Pilati", "", 2018, 40);
        
        Obra ot6 = new Obra("Trabalho Acadêmico", "TCC ALUNO 2021 - IFSP", "AQXXXXXXX", "", 2021, 1);
        Obra ot7 = new Obra("Trabalho Acadêmico", "O ENSINO DO SPIN", "Marcos Paulo Belançon", "", 2018, 1);

        
        Obra or6 = new Obra("Revista", "VEJA", "Editorial VEJA", "", 2021, 10);
        Obra or7 = new Obra("Revista", "FORBES", "Editorial Forbes", "", 2020, 8);

        
        gerenciador.push(ol1);
        gerenciador.push(ol2);
        gerenciador.push(ol3);
        gerenciador.push(ol4);
        gerenciador.push(ol5);
        
        gerenciador.push(ot1);
        gerenciador.push(ot2);
        gerenciador.push(ot3);
        gerenciador.push(ot4);
        gerenciador.push(ot5);
        
        gerenciador.push(or1);
        gerenciador.push(or2);
        gerenciador.push(or3);
        gerenciador.push(or4);
        gerenciador.push(or5);
        
        gerenciador.push(ol6);
        gerenciador.push(ol7);
        gerenciador.push(ol8);
        
        gerenciador.push(ot6);
        gerenciador.push(ot7);
        
        gerenciador.push(or6);
        gerenciador.push(or7);
    }
    
}
