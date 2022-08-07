/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinallpvs2;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Bruno Silvestre
 */
public class Emprestimo {
    
    int codigo; //Referente ao pedido. Se um pedido tiver 3 obras, elas terão o mesmo código na tabela.
    String obra;
    String tipo;
    Date dataEmprestimo;
    Date dataDevolucao;
    boolean devolvido;
    
    public Emprestimo(int n, String type, String nome, Date data){
        this.codigo = n;
        this.obra = nome;
        this.tipo = type;
        this.dataEmprestimo = data;
        this.dataDevolucao = calculaDevolucao();
        this.devolvido = false;
    }
    
    public Date calculaDevolucao(){
        
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(dataEmprestimo );
        
        if(this.tipo.equals("Livro"))
            cal.add(Calendar.DATE, 10);
        if(this.tipo.equals("Trabalho Acadêmico"))
            cal.add(Calendar.DATE, 15);
        if(this.tipo.equals("Revista"))
            cal.add(Calendar.DATE, 20);
        
        return cal.getTime();
    }
    
    public int diasMulta(){
        Date hoje = new Date();
        int dias = 0;
        
        LocalDate ldDevolucao = LocalDate.ofInstant(dataDevolucao.toInstant(), ZoneId.systemDefault());
        LocalDate ldHoje = LocalDate.ofInstant(hoje.toInstant(), ZoneId.systemDefault());
        Period periodo;
        
        if(this.dataDevolucao.compareTo(hoje) < 0){
            periodo = Period.between(ldDevolucao, ldHoje);
            dias = periodo.getDays() + periodo.getMonths()*30 + periodo.getYears()*360;
        }
        
        return dias;
    }
    
    public float calculaMulta(){
        float multa = 0;
        Date hoje = new Date();
        int dias = diasMulta();
        
        if(this.tipo.equals("Livro"))
            multa = (float) (2.0*dias);
        if(this.tipo.equals("Trabalho Acadêmico"))
            multa = (float) (0.5*dias);
        if(this.tipo.equals("Revista"))
            multa = (float) (0.3*dias);
        
        return multa;
    }
    
    public void devolver(){
        devolvido = true;
    }
    
    public boolean getDevolvido(){
        return devolvido;
    }

    public int getCodigo(){
        return codigo;
    }
    
    public String getObra() {
        return obra;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    

}
