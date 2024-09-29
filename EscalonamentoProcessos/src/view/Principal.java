package view;

import javax.swing.JOptionPane;

import br.com.filagenerica.Fila;
import controller.EscalonadorController;
import model.Processo;

public class Principal {
	public static void main(String[] args) {
		Fila<Processo> fila = new Fila<Processo>();
		
		EscalonadorController ec = new EscalonadorController();
		
		int opc = 0;
		String nome = "";
		int qtdRetornos = 0;
		
		while (opc != 1) {
			Processo p = new Processo();
			nome = JOptionPane.showInputDialog("Informe o nome do processo: ");
			qtdRetornos = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de retornos: "));
			
			p.setNome(nome);
			p.setQtdRetornos(qtdRetornos);
			
			fila.insert(p);
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? \n 0 - Sim \n 1 - Não"));
			if(opc != 0 && opc != 1) {
				while(true) {
					opc = Integer.parseInt(JOptionPane.showInputDialog("Opção Inválida! \n Deseja continuar? \n 0 - Sim \n 1 - Não"));
					if(opc == 0 || opc == 1) {
						break;
					}
				}
			}
		}
		
		ec.escalonador(fila);
	}
}
