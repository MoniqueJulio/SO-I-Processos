package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {

		super();

	}

	public String os() {

		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos(String os) {

		if (os.contains("Windows")) {

			String process = "TASKLIST /FO TABLE";
			readProcess(process);
		}

		else if (os.contains("Linux")) {

			String process = "ps -ef";
			readProcess(process);
		}
	}

	public void mataPid(int pid, String os) {

		StringBuffer buffer = new StringBuffer();

		if (os.contains("Windows")) {

			String cmdPid = "TASKKILL /PID ";
			buffer.append(cmdPid);
			buffer.append(pid);

		}

		else if (os.contains("Linux")) {

			String cmdPid = "kill -9 ";
			buffer.append(cmdPid);
			buffer.append(pid);

		}

		readProcess(buffer.toString());
	}

	public void mataNome(String nome, String os) {

		StringBuffer buffer = new StringBuffer();

		if (os.contains("Windows")) {

			String cmdNome = "TASKKILL /IM ";
			buffer.append(cmdNome);
			buffer.append(nome);
		}

		else if (os.contains("Linux")) {

			String cmdNome = "pkill -f ";
			buffer.append(cmdNome);
			buffer.append(nome);

		}

		readProcess(buffer.toString());

	}

	public void readProcess(String process) {

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {

				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

}
