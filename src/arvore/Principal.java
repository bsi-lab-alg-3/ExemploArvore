package arvore;

public class Principal {

	public static void main(String[] args) {
		No noRaiz = new No(50);
		
		ControleArvore controleArvore = new ControleArvore();
		controleArvore.adicionar(noRaiz, 40);
		controleArvore.adicionar(noRaiz, 99);
		controleArvore.adicionar(noRaiz, 30);
		controleArvore.adicionar(noRaiz, 45);
		controleArvore.adicionar(noRaiz, 34);
		controleArvore.adicionar(noRaiz, 32);
		controleArvore.adicionar(noRaiz, 35);
		System.out.println("Pré Ordem");
		
		controleArvore.preordem(noRaiz);
		System.out.println();
		//controleArvore.posordem(noRaiz);
		System.out.println("Removendo o 40");
		controleArvore.removeNo(noRaiz, 40);
		System.out.println("Pré Ordem");
		controleArvore.preordem(noRaiz);
	}

}
