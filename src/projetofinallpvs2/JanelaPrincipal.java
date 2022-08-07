package projetofinallpvs2;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Bruno Silvestre
 */
class JanelaPrincipal extends JFrame{
    
    private JPanel panelPrincipal;
    
    private JPanel panelCabecalho;
    private JPanel panelBotoes1;
    private JPanel panelBotoes2;
    
    private JLabel lblCabecalho;
    
    private JButton btnInserir;
    private JButton btnEmprestar;
    private JButton btnDevolver;
    private JButton btnLivros;
    
    private GerenciadorObras gerenciadorO;
    private GerenciadorEmprestimos gerenciadorE;
    
    public JanelaPrincipal() {
        gerenciadorO = new GerenciadorObras();
        gerenciadorE = new GerenciadorEmprestimos();
        
        //Para caso queira adicionar alguns livros automaticamente
        adicionarLivros();
        
        criarComponentes();
        ajustarJanela();
    }
    
    private void adicionarLivros() {
    	for(Obra o : RepositorioObras.getObras()) {
    		gerenciadorO.push(o);
    		System.out.println("Inserido: " + o.getTitulo());
    	}
    }

    private void inserirLivros(){
        JanelaInserir janela = new JanelaInserir(gerenciadorO);
    }
    
    private void relatorioLivros(){
        JanelaRelatorio janela = new JanelaRelatorio(gerenciadorO, gerenciadorE);
    }
    
    private void emprestarLivros(){
        JanelaEmprestimo janela = new JanelaEmprestimo(gerenciadorO, gerenciadorE);
    }
    
    private void devolverLivros(){
        JanelaDevolucao janela = new JanelaDevolucao(gerenciadorE, gerenciadorO);
    }
    
    private void criarComponentes() {
        
        panelPrincipal = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image imagem = new ImageIcon(getClass().getResource("/imagens/backgroud.jpg")).getImage();
                g.drawImage(imagem, 0, 0, this);
            }
        };
        
        panelCabecalho = new JPanel();
        panelBotoes1 = new JPanel();
        panelBotoes2 = new JPanel();
        
        lblCabecalho = new JLabel();
        
        btnInserir = new JButton();
        btnInserir.addActionListener((e) -> {
            inserirLivros();
        });
        
        btnLivros = new JButton();
        btnLivros.addActionListener((e) -> {
            relatorioLivros();
        });
        
        btnEmprestar = new JButton();
        btnEmprestar.addActionListener((e) -> {
            emprestarLivros();
        });
        
        btnDevolver = new JButton();
        btnDevolver.addActionListener((e) -> {
            devolverLivros();
        });
        
        ajustarComponentes();
        adicionarComponentes();
    }
    
    private void ajustarComponentes(){
        
        lblCabecalho.setText("Sistema de Gerenciamento de uma Biblioteca Universitária");
        lblCabecalho.setFont(new Font("Tahoma", 0, 30));
        lblCabecalho.setForeground(new Color(255, 255, 255));
        lblCabecalho.setIcon(new ImageIcon(getClass().getResource("/imagens/Livros.png")));
        
        btnInserir.setText("Inserção de Livros");
        btnInserir.setFont(new Font("Tahoma", 0, 30));
        btnInserir.setForeground(new Color(255, 255, 255));
        btnInserir.setBackground(new Color(50, 50, 50));
        btnInserir.setIcon(new ImageIcon(getClass().getResource("/imagens/Adicionar.png")));
        btnInserir.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnLivros.setText("Gerar Relatório dos Livros");
        btnLivros.setFont(new Font("Tahoma", 0, 30));
        btnLivros.setForeground(new Color(255, 255, 255));
        btnLivros.setBackground(new Color(50, 50, 50));
        btnLivros.setIcon(new ImageIcon(getClass().getResource("/imagens/Lista.png")));
        btnLivros.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnEmprestar.setText("Empréstimo de Livros");
        btnEmprestar.setFont(new Font("Tahoma", 0, 30));
        btnEmprestar.setForeground(new Color(255, 255, 255));
        btnEmprestar.setBackground(new Color(50, 50, 50));
        btnEmprestar.setIcon(new ImageIcon(getClass().getResource("/imagens/Emprestar.png")));
        
        btnDevolver.setText("Devolução de Livros");
        btnDevolver.setFont(new Font("Tahoma", 0, 30));
        btnDevolver.setForeground(new Color(255, 255, 255));
        btnDevolver.setBackground(new Color(50, 50, 50));
        btnDevolver.setIcon(new ImageIcon(getClass().getResource("/imagens/Devolver.png")));
        
        panelBotoes1.setLayout(new BoxLayout(panelBotoes1, BoxLayout.Y_AXIS));
        
        panelCabecalho.setBackground(new Color(50, 50, 50));
        panelBotoes1.setBackground(new Color(0, 0, 0, 0));
        panelBotoes2.setBackground(new Color(0, 0, 0, 0));
    }
    
    private void adicionarComponentes() {
        
        panelCabecalho.add(lblCabecalho);
        
        panelBotoes1.add(btnInserir);
        panelBotoes1.add(Box.createRigidArea(new Dimension(0, 20)));
        panelBotoes1.add(btnLivros);
        
        panelBotoes2.add(btnEmprestar);
        panelBotoes2.add(Box.createRigidArea(new Dimension(20, 0)));
        panelBotoes2.add(btnDevolver);

        panelPrincipal.add(panelCabecalho);
        panelPrincipal.add(Box.createRigidArea(new Dimension(600, 40))); 
        panelPrincipal.add(panelBotoes1);
        panelPrincipal.add(Box.createRigidArea(new Dimension(600, 20)));
        panelPrincipal.add(panelBotoes2);
        
        add(panelPrincipal);
    }
    
    private void ajustarJanela() {
        
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/IFSP.png")).getImage());
        setVisible(true);
        setTitle("Projeto Final - LPVS2");
        setSize(1040,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
