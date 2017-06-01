import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		
		Farmacia f = new Farmacia();
		
		try {
			f.cadastrarProduto(null);
			
		} catch (Exception e) {
			System.out.println("");
			System.exit(1);
		}
	}

}
