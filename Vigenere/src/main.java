
public class main {

	public static void main(String[] args) {
		 Vigenere aux = new Vigenere();
		 TabelaVigenere tv = new TabelaVigenere();
		 String msg = "wearediscoveredsaveyourself";
		 int[] chave= tv.GeraChave();
		 aux.CifraDeVigenere(msg, chave);	 
	}
}
