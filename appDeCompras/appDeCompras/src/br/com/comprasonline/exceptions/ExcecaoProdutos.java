package br.com.comprasonline.exceptions;

// Calsse para a criação das exeções, precisamos extender ela da classe mãe Exceptions
public class ExcecaoProdutos extends Exception{
	
	// isso aqui não entendi muito para que serve porém o eclipse tava reclamando de n ter
	private static final long serialVersionUID = 4222553667107240067L;

	// A função usada para poder lançar nossa exeção com uma mensagem personalizada
	public ExcecaoProdutos(String mensagem) {
		super(mensagem);
	}

	

}
