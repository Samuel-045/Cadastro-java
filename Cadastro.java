package pack;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Cadastro extends JFrame{
	private JButton btCadastrar, btFechar, btLimpar;
	private JTextField cmNome, cmCPF, cmRG, cmEndereco, cmNumeroCasa, cmTelefone;
	private JLabel lbMensagem;
	
	public Cadastro() {
		setTitle("Cadastro");
		setSize(800,500);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(126,129,226));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		centralizador();
		
		add(criarJLabel("Cadastrar", 350, 20, 120 ,20));
		
		add(criarJLabel("Nome",10,60, 120 ,20));
		cmNome = criarCampoTexto(150,60,"Digite seu nome");
		add(cmNome);
		
		add(criarJLabel("Telefone",390,60, 120 ,20));
		cmTelefone = criarCampoTexto(510,60,"Digite seu telefone: (xx)xxxxx-xxxx"); 
		add(cmTelefone);
		
		add(criarJLabel("CPF",10,110, 120 ,20));
		cmCPF = criarCampoTexto(150,110,"Digite seu CPF: xxx.xxx.xxx-xx");
		add(cmCPF);
		
		add(criarJLabel("RG",390,110, 120 ,20));	
		cmRG = criarCampoTexto(510,110,"Digite seu RG: xx.xxx.xxx-xx"); 
		add(cmRG);
		
		add(criarJLabel("Endereço",10,160, 120 ,20));
		cmEndereco = criarCampoTexto(150,160,"Digite seu endereco");
		add(cmEndereco);
		
		add(criarJLabel("Número da casa",390,160, 120 ,20));
		cmNumeroCasa = criarCampoTexto(510,160,"Digite seu lougradouro");
		add(cmNumeroCasa);
		
		btCadastrar = criarButton("Gravar", 120,220,150,30);
		add(btCadastrar);
		
		btLimpar = criarButton("Limpar", 310,220,150,30);
		add(btLimpar);
		
		btFechar = criarButton("Fechar", 500,220,150,30);
		add(btFechar);
		
		lbMensagem = criarJLabel("", 0, 290, 800 ,200);
		add(lbMensagem);
		
		eventos();
		revalidate();
		repaint();
	}
	
	//public JFrame construtor() {}
	
	public void centralizador() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension janela = getSize();
		
		if(janela.height>screen.height) {
			setSize(janela.width,screen.height);
		}
		if(janela.width>screen.width) {
			setSize(screen.width, janela.height);
		}
		
		setLocation((screen.width- janela.width)/2, (screen.height - janela.height)/2);
	}

	public JLabel criarJLabel(String texto, int x, int y, int lrg, int alt){
		JLabel jl = new JLabel();
		jl.setText(texto);
		jl.setLocation(x,y);
		jl.setSize(lrg , alt);
		//Torna opaco o fundo do rótulo
		jl.setOpaque(true);
		jl.setBackground(new Color(126,129,226));
		jl.setForeground(new Color(0,0,0));
		jl.setFont(new Font("Courier new", Font.BOLD, 12));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setVerticalAlignment(SwingConstants.TOP);
		return jl;
	}
	
	public JTextField criarCampoTexto(int x, int y, String titulo) {
		JTextField jt = new JTextField();
		jt.setHorizontalAlignment(JTextField.CENTER);
		jt.setSize(200, 20);
		jt.setLocation(x,y);
		jt.setToolTipText(titulo);
		jt.setBackground(new Color(255,255,255));
		return jt;
	}
	
	public JButton criarButton(String texto, int x, int y, int lrg, int alt) {
		JButton b1 = new JButton();
		b1.setText(texto);
		
		//50 posiÃ§Ã£o x, 30 posiÃ§Ã£o y, 100 largura, 30 altura
		b1.setBounds(x, y, lrg, alt); //D Esq, D Topo, larg, alt
		
		b1.setBackground(new Color(0,0,170));
		b1.setForeground(new Color(255,255,255));
		b1.setFont(new Font("Helvetica", Font.BOLD, 12));
		b1.setToolTipText("Botao "+texto);
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setVerticalAlignment(SwingConstants.CENTER);
		b1.setEnabled(true); //BotÃ£o desabilitado.
		b1.setMnemonic('G'); //Tecla de atalho
		return b1;
	}
	
	private void eventos() {
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean respNome,respCPF,respRg,respTelefone,respNumero,respEndereco;
				String nome = cmNome.getText();
				String cpf = cmCPF.getText();
				String rg = cmRG.getText();
				String telefone = cmTelefone.getText();
				String numero = cmNumeroCasa.getText();
				String endereco = cmEndereco.getText();
				
				if(nome.equalsIgnoreCase("") || cpf.equalsIgnoreCase("") || rg.equalsIgnoreCase("") ||
						telefone.equalsIgnoreCase("") || endereco.equalsIgnoreCase("") || numero.equalsIgnoreCase("") ) {
					lbMensagem.setText("Há campos em branco!!\n"
							+ " Cliente não cadastrado!!");
				}else{
					respNome = nome.matches("([A-Za-z{ã,á,à,â,Á,À,Ã,Â,É,È,Ê,é,è,ê,Ó,Ò,Ô,Õ,õ,ó,ò,ô,í,ì,Í,Ì,Ú,Ù,ú,ù}]{2,})[\\s]*?"
							+ "([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]*?([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]?"
							+ "([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]*?([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]?"
							+ "([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]*?([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]?"
							+ "([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]*?([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]?");
					respCPF = cpf.matches("^([0-9]{3})([.]*?)([0-9]{3})([.]*?)([0-9]{3})([-]*?)([0-9]{2})$");
					respRg = rg.matches("^([0-9]{2})([.]*?)([0-9]{3})([.]*?)([0-9]{3})([-]*?)([0-9]{1})$");
					respTelefone = telefone.matches("^([(]*?)([0-9]{2})([)]*?)([0-9]{5})([-]*?)([0-9]{4})$");
					respNumero = numero.matches("([0-9]{1,})");
					respEndereco = endereco.matches("([A-Za-z{ã,á,à,â,Á,À,Ã,Â,É,È,Ê,é,è,ê,Ó,Ò,Ô,Õ,õ,ó,ò,ô,í,ì,Í,Ì,Ú,Ù,ú,ù}]{2,})[\\s]*?"
							+ "([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]*?([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]?"
							+ "([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\s]*?([A-Za-z{ÃãàÀÁáÇçèÈÉéÍíÜüÓóÒòôÔ}]{1,}?)[\\\\s]?"); 
					
					if(respNome && respCPF && respRg && respTelefone && respNumero && respEndereco)
						lbMensagem.setText("Obrigado "+nome+" por realizar o \n"
								+ "cadastro em nosso sistema!");
					else						
						lbMensagem.setText("Há campos que foram preenchidos de forma indevida");
				}				
			}
		});
		
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmNome.setText("");
				cmCPF.setText("");
				cmRG.setText("");
				cmTelefone.setText("");
				cmNumeroCasa.setText("");
				cmEndereco.setText("");
				lbMensagem.setText("");
			}
		});
		
		
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	
 	public static void main(String[] args) {
		Cadastro janela = new Cadastro();
	}
}
