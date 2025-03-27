package br.com.comprasonline.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.comprasonline.model.Estoque;

// Classe para testarmos o funcinamento do app
public class Teste {

	public static void main(String[] args){
		
		Estoque estoque = new Estoque();
		Scanner scanner = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String user = "rm553236";
		String pass = "080799";
		
		System.out.println("Deseja criar seu estoque?");
		String inicio = scanner.next();
		
		
		// Aqui confirma se o usuário quer criar uma nova table ou não
		if (inicio.equals("Sim")){
			String tableName = "Estoque";
			
			Connection connection = null;
			
			try{
				connection = DriverManager.getConnection(url, user, pass);
				if (!estoque.tabelaExiste(connection, tableName)) {
					estoque.criarEstoque(url, user, pass, tableName);
					
					
					System.out.println("Deseja cadastrar produtos no estoque?");
					String respostaCadastro = scanner.next();
					
					if (respostaCadastro.equals("Sim")) {
						System.out.println("Quantos produtos deseja cadastrar?");
						int quantidadeCadastro = scanner.nextInt();
						
						
						
						for(int i = 0; i < quantidadeCadastro; i++) {
							System.out.println("Nome do produto: ");
							String nome = scanner.next();
							
							System.out.println("Nome da Marca: ");
							String marca = scanner.next();
							
							System.out.println("Número Serial: ");
							int nSerial = scanner.nextInt();
							
							System.out.println("Preço: ");
							double  preco = scanner.nextDouble();
							
							System.out.println("Quantidade: ");
							int quantidade = scanner.nextInt();
							
							estoque.cadastroProduto(url, user, pass, nome, marca, nSerial, preco, quantidade);
						}	
					}
					
					System.out.println("Deseja exibir seu estoque?");
					String respostaExibir = scanner.next();
					
					if (respostaExibir.equals("Sim")) {
						estoque.exibirEstoque(url, user, pass);
					}
					
					System.out.println("Deseja pesquisar um produto no seu estoque?");
					String respostaPesquisa = scanner.next();
					
					if (respostaPesquisa.equals("Sim")) {
						System.out.println("Nome do produto buscado: ");
						String nome = scanner.next();
						
						System.out.println("Número de série do produto buscado: ");
						int nSerie = scanner.nextInt();
						
						estoque.pesquisaEstoque(url, user, pass, nome, nSerie);
					}
					
					System.out.println("Deseja deletar algúm item do Estoque?");
					String respostaDeletar = scanner.next();
					
					if (respostaDeletar.equals("Sim")) {
						System.out.println("Nome do produto buscado: ");
						String nome = scanner.next();
						
						System.out.println("Número de série do produto buscado: ");
						int nSerie = scanner.nextInt();
						
						estoque.deletarDadosEstoque(url, user, pass, nome, nSerie);
					}
					
					System.out.println("Fim! Obrigado por usar nosso app!");
				} else {
					System.out.println("A tabela " + tableName + " já existe.");
	                
	                System.out.println("Deseja cadastrar produtos no estoque?");
					String respostaCadastro = scanner.next();
					
					if (respostaCadastro.equals("Sim")) {
						System.out.println("Quantos produtos deseja cadastrar?");
						int quantidadeCadastro = scanner.nextInt();
						
						for(int i = 0; i < quantidadeCadastro; i++) {
							System.out.println("Nome do produto: ");
							String nome = scanner.next();
							
							System.out.println("Nome da Marca: ");
							String marca = scanner.next();
							
							System.out.println("Número Serial: ");
							int nSerial = scanner.nextInt();
							
							System.out.println("Preço: ");
							double preco = scanner.nextDouble();
							
							System.out.println("Quantidade: ");
							int quantidade = scanner.nextInt();
							
							estoque.cadastroProduto(url, user, pass, nome, marca, nSerial, preco, quantidade);
						}
					}
					
					System.out.println("Deseja exibir seu estoque");
					String respostaExibir = scanner.next();
					
					if (respostaExibir.equals("Sim")) {
						estoque.exibirEstoque(url, user, pass);
					}
					
					System.out.println("Deseja analisar o histórico de um produto?");
					String respostaHistorico = scanner.next();
					
					if (respostaHistorico.equals("Sim")) {
						System.out.println("Nome do produto buscado: ");
						String nome = scanner.next();
						
						System.out.println("Número de série do produto buscado: ");
						int nSerie = scanner.nextInt();
						
						estoque.exibirHistorico(url, user, pass, nome, nSerie);
					}
					
					System.out.println("Deseja pesquisar um produto no seu estoque?");
					String respostaPesquisa = scanner.next();
					
					if (respostaPesquisa.equals("Sim")) {
						System.out.println("Nome do produto buscado: ");
						String nome = scanner.next();
						
						System.out.println("Número de série do produto buscado: ");
						int nSerie = scanner.nextInt();
						
						estoque.pesquisaEstoque(url, user, pass, nome, nSerie);
					}
					
					System.out.println("Deseja deletar algúm item do Estoque?");
					String respostaDeletar = scanner.next();
					
					if (respostaDeletar.equals("Sim")) {
						System.out.println("Nome do produto buscado: ");
						String nome = scanner.next();
						
						System.out.println("Número de série do produto buscado: ");
						int nSerie = scanner.nextInt();
						
						estoque.deletarDadosEstoque(url, user, pass, nome, nSerie);
					}
					
					System.out.println("Fim! Obrigado por usar nosso app!");
	            }   		
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
		            try {
		                connection.close();
		                System.out.println("Conexão fechada com sucesso.");
		            } catch (SQLException e) {
		                System.out.println("Erro ao fechar conexão: " + e.getMessage());
		            }
				}
			}	
		} else if (inicio.equals("Não")) {
			System.out.println("Você já tem o estoque criado");
			String respostaCriacao = scanner.next();
			
			if (respostaCriacao.equals("Sim")) {
				
				Connection connection = null;
				
				try{
					connection = DriverManager.getConnection(url, user, pass);
					
					System.out.println("Deseja cadastrar produtos no estoque?");
					String respostaCadastro = scanner.nextLine();
					
					if (respostaCadastro.equals("Sim")) {
						System.out.println("Quantos produtos deseja cadastrar?");
						int quantidadeCadastro = scanner.nextInt();
						
						for(int i = 0; i < quantidadeCadastro; i++) {
							System.out.println("Nome do produto: ");
							String nome = scanner.next();
							
							System.out.println("Nome da Marca: ");
							String marca = scanner.next();
							
							System.out.println("Número Serial: ");
							int nSerial = scanner.nextInt();
							
							System.out.println("Preço: ");
							double preco = scanner.nextDouble();
							
							System.out.println("Quantidade: ");
							int quantidade = scanner.nextInt();
							
							estoque.cadastroProduto(url, user, pass, nome, marca, nSerial, preco, quantidade);
						}
						
						System.out.println("Deseja exibir seu estoque");
						String respostaExibir = scanner.next();
						
						if (respostaExibir.equals("Sim")) {
							estoque.exibirEstoque(url, user, pass);
						}
						
						System.out.println("Deseja analisar o histórico de um produto?");
						String respostaHistorico = scanner.next();
						
						if (respostaHistorico.equals("Sim")) {
							System.out.println("Nome do produto buscado: ");
							String nome = scanner.next();
							
							System.out.println("Número de série do produto buscado: ");
							int nSerie = scanner.nextInt();
							
							estoque.exibirHistorico(url, user, pass, nome, nSerie);
						}
						
						System.out.println("Deseja pesquisar um produto no seu estoque?");
						String respostaPesquisa = scanner.next();
						
						if (respostaPesquisa.equals("Sim")) {
							System.out.println("Nome do produto buscado: ");
							String nome = scanner.next();
							
							System.out.println("Número de série do produto buscado: ");
							int nSerie = scanner.nextInt();
							
							estoque.pesquisaEstoque(url, user, pass, nome, nSerie);
						}
						
						System.out.println("Deseja deletar algúm item do Estoque?");
						String respostaDeletar = scanner.next();
						
						if (respostaDeletar.equals("Sim")) {
							System.out.println("Nome do produto buscado: ");
							String nome = scanner.next();
							
							System.out.println("Número de série do produto buscado: ");
							int nSerie = scanner.nextInt();
							
							estoque.deletarDadosEstoque(url, user, pass, nome, nSerie);
						}
						
						System.out.println("Fim! Obrigado por usar nosso app!");	
						
						
					}
					
				} catch(SQLException e) {
					e.printStackTrace();
				} finally {
					if (connection != null) {
			            try {
			                connection.close();
			                System.out.println("Conexão fechada com sucesso.");
			            } catch (SQLException e) {
			                System.out.println("Erro ao fechar conexão: " + e.getMessage());
			            }
					}
				}
			}
		} else {
			System.out.println("Obrigado por escolher o nosso app!");
		}
		
		scanner.close();
	}	
}