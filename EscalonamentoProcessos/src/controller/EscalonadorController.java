package controller;

import br.com.filagenerica.Fila;
import model.Processo;

public class EscalonadorController {
	public void escalonador(Fila<Processo> fila) {
		
		Fila<Processo> aux = fila;
		
		Processo temp = null;
		try {
			temp = aux.remove();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		while(!fila.isEmpty()) {
			if(temp.getQtdRetornos() > 0) {
				int rodara = temp.getQtdRetornos()-1;
				temp.setQtdRetornos(rodara);
				try {
					fila.remove();
				} catch (Exception e) {
				}
				fila.insert(temp);
			}else {
				try {
					temp = aux.remove();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
}
