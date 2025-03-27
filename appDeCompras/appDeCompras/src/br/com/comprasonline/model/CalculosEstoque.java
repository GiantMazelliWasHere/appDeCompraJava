package br.com.comprasonline.model;

// Classe que usaremos para criar qualquer caulculo necessário para o estoque
public class CalculosEstoque {
	
	// Função que passamos o numero de itens no estoque, seu preço e recebemos o valor total daquele produto no estoque
	public double calculoPrecoTotal(int quant, double preco) {
		
		double calculo = quant * preco;
		
		return calculo;
	}

}
