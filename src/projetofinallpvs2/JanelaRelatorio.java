package projetofinallpvs2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Bruno Silvestre
 */
public class JanelaRelatorio extends JFrame{
    
    private JTabbedPane controleAbas;
    private JPanel abaCadastrados;
    private JPanel abaEmprestimos;
    
    private DefaultTableModel modelo1;
    private DefaultTableModel modelo2;
    
    private JTable tabelaCadastrados;
    private JTable tabelaEmprestimos;
    
    private JScrollPane scroll1;
    private JScrollPane scroll2;

    private GerenciadorObras gerenciadorO;
    private GerenciadorEmprestimos gerenciadorE;
    
    public JanelaRelatorio(GerenciadorObras gerenciador1, GerenciadorEmprestimos gerenciador2) {
        this.gerenciadorO = gerenciador1;
        this.gerenciadorE = gerenciador2;
        
        criarComponentes();
        ajustarJanela();
    }
    
    private void criarTabelaCadastrados(){
        
        tabelaCadastrados = new JTable(modelo1);
        
        modelo1.addColumn("Tipo");
        modelo1.addColumn("Titulo");
        modelo1.addColumn("Autor 1");
        modelo1.addColumn("Autor 2");
        modelo1.addColumn("Ano");
        modelo1.addColumn("Quantidade");
        
        tabelaCadastrados.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabelaCadastrados.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabelaCadastrados.getColumnModel().getColumn(2).setPreferredWidth(220);
        tabelaCadastrados.getColumnModel().getColumn(3).setPreferredWidth(220);
        tabelaCadastrados.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabelaCadastrados.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        tabelaCadastrados.setRowHeight(50);
        tabelaCadastrados.setEnabled(false);

        gerenciadorO.getObras().forEach(c -> {
            modelo1.addRow(new Object[]{
                c.getTipo(),
                c.getTitulo(),
                c.getAutor1(),
                c.getAutor2(),
                c.getAno(),
                c.getQtd()
            });
        });
    }
    
    private void criarTabelaEmprestimos(){
        
        tabelaEmprestimos = new JTable(modelo2);
        
        modelo2.addColumn("Código");
        modelo2.addColumn("Título da Obra");
        modelo2.addColumn("Data Empréstimo");
        modelo2.addColumn("Data Entrega");
        modelo2.addColumn("Estado");
        
        tabelaEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(400);
        tabelaEmprestimos.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabelaEmprestimos.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabelaEmprestimos.getColumnModel().getColumn(4).setPreferredWidth(80);
 
        tabelaEmprestimos.setRowHeight(50);
        tabelaEmprestimos.setEnabled(false);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        gerenciadorE.getEmprestimos().forEach(c -> {
            if(c.getDevolvido()){
                modelo2.addRow(new Object[]{
                    c.getCodigo(),
                    c.getObra(),
                    dateFormat.format(c.getDataEmprestimo()),
                    dateFormat.format(c.getDataDevolucao()),
                    "Devolvido"
                });
            }else{
                modelo2.addRow(new Object[]{
                    c.getCodigo(),
                    c.getObra(),
                    dateFormat.format(c.getDataEmprestimo()),
                    dateFormat.format(c.getDataDevolucao()),
                    "Não Devolvido"
                });
            }   
        });
    }
    
    private void criarComponentes() {
        
        controleAbas = new JTabbedPane();
        abaCadastrados = new JPanel(new BorderLayout());
        abaEmprestimos = new JPanel(new BorderLayout());
        
        modelo1 = new DefaultTableModel(); 
        criarTabelaCadastrados();
        
        modelo2 = new DefaultTableModel(); 
        criarTabelaEmprestimos();
        
        scroll1 = new JScrollPane(tabelaCadastrados);
        scroll2 = new JScrollPane(tabelaEmprestimos);
        
        ajustarComponentes();
        adicionarComponentes();
    }
    
    private void ajustarComponentes(){
        abaCadastrados.setBackground(new Color(50, 50, 50));
        abaEmprestimos.setBackground(new Color(50, 50, 50));
        
        JTableHeader tabelaHeader1 = tabelaCadastrados.getTableHeader();
        tabelaHeader1.setBackground(new Color(30, 30, 30));
        tabelaHeader1.setFont(new Font("Tahoma", 1, 20));
        tabelaHeader1.setForeground(new Color(255, 255, 255));
        
        JTableHeader tabelaHeader2 = tabelaEmprestimos.getTableHeader();
        tabelaHeader2.setBackground(new Color(30, 30, 30));
        tabelaHeader2.setFont(new Font("Tahoma", 1, 20));
        tabelaHeader2.setForeground(new Color(255, 255, 255));
        
        tabelaCadastrados.setBackground(new Color(50, 50, 50));
        tabelaCadastrados.setFont(new Font("Tahoma", 0, 20));
        tabelaCadastrados.setForeground(new Color(255, 255, 255));
        
        tabelaEmprestimos.setBackground(new Color(50, 50, 50));
        tabelaEmprestimos.setFont(new Font("Tahoma", 0, 20));
        tabelaEmprestimos.setForeground(new Color(255, 255, 255));
        
        controleAbas.setBackground(new Color(50, 50, 50));
        controleAbas.setFont(new Font("Tahoma", 0, 20));
        controleAbas.setForeground(new Color(255, 255, 255));
    }
    
    private void adicionarComponentes() {
        
        abaCadastrados.add(scroll1);
        abaEmprestimos.add(scroll2);
        
        controleAbas.addTab("Obras Cadastradas", abaCadastrados);
        controleAbas.addTab("Empréstimos Realizados", abaEmprestimos);
        add(controleAbas);
    }
    
    private void ajustarJanela() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/Lista.png")).getImage());
        setVisible(true);
        setTitle("Relatórios");
        setSize(1040,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
