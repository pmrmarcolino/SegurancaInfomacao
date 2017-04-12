
public class Vigenere {

	char[] mensagem;
	int[] vetChave;
	int[] resultado;

	public void CifraDeVigenere(String msg, int[] chave) {

		this.vetChave = new int[msg.length()];
		int cont = 0;

		for (int i = 0; i < msg.length(); i++) {
			this.vetChave[i] = chave[cont];
			cont++;
			if (cont == chave.length) {
				cont = 0;
			}
		}

		resultado = cifrar(msg);
		int res [] = decifrar(resultado);

		System.out.println("Mensagem: "+msg);
		System.out.println("Chave");
		for (int i = 0; i < vetChave.length; i++) {
			System.out.print(vetChave[i]+" ");	
		}
		System.out.println();
		System.out.println("Cifrado:");
		for (int i = 0; i < vetChave.length; i++) {
			System.out.print(resultado[i]+" ");	
		}
		System.out.println();
		System.out.println("Decifrado:");
		for (int i = 0; i < vetChave.length; i++) {
			System.out.print(res[i]+" ");	
		}
	}

	public int[] cifrar(String msg) {

		this.mensagem = msg.toCharArray();
		int[] cifrado = new int[msg.length()];
		//System.out.println(mensagem.length);

		int x;
		//System.out.println("Cifrado");
		for (int cont = 0; cont < mensagem.length; cont++) {
			x = (int)this.mensagem[cont]-97;
			
			if ((x ^ vetChave[cont]) <= 26){
				cifrado[cont] = (x ^ vetChave[cont]);
				
			}
			else{
				cifrado[cont] = (x ^ vetChave[cont])%26;
			}
		}

		for (int i = 0; i < cifrado.length; i++) {
			cifrado[i] +=97;
		}
		return cifrado;
	}

	public int[] decifrar(int[] cifrado) {
		int[] decifrado = new int[cifrado.length];

		int x;
		for (int cont = 0; cont < mensagem.length; cont++) {
			x = cifrado[cont];
			
			if ((x ^ vetChave[cont]) <= 122){
				decifrado[cont] = (x ^ vetChave[cont]);
			}
			else{
				decifrado[cont] = (x ^ vetChave[cont])%122;
			}
		}		
		return decifrado;
	}
}
