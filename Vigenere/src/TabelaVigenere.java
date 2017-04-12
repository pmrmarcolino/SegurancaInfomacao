import java.util.Random;
public class TabelaVigenere {


	public int[] GeraChave(){
		Random gerador = new Random();

		int numero = gerador.nextInt(26);

		int chave[] = new int[numero];
		
		for(int i = 0; i<chave.length;i++){
			chave[i] = gerador.nextInt(97) + 26;
		}
		return chave;
	}
}


