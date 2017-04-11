
public class Vigenere {

	char[] mensagem;
	char[] chave;
	char[] resultado;
	char matriz[][];
	char[] texto;

	public void CifraDeVigenere(String msg, String chave) {
		
		char[] chaveTemp = chave.toCharArray();
		//System.out.println(chaveTemp);
		this.chave = new char[msg.length()];
		//System.out.println(msg.length());
		int cont = 0;

		for (int i = 0; i < msg.length(); i++) {
			this.chave[i] = chaveTemp[cont];
			cont++;
			if (cont == chaveTemp.length) {
				cont = 0;
			}
			//System.out.println(this.chave[i]);
		}

		TabelaVigenere t = new TabelaVigenere();
		this.matriz = t.mat();
		cifrar(msg);
	}

	public String cifrar(String msg) {
		
		this.mensagem = msg.toCharArray();
		char[] cifrado = new char[msg.length()];
		//System.out.println(mensagem.length);
		
		String retorno = "";
		int x, y;

		for (int cont = 0; cont < mensagem.length; cont++) {
			x = (int) this.mensagem[cont] - 97;
			y = (int) this.chave[cont] - 97;
			cifrado[cont] = this.matriz[x][y];
			//System.out.println(x);
			//System.out.println(y);
		}
		this.resultado = cifrado;

		System.out.println(this.mensagem);
		System.out.println(this.chave);
		System.out.println(cifrado);

		for (int i = 0; i < cifrado.length; i++) {
			retorno += cifrado[i];
		}

		return retorno;
	}
	
	public String decifrar(String msg) {
		char[] decifrado = new char[mensagem.length];
		//System.out.println(decifrado.length);
		String retorno = "";
		int x = 0, y = 0;

		for (int cont = 0; cont < mensagem.length; cont++) {
			x = (int) this.mensagem[cont] - 97;
			y = (int) this.chave[cont] - 97;
			//System.out.println(x);
			//System.out.println(y);
			char[] coluna = new char[26];

			for (int i = 0; i < 26; i++) {
				coluna[i] = this.matriz[i][y];
				//System.out.println(coluna[i]);
			}

			int a = 0;
			boolean teste = false;
			do {
				if (coluna[a] == mensagem[cont]) {
					break;
				}
				a++;
			} while (teste == false);

			decifrado[cont] = this.matriz[a][0];

		}

		for (int i = 0; i < decifrado.length; i++) {
			retorno += decifrado[i];
			//System.out.println(retorno);
		}

		//System.out.println(this.mensagem);
		//System.out.println(this.chave);
		System.out.println(decifrado);

		this.resultado = decifrado;
		//System.out.println(resultado);
		return retorno;
	}
}
