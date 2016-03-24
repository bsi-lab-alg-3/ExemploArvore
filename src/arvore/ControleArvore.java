package arvore;

public class ControleArvore {

	public void adicionar(No no, int valor) {
		if (valor > no.getValor()) {
			// vá para direita
			if (no.getDireita() == null) {
				no.setDireita(new No(valor));
			} else {
				adicionar(no.getDireita(), valor);
			}
		} else {
			if (no.getEsquerda() == null) { // esq. tá vazio?
				no.setEsquerda(new No(valor));
			} else {
				adicionar(no.getEsquerda(), valor);
			}
		}

	}

	public No buscarLaco(No no, int valor) {
		No auxiliar = no;
		while (auxiliar != null) {
			if (valor == auxiliar.getValor()) {
				return auxiliar;
			} else if (valor > auxiliar.getValor()) {
				auxiliar = no.getDireita();
			} else {
				auxiliar = no.getEsquerda();
			}
		}
		return null;
	}

	public No buscar(No no, int valor) {
		if (no.getValor() == valor) {
			return no;
		} else if (valor > no.getValor()) {
			return buscar(no.getDireita(), valor);
		} else {
			return buscar(no.getEsquerda(), valor);
		}
	}

	public String preordem(No no) {
		return preordem(no, "").trim();
	}

	public String preordem(No no, String retorno) {
		if (no != null) {
			retorno += no.getValor() + " ";
			retorno = preordem(no.getEsquerda(), retorno);
			retorno = preordem(no.getDireita(), retorno);
		}
		return retorno;
	}

	public String posordem(No no, String retorno) {
		if (no != null) {
			retorno = posordem(no.getEsquerda(), retorno);
			retorno = posordem(no.getDireita(), retorno);
			retorno += no.getValor() + " ";
		}
		return retorno;
	}

	public String emordem(No no, String retorno) {
		if (no != null) {
			retorno = emordem(no.getEsquerda(), retorno);
			retorno += no.getValor() + " ";
			retorno = emordem(no.getDireita(), retorno);
		}
		return retorno;
	}

	// http://geeksquiz.com/binary-search-tree-set-2-delete/
	public void removerValor(No noAtual, int valor) {
		noAtual = remover(noAtual, valor);
	}

	private No remover(No root, int key) {
		if (root == null)
			return root;

		if (key < root.getValor()) {
			root.setEsquerda(remover(root.getEsquerda(), key));
		} else if (key > root.getValor()) {
			root.setDireita(remover(root.getDireita(), key));
		} else {
			if (root.getEsquerda() == null)
				return root.getEsquerda();
			else if (root.getDireita() == null)
				return root.getDireita();

			No controle = root.getDireita();
			int minv = controle.getValor();
			while (controle.getEsquerda() != null) {
				minv = controle.getEsquerda().getValor();
				controle = controle.getEsquerda();
			}
			root.setValor(minv);

			root.setDireita(remover(root.getDireita(), root.getValor()));
		}

		return root;
	}

}
