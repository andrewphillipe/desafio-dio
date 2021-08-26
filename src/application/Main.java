package application;

import entities.Cliente;
import entities.ContaReceber;
import entities.ContasAPagar;
import entities.Fornecedor;
import entities.OperacaoContaException;

public class Main {

	public static void main(String[] args) throws OperacaoContaException {
		// instanciando fornecedores
		Fornecedor imobiliaria = new Fornecedor();
		imobiliaria.setNome("Casa & Cia Negócios Imobiliários");
		Fornecedor mercado = new Fornecedor();
		mercado.setNome("Mercado do João");
				
		// instanciando clientes
		Cliente atacadista = new Cliente();
		atacadista.setNome("Triângulo Quadrado Atacadista");
		Cliente telecom = new Cliente();
		telecom.setNome("FoneNet Telecomunicações");
				
		// instanciando contas a pagar
		ContasAPagar contaPagar1 = new ContasAPagar();
		contaPagar1.setDescricao("Aluguel da matriz");
		contaPagar1.setValor(1230d);
		contaPagar1.setDataVencimento("10/05/2012");
		contaPagar1.setFornecedor(imobiliaria);
				
		ContasAPagar contaPagar2 = new ContasAPagar(mercado, "Compras do mês", 390d, "19/05/2012");
				
		// instanciando contas a receber
		ContaReceber contaReceber1 = new ContaReceber();
		contaReceber1.setDescricao("Desenvolvimento de projeto de logística em Java");
		contaReceber1.setValor(89500d);
		contaReceber1.setDataVencimento("23/05/2012");
		contaReceber1.setCliente(atacadista);
				
		ContaReceber contaReceber2 = new ContaReceber(telecom, "Manutenção em sistema de conta online", 
			53200d, "13/05/2012");
				
		// pagamento e cancelamento de contas a pagar
		
		try {
			contaPagar1.pagar();
			
			contaPagar1.pagar();
			
			contaPagar2.pagar();
			
			contaPagar1.cancelar();
		} catch (OperacaoContaException e) {
			System.out.println(e);
		}
		

		// recebimento e cancelamento de contas a receber
		contaReceber1.receber();
		contaReceber2.cancelar();
	}
}
