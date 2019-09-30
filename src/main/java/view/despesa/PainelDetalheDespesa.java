package view.despesa;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.vo.DespesaVO;

import javax.swing.JLabel;
import java.awt.Font;

public class PainelDetalheDespesa extends JPanel {

	public PainelDetalheDespesa(DespesaVO despesa) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblDespesa = new JLabel("Despesa");
		springLayout.putConstraint(SpringLayout.WEST, lblDespesa, 193, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDespesa, -134, SpringLayout.SOUTH, this);
		lblDespesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDespesa);
	}
}