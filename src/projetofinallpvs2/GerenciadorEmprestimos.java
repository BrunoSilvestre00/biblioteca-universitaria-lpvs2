/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinallpvs2;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Bruno Silvestre
 */
public class GerenciadorEmprestimos {
    
    ArrayList<Emprestimo> emprestimos;
    int qtd;
    
    public GerenciadorEmprestimos(){
        emprestimos = new ArrayList<>();
        qtd = 1;
    }
    
    public void addQtd(){
        this.qtd = this.qtd + 1;
    }
    
    public boolean push(Emprestimo emprestimo){
        return emprestimos.add(emprestimo);
    }
    
    public int getCod(){
        return qtd;
    }
    
    public boolean pull(String nome) {
        Optional<Emprestimo> emprestimo = buscarPeloNome(nome);
        if (emprestimo.isPresent()) {
            emprestimos.remove(emprestimo.get());
            return true;
        }
        return false;
    }
    
    public Optional<Emprestimo> buscarPeloNome(String nome) {
        Emprestimo emprestimo = null;
        for (Emprestimo elemento : emprestimos) {
            if (elemento.getObra() == nome) {
                emprestimo = elemento;
            }
        }
        return Optional.ofNullable(emprestimo);
    }
    
    public int buscarPeloNomeIndex(String nome) {
        int index = 0;
        for (Emprestimo elemento : emprestimos) {
            if (elemento.getObra() == nome) {
                break;
            }
            index++;
        }
        return index;
    }
    
    public ArrayList<Emprestimo> getEmprestimos(){
        return emprestimos;
    }  
}
