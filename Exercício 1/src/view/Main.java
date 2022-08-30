package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController redes = new RedesController();
		String sistemaOperacional = redes.os();
		System.out.print(sistemaOperacional);

		int opcao = Integer
				.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: \n1-IP\n2-PING\n3-Finalizar"));

		switch (opcao) {

		case 1:
			redes.ip(sistemaOperacional);
			break;

		case 2:
			redes.ping(sistemaOperacional);
			break;

		case 3:
			System.exit(0);
			break;

		default:
			System.out.println("Opção inválida!");
		}

	}
}
