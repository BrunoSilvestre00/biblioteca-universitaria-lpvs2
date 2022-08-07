/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinallpvs2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Bruno Silvestre
 */
public class JanelaDevolucao extends JFrame{
    
    private JPanel panelPrincipal;
    private JPanel panel1;
    
    private JTable tabelaEmprestimos;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    
    private JButton btnDevolver;
    
    private GerenciadorEmprestimos gerenciador;
    private GerenciadorObras gerenciador2;
    
    public JanelaDevolucao(GerenciadorEmprestimos gerenciador, GerenciadorObras gerenciador2) {
        this.gerenciador = gerenciador;
        this.gerenciador2 = gerenciador2;
        criarComponentes();
        ajustarJanela();
    }
    
    private void criarTabelaEmprestimos(){
        
        tabelaEmprestimos = new JTable(modelo);
        
        modelo.addColumn("Código");
        modelo.addColumn("Título da Obra");
        modelo.addColumn("Data Empréstimo");
        modelo.addColumn("Data Entrega");
        
        tabelaEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(550);
        tabelaEmprestimos.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabelaEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(80);
 
        tabelaEmprestimos.setRowHeight(50);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        gerenciador.getEmprestimos().forEach(c -> {
            if(!c.getDevolvido()){
                modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getObra(),
                    dateFormat.format(c.getDataEmprestimo()),
                    dateFormat.format(c.getDataDevolucao())
                });
            }     
        });
    }
    
    private void devolver(){
        int linhaSelecionada = -1;
        linhaSelecionada = tabelaEmprestimos.getSelectedRow();
        
        if (linhaSelecionada >= 0) {
            String nome = (String) tabelaEmprestimos.getValueAt(linhaSelecionada, 1);
                
            int i = gerenciador.buscarPeloNomeIndex(nome);
            float multa = gerenciador.getEmprestimos().get(i).calculaMulta();
            int dias = gerenciador.getEmprestimos().get(i).diasMulta();
                
            if(multa == 0){
                JOptionPane.showMessageDialog(null, "Dias de Multa: 0\nValor da Multa: R$ 0.00");
            }else{
                JOptionPane.showMessageDialog(null, String.format("Dias de Multa: %d\nValor da Multa %.2f", dias, multa));
            }

            int j = gerenciador2.buscarPeloNomeIndex(nome);
            gerenciador2.getObras().get(j).addQtd();
            gerenciador.getEmprestimos().get(i).devolver();
                
            modelo.removeRow(linhaSelecionada);
            JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha!");
        }
    }
    
    private void criarComponentes() {
        
        panelPrincipal = new JPanel(new BorderLayout());
        panel1 = new JPanel(new BorderLayout());
        
        modelo = new DefaultTableModel(); 
        criarTabelaEmprestimos();
        scroll = new JScrollPane(tabelaEmprestimos);
        
        btnDevolver = new JButton("Realizar Devolução");
        btnDevolver.addActionListener((e) -> {
            devolver();
        });
        
        adicionarComponentes();
        ajustarComponentes();
    }
    
    private void ajustarComponentes(){
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", 0, 30)));
        
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(30, 30, 30));
        
        JTableHeader tabelaHeader = tabelaEmprestimos.getTableHeader();
        tabelaHeader.setBackground(new Color(30, 30, 30));
        tabelaHeader.setFont(new Font("Tahoma", 1, 20));
        tabelaHeader.setForeground(new Color(255, 255, 255));
        
        tabelaEmprestimos.setBackground(new Color(50, 50, 50));
        tabelaEmprestimos.setFont(new Font("Tahoma", 0, 20));
        tabelaEmprestimos.setForeground(new Color(255, 255, 255));
        
        btnDevolver.setFont(new Font("Tahoma", 0, 30));
        btnDevolver.setForeground(new Color(255, 255, 255));
        btnDevolver.setBackground(new Color(50, 50, 50));
        btnDevolver.setIcon(new ImageIcon(getClass().getResource("/imagens/Devolver.png")));
        
        btnDevolver.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    private void adicionarComponentes() {
        panel1.add(scroll);
        panelPrincipal.add(panel1);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(btnDevolver);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        
        add(panelPrincipal);
    }
    
    private void ajustarJanela() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/Devolver.png")).getImage());
        setVisible(true);
        setTitle("Devolução");
        setSize(1040,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
