package br.com.comprasonline.model;

// classe que usaremos para a criação e intanciação dos produtos que serão adicionados ao estoque
public class Produto {
	private String nome;
	private String marca;
	private int numeroSerial;
	private double preco;
	private int quantidade;
	
	// Construtor super da classe
	public Produto(String nome, String marca, int numeroSerial, double  preco, int quantidade) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.numeroSerial = numeroSerial;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumeroSerial() {
		return numeroSerial;
	}

	public void setNumeroSerial(int numeroSerial) {
		this.numeroSerial = numeroSerial;
	}

	public double  getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
