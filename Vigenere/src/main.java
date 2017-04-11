
public class main {

	public static void main(String[] args) {
		 Vigenere aux = new Vigenere();
		 String msg = "wearediscoveredsaveyourself";
		 String chave = "deceptive";
		 aux.CifraDeVigenere(msg, chave);
		 msg = aux.cifrar(msg);
		 aux.decifrar(msg);
	}
}
