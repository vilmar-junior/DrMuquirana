package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import view.despesa.PainelDetalheDespesa;
import view.despesa.PainelListagemDespesas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MenuDrMuquirana {

	public JFrame frmDrMuquirana;
	private JPanel painelEsquerdo;
	private JPanel painelDireito;
	
	private PainelListagemDespesas painelDespesas = null;
	private PainelDetalheDespesa painelCadastroDespesa = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDrMuquirana window = new MenuDrMuquirana();
					window.frmDrMuquirana.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frmDrMuquirana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuDrMuquirana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDrMuquirana = new JFrame();
		frmDrMuquirana.setTitle("Dr. Muquirana");
		frmDrMuquirana.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuDrMuquirana.class.getResource("/icones/scrooge-McDuck-icon.png")));
		frmDrMuquirana.setBounds(100, 100, 450, 300);
		frmDrMuquirana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menubar = new JMenuBar();
		frmDrMuquirana.setJMenuBar(menubar);
		
		JMenu mnReceitas = new JMenu("Receitas");
		menubar.add(mnReceitas);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnReceitas.add(mntmListar);
		
		JMenuItem mntmNova = new JMenuItem("Nova");
		mnReceitas.add(mntmNova);
		
		JMenu mnDespesas = new JMenu("Despesas");
		menubar.add(mnDespesas);
		
		JMenuItem mntmListarDespesas = new JMenuItem("Listar");
		mntmListarDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(painelDespesas == null) {
					painelDespesas = new PainelListagemDespesas();
					painelDireito.add(painelDespesas);
					frmDrMuquirana.revalidate();
					
					//Adiciona listener (ouvinte) para o clique em nova despesa, que abrirá uma outra tela
					painelDespesas.getBtnNovaDespesa().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							painelCadastroDespesa = new PainelDetalheDespesa(null);
							painelEsquerdo.add(painelCadastroDespesa);
							frmDrMuquirana.revalidate();
						}
					});
				}
			}
		});
		mnDespesas.add(mntmListarDespesas);
		
		JMenuItem mntmNovaDespesa = new JMenuItem("Nova");
		mntmNovaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroDespesa = new PainelDetalheDespesa(null);
				painelEsquerdo.add(painelCadastroDespesa);
				frmDrMuquirana.revalidate();
			}
		});
		mnDespesas.add(mntmNovaDespesa);
		
		JMenu mnUsuarios = new JMenu("Usuários");
		menubar.add(mnUsuarios);
		
		JMenuItem mntmListarUsuarios = new JMenuItem("Listar");
		mnUsuarios.add(mntmListarUsuarios);
		
		JMenu mnRelatrios = new JMenu("Relatórios");
		menubar.add(mnRelatrios);
		
		JMenu mnSobre = new JMenu("Sobre");
		menubar.add(mnSobre);
		frmDrMuquirana.getContentPane().setLayout(null);
		
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDosPaineis = (int) ((dimensoesTela.getWidth() - 20) / 2);
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		
		painelEsquerdo = new JPanel();
		painelEsquerdo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		painelEsquerdo.setBounds(10, 10, larguraDosPaineis, alturaDaTela);
		frmDrMuquirana.getContentPane().add(painelEsquerdo);
		
		painelDireito = new JPanel();
		painelDireito.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		painelDireito.setBounds(larguraDosPaineis + 10, 10, larguraDosPaineis, alturaDaTela);
		frmDrMuquirana.getContentPane().add(painelDireito);
	}
}
