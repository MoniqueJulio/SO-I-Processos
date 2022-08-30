package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController kill = new KillController();

		String sistemaOperacional = kill.os();
		kill.listaProcessos(sistemaOperacional);

		int opcao = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a opção desejada: \n1-Ver o sistema operacional\n2-Listar Processos\n3-Matar o processo pelo PID\n4-Matar o processo pelo nome\n5-Finalizar"));

		switch (opcao) {

		case 1:
			kill.os();
			System.out.println("Sistema operacional: " + sistemaOperacional);
			break;

		case 2:
			kill.listaProcessos(sistemaOperacional);
			break;

		case 3:
			int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o pid que deseja matar: "));
			kill.mataPid(pid, sistemaOperacional);
			break;

		case 4:
			String nome = JOptionPane.showInputDialog("Digite o nome do processo que deseja matar: ");
			kill.mataNome(nome, sistemaOperacional);
			break;

		case 5:
			System.exit(0);
			break;

		default:
			JOptionPane.showInputDialog(null, "Opção inválida!");
		}
	}

}
