package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {

		super();
	}

	public String os() {

		String sistemaOperacional = System.getProperty("os.name");
		return sistemaOperacional;
	}

	public void ip(String sistemaOperacional) {

		if (sistemaOperacional.contains("Windows")) {

			String process = ("IPCONFIG");
			readProcess(process);

		}

		else if (sistemaOperacional.contains("Linux")) {

			String process = ("IFCONFIG");
			readProcess(process);

		}
	}

	public void ping(String sistemaOperacional) {

		if (sistemaOperacional.contains("Windows")) {

			String process = "PING -4 -n 10 www.google.com.br";
			readProcess(process);
		}

		else if (sistemaOperacional.contains("Linux")) {

			String process = "PING -4 -c 10 www.google.com.br";
			readProcess(process);

		}

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

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
