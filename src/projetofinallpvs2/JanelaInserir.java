package projetofinallpvs2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Bruno Silvestre
 */
public class JanelaInserir extends JFrame{
    
    private JPanel panelPrincipal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    
    private JLabel lblTipo;
    private JLabel lblTitulo;
    private JLabel lblAutor1;
    private JLabel lblAutor2;
    private JLabel lblAno;
    private JLabel lblQtd;
    
    private JComboBox comboTipos;
    private JTextField txtTitulo;
    private JTextField txtAutor1;
    private JTextField txtAutor2;
    private JTextField txtAno;
    private JTextField txtQtd;
    
    private JButton btnInserir;
    private JButton btnLimpar;
    
    private String[] tipos = {"Livro", "Trabalho Acadêmico", "Revista"};
    
    private final GerenciadorObras gerenciador;
    
    public JanelaInserir(GerenciadorObras gerenciador){
        this.gerenciador = gerenciador;
        criarComponentes();
        ajustarJanela();
    }

    private void criarComponentes() {
        
        panelPrincipal = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        lblTipo = new JLabel("Tipo da Obra:");
        lblTitulo = new JLabel("   Título:");
        lblAutor1 = new JLabel("Autor 1:");
        lblAutor2 = new JLabel("     Autor 2:");
        lblAno = new JLabel("Ano de Publicação:");
        lblQtd = new JLabel("           Quantidade:");
        
        comboTipos = new JComboBox(tipos);
        
        txtTitulo = new JTextField(10);
        txtAutor1 = new JTextField(10);
        txtAutor2 = new JTextField(10);
        txtAno = new JTextField(3);
        txtQtd = new JTextField(2);
        
        btnInserir = new JButton("Inserir Obra");
        btnInserir.addActionListener((e) -> {
            inserirObra();
        });
        
        btnLimpar = new JButton("Limpar Campos");
        btnLimpar.addActionListener((e) -> {
            limparCampos();
        });
        
        ajustarComponentes();
        adicionarComponentes();
    }
    
    private boolean inserirObra(){
        
        String tipo = (String)comboTipos.getSelectedItem();
        String title = txtTitulo.getText();
        title = (title.toUpperCase()).trim();
        
        if(title.isEmpty()){
            JOptionPane.showMessageDialog(null, "Impossível adicionar obra sem título!");
            return false;
        }
        
        String autor1 = txtAutor1.getText().trim();
        String autor2 = txtAutor2.getText().trim();
        
        if(autor1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Impossível adicionar obra sem pelo menos um autor!");
            return false;
        }
        
        int ano = Integer.parseInt(txtAno.getText());
        int qtd = Integer.parseInt(txtQtd.getText());
        
        //Confere se a inserção tem nome repetido com algum item do Array
        boolean aux = true;
        for (Obra elemento : gerenciador.getObras()) {
            if (elemento.getTitulo().equals(title)) {
                aux = false;
            }
        }
        
        if(aux){
           Obra obra = new Obra(tipo, title, autor1, autor2, ano, qtd);
           if(gerenciador.push(obra)){
                JOptionPane.showMessageDialog(null, "Obra inserida com sucesso!");
                limparCampos();
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Erro na inserção da obra!");
                limparCampos();
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não é possível inserir uma Obra título já inserido!");
            limparCampos();
            return false;
        }
    }
    
    private void limparCampos(){
        txtTitulo.setText("");
        txtAutor1.setText("");
        txtAutor2.setText("");
        txtAno.setText("");
        txtQtd.setText("");
    }
    
    private void ajustarComponentes(){
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", 0, 30)));
        
        panel1.setBackground(new Color(0, 0, 0, 0));
        panel2.setBackground(new Color(0, 0, 0, 0));
        panel3.setBackground(new Color(0, 0, 0, 0));
        panel4.setBackground(new Color(0, 0, 0, 0));
        panelPrincipal.setBackground(new Color(50, 50, 50));
        
        lblTipo.setFont(new Font("Tahoma", 0, 30));
        lblTipo.setForeground(new Color(255, 255, 255));   
        comboTipos.setFont(new Font("Tahoma", 0, 20));
        
        lblTitulo.setFont(new Font("Tahoma", 0, 30));
        lblTitulo.setForeground(new Color(255, 255, 255));
        txtTitulo.setFont(new Font("Tahoma", 0, 20));
        
        lblAutor1.setFont(new Font("Tahoma", 0, 30));
        lblAutor1.setForeground(new Color(255, 255, 255));
        txtAutor1.setFont(new Font("Tahoma", 0, 20));
        
        lblAutor2.setFont(new Font("Tahoma", 0, 30));
        lblAutor2.setForeground(new Color(255, 255, 255));
        txtAutor2.setFont(new Font("Tahoma", 0, 20));
        
        lblAno.setFont(new Font("Tahoma", 0, 30));
        lblAno.setForeground(new Color(255, 255, 255));
        txtAno.setFont(new Font("Tahoma", 0, 20));
        
        lblQtd.setFont(new Font("Tahoma", 0, 30));
        lblQtd.setForeground(new Color(255, 255, 255));
        txtQtd.setFont(new Font("Tahoma", 0, 20));
        
        btnInserir.setFont(new Font("Tahoma", 0, 30));
        btnLimpar.setFont(new Font("Tahoma", 0, 30));
    }
    
    private void adicionarComponentes() {
        
        panel1.add(lblTipo);
        panel1.add(comboTipos);
        
        panel1.add(lblTitulo);
        panel1.add(txtTitulo);
        
        panel2.add(lblAutor1);
        panel2.add(txtAutor1);
        
        panel2.add(lblAutor2);
        panel2.add(txtAutor2);
        
        panel3.add(lblAno);
        panel3.add(txtAno);
        
        panel3.add(lblQtd);
        panel3.add(txtQtd);
        
        panel4.add(btnInserir);
        panel4.add(Box.createRigidArea(new Dimension(10, 0)));
        panel4.add(btnLimpar);
        
        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(panel4);
        
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        add(panelPrincipal);
    }
    
    private void ajustarJanela() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/Adicionar.png")).getImage());
        setTitle("Inserir Obra");
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
