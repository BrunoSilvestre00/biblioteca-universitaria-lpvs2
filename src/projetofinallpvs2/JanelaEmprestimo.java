package projetofinallpvs2;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class JanelaEmprestimo extends JFrame{
    
    private JPanel panelPrincipal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    private JLabel lblTitulo1;
    private JLabel lblTitulo2;
    private JLabel lblTitulo3;
    private JLabel lblData;
    
    private JTextField txtTitulo1;
    private JTextField txtTitulo2;
    private JTextField txtTitulo3;
    
    private JDateChooser data;
    
    private JButton btnEmprestar;
    
    private GerenciadorObras gerenciadorO;
    private GerenciadorEmprestimos gerenciadorE;
    
    private Emprestimo e1;
    private Emprestimo e2;
    private Emprestimo e3; 
    
    private String tipo1;
    private String tipo2;
    private String tipo3;
    
    public JanelaEmprestimo(GerenciadorObras gerenciador1, GerenciadorEmprestimos gerenciador2) {
        this.gerenciadorO = gerenciador1;
        this.gerenciadorE = gerenciador2;
        
        criarComponentes();
        ajustarJanela();
    }
    
    private boolean emprestar(){
        
        String title1 = txtTitulo1.getText();
        String title2 = txtTitulo2.getText();
        String title3 = txtTitulo3.getText();
        
        title1 = (title1.toUpperCase()).trim();
        title2 = (title2.toUpperCase()).trim();
        title3 = (title3.toUpperCase()).trim();
        
        Date data1 = data.getDate(); 
        
        boolean aux1 = false;
        boolean aux2 = false;
        boolean aux3 = false;
        
        for (Obra elemento : gerenciadorO.getObras()) {
            if (elemento.getTitulo().equals(title1)) {
                aux1 = true;
            }
            if (elemento.getTitulo().equals(title2)) {
                aux2 = true;
            }
            if (elemento.getTitulo().equals(title3)) {
                aux3 = true;
            }
        }
        
        //Confere se todas as obras digitadas existem
        if(!aux1 && !title1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Obra 1 não foi encontrada!");
            return false;
        }
        if(!aux2 && !title2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Obra 2 não foi encontrada!");
            return false;
        }
        if(!aux3 && !title3.isEmpty()){
            JOptionPane.showMessageDialog(null, "Obra 3 não foi encontrada!");
            return false;
        }
        
        //Confere se foram digitadas obras iguais
        if(title1.equals(title2) && !title1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não foi possível fazer empréstimo de duas obras iguais!");
            return false;
        }
        if(title1.equals(title3) && !title1.isEmpty()){
            JOptionPane.showMessageDialog(null, "N�o � poss�vel fazer empr�stimo de duas obras iguais!");
            return false;
        }
        if(title2.equals(title3) && !title2.isEmpty()){
            JOptionPane.showMessageDialog(null, "N�o � poss�vel fazer empr�stimo de duas obras iguais!");
            return false;
        }
        
        //Recupera a informa��o dos tipos das obras
        for(int i = 0; i < gerenciadorO.getObras().size(); i++)
        {
            if(gerenciadorO.getObras().get(i).getTitulo().equals(title1) && title1 != null){
                tipo1 = new String(gerenciadorO.getObras().get(i).getTipo());
                e1 = new Emprestimo(gerenciadorE.getCod(), tipo1, title1, data1);
            }
                
            if(gerenciadorO.getObras().get(i).getTitulo().equals(title2) && title2 != null){
                tipo2 = new String(gerenciadorO.getObras().get(i).getTipo());
                e2 = new Emprestimo(gerenciadorE.getCod(), tipo2, title2, data1);
            }
                
            if(gerenciadorO.getObras().get(i).getTitulo().equals(title3) && title3 != null){
                tipo3 = new String(gerenciadorO.getObras().get(i).getTipo());
                e3 = new Emprestimo(gerenciadorE.getCod(), tipo3, title3, data1);
            }      
        }
        
        //Verifica se h� obras dispon�veis
        int j = 0;
        if(!title1.equals("")){
            j = gerenciadorO.buscarPeloNomeIndex(title1);
            if(gerenciadorO.getObras().get(j).getQtd() == 0){
                JOptionPane.showMessageDialog(null, "Obra 1 indispon�vel no momento!");
                aux1 = false;
            } 
        }
            
        
        if(!title2.equals("")){
            j = gerenciadorO.buscarPeloNomeIndex(title2);
            if(gerenciadorO.getObras().get(j).getQtd() == 0){
                JOptionPane.showMessageDialog(null, "Obra 2 indispon�vel no momento!");
                aux2 = false;
            } 
        }
            
        
        if(!title3.equals("")){
            j = gerenciadorO.buscarPeloNomeIndex(title3);
            if(gerenciadorO.getObras().get(j).getQtd() == 0){
                JOptionPane.showMessageDialog(null, "Obra 3 indispon�vel no momento!");
                aux3 = false;
            } 
        }
            
        
        //Realiza emprestimo somente daqueles que foram digitados e verificados
        if(aux1){
            int i = gerenciadorO.buscarPeloNomeIndex(title1);
            gerenciadorO.getObras().get(i).minusQtd();
            
            gerenciadorE.push(e1);
            JOptionPane.showMessageDialog(null, "Empr�stimo da Obra 1 Realizado!");
        }
        if(aux2){
            int i = gerenciadorO.buscarPeloNomeIndex(title2);
            gerenciadorO.getObras().get(i).minusQtd();
            
            gerenciadorE.push(e2);
            JOptionPane.showMessageDialog(null, "Empr�stimo da Obra 2 Realizado!");
        }
        if(aux3){
            int i = gerenciadorO.buscarPeloNomeIndex(title3);
            gerenciadorO.getObras().get(i).minusQtd();
            
            gerenciadorE.push(e3);
            JOptionPane.showMessageDialog(null, "Empr�stimo da Obra 3 Realizado!");
        }
        
        gerenciadorE.addQtd();
        limpaCampos();
        
        return true;
    }
    
    private void limpaCampos(){
        txtTitulo1.setText("");
        txtTitulo2.setText("");
        txtTitulo3.setText("");
        data.setDate(new Date());
    }
    
    private void criarComponentes() {
        
        panelPrincipal = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        lblTitulo1 = new JLabel("Titulo da Obra 1:");
        lblTitulo2 = new JLabel("Titulo da Obra 2:");
        lblTitulo3 = new JLabel("Titulo da Obra 3:");
        lblData = new JLabel("Data de Empr�stimo:");
        
        txtTitulo1 = new JTextField(15);
        txtTitulo2 = new JTextField(15);
        txtTitulo3 = new JTextField(15);
        
        data = new JDateChooser();
        data.setDateFormatString("dd/MM/yyyy");
        
        btnEmprestar = new JButton("Realizar Empr�stimo");
        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emprestar();
            }
        });
        
        ajustarComponentes();
        adicionarComponentes();
    }
    
    private void ajustarComponentes(){
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", 0, 30)));
        
        panelPrincipal.setBackground(new Color(50, 50, 50));
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        
        panel1.setBackground(new Color(0, 0, 0, 0));
        panel2.setBackground(new Color(0, 0, 0, 0));
        panel3.setBackground(new Color(0, 0, 0, 0));
        panel4.setBackground(new Color(0, 0, 0, 0));
        
        lblTitulo1.setFont(new Font("Tahoma", 0, 30));
        lblTitulo1.setForeground(new Color(255, 255, 255));
        lblTitulo2.setFont(new Font("Tahoma", 0, 30));
        lblTitulo2.setForeground(new Color(255, 255, 255));
        lblTitulo3.setFont(new Font("Tahoma", 0, 30));
        lblTitulo3.setForeground(new Color(255, 255, 255));
        
        txtTitulo1.setFont(new Font("Tahoma", 0, 30));
        txtTitulo2.setFont(new Font("Tahoma", 0, 30));
        txtTitulo3.setFont(new Font("Tahoma", 0, 30));
        
        lblData.setFont(new Font("Tahoma", 0, 30));
        lblData.setForeground(new Color(255, 255, 255));
        
        data.setFont(new Font("Tahoma", 0, 30));
        data.setPreferredSize( new Dimension(200,50));
        data.setDate(new Date());
        
        btnEmprestar.setFont(new Font("Tahoma", 0, 30));
        btnEmprestar.setIcon(new ImageIcon(getClass().getResource("/imagens/Emprestar.png")));
        btnEmprestar.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    private void adicionarComponentes() {
        
        panel1.add(lblTitulo1);
        panel1.add(txtTitulo1);
        
        panel2.add(lblTitulo2);
        panel2.add(txtTitulo2);
        
        panel3.add(lblTitulo3);
        panel3.add(txtTitulo3);
        
        panel4.add(lblData);
        panel4.add(data);
        
        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);
        panelPrincipal.add(panel4);
        
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnEmprestar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        
        add(panelPrincipal);
    }
    
    private void ajustarJanela() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/Emprestar.png")).getImage());
        setVisible(true);
        setTitle("Empr�stimo");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
