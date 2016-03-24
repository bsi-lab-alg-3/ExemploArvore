package arvore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteArvore {
	private No noRaiz = new No(50);
	private ControleArvore controleArvore = new ControleArvore();
	
	@Before
	public void setUp() throws Exception {
		controleArvore.adicionar(noRaiz, 40);
		controleArvore.adicionar(noRaiz, 99);
		controleArvore.adicionar(noRaiz, 30);
		controleArvore.adicionar(noRaiz, 45);
		controleArvore.adicionar(noRaiz, 34);
		controleArvore.adicionar(noRaiz, 25);
		controleArvore.adicionar(noRaiz, 32);
		controleArvore.adicionar(noRaiz, 35);
	}

	@Test
	/**
	 * Q1 Esse método executa o pré-ordem.
	 */
	public void testePreOrdem() {
		assertEquals(controleArvore.preordem(noRaiz), "50 40 30 25 34 32 35 45 99");
	}
	@Test
	/**
	 * Q2 Remover elemento
	 */
	public void testeRemocao() {
		controleArvore.removerValor(noRaiz, 30);
		assertEquals(controleArvore.preordem(noRaiz), "50 40 32 25 34 35 45 99");
	}
	
	@Test
	/**
	 * Q3 Adicionar Elemento
	 */
	public void adicaoElemento() {
		controleArvore.adicionar(noRaiz, 100);
		assertEquals(controleArvore.preordem(noRaiz), "50 40 30 25 34 32 35 45 99 100");
	}

}
