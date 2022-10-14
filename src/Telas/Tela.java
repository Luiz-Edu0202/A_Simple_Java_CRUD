package Telas;

import java.util.Scanner;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;
import entidades.Correntista;
import mediators.ContaMediator;
import mediators.CorrentistaMediator;

public class Tela 
{
    private Scanner ENTRADA = new Scanner(System.in);
    ContaMediator contaMediator;
    CorrentistaMediator correntistaMediator;

    public Tela() {
        contaMediator = new ContaMediator();
        correntistaMediator = new CorrentistaMediator();
    }

    public void executarMenu()
    {
        boolean continua;
		do {
			continua = menuPrincipal();
		} while(continua);	
    }

    private boolean menuPrincipal() {
		System.out.println("1- Incluir um novo Correntista");
		System.out.println("2- Incluir conta Corrente ou conta Poupança");
		System.out.println("3- Debitar");
		System.out.println("4- Creditar");
		System.out.println("5- Listar contas ordenadas por saldo em ordem crescente.");
		System.out.println("6- Listar correntistas ordenados por nome em ordem crescente.");
		System.out.println("7- Sair");
		int opcao = ENTRADA.nextInt();
		boolean ret = true;
		switch (opcao) { 
		case 1:
			incluirCorrentista();
			break;
		case 2:
			incluirConta();
			break;
		case 3:
			debitar();
			break;
		case 4:
			creditar();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			listarCorrentistas();
			break;
		case 7:
			ret = false;
			break;
		}
		return ret;
	}


    private void incluirCorrentista()
    {
        System.out.println("Digite o CPF do Correntista:");
        long cpf = ENTRADA.nextLong();
        System.out.println("Digite o Nome do Correntista:");
        String nome = ENTRADA.next();
        Correntista correntista = new Correntista(cpf, nome);
        int retorno = correntistaMediator.incluir(correntista);
        mostrarSucessoNaoSucesso("Correntista adicionado! ", "Correnstista Não adicionado! ", CorrentistaMediator.SUCESSO ,retorno );
    }

    private void incluirConta()
    {
        System.out.println("Incluir conta Poupança ou Corrente?");
        Conta conta = null;
        double tarifa = 0.0;
        double taxaBonus = 0.0;
        System.out.println("Digite 1 para Conta Corrente e 2 para conta Poupança:");
        int opcaoConta = ENTRADA.nextInt();
        System.out.println("Digite o numero da agência:");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite o numero da Conta:");
        long numeroConta = ENTRADA.nextLong();
        System.out.println("Digite o cpf do Correntista:");
        long cpf = ENTRADA.nextLong();
        if(opcaoConta == 1)
        {
            System.out.println("Digite a tarifa:");
            tarifa = ENTRADA.nextDouble();
            conta = new ContaCorrente(numeroAgencia, numeroConta, null, tarifa);
        }
        else if(opcaoConta == 2)
        {
            System.out.println("Digite a taxa de bônus:");
            taxaBonus = ENTRADA.nextDouble();
            conta = new ContaPoupanca(numeroAgencia, numeroConta, null, taxaBonus);
        }
        int retorno = contaMediator.incluir(conta,cpf);
        mostrarSucessoNaoSucesso("Conta Criada!", "Conta Não Criada! ", ContaMediator.SUCESSO, retorno);
    }

    private void debitar()
    {
        System.out.println("Digite o numero da agência: ");
        int numeroAgencia =  ENTRADA.nextInt();
        System.out.println("Digite o numero da conta: ");
        long numeroConta =  ENTRADA.nextLong();
        System.out.println("Digite o valor: ");
		double valor = ENTRADA.nextDouble();
        int retorno = contaMediator.debitar(numeroAgencia,numeroConta,valor);
        mostrarSucessoNaoSucesso("Valor Debitado!", "Valor não Debitado!", ContaMediator.SUCESSO, retorno); 
    }

    private void creditar()
    {
        System.out.println("Digite o numero da agência: ");
        int numeroAgencia =  ENTRADA.nextInt();
        System.out.println("Digite o numero da conta: ");
        long numeroConta =  ENTRADA.nextLong();
        System.out.println("Digite o valor: ");
		double valor = ENTRADA.nextDouble();
        int retorno = contaMediator.creditar(numeroAgencia,numeroConta,valor);
        mostrarSucessoNaoSucesso("Valor Creditado!", "Valor não Creditado!", ContaMediator.SUCESSO, retorno); 
    }

    private void listarContas()
    {
        Conta[] listaContas = contaMediator.consultarOrdenadoPorSaldo();
        for(Conta conta: listaContas)
        {
            System.out.println("Saldo: " + conta.getSaldo()
            + "/ Numero da Conta: " + conta.getNumeroConta()+
            "/ Numero da Agencia: " + conta.getNumeroAgencia());
        }
    }

    private void listarCorrentistas()
    {
        Correntista[] correntistas = correntistaMediator.consultarOrdenadoPorNome();
        for(Correntista correntista: correntistas)
        {
            System.out.println("Nome: " + correntista.getNome() + "/ Cpf: " + correntista.getCpf());
        }
    }
    private void mostrarSucessoNaoSucesso(String msgSucesso, String msgNaoSucesso, int codigoSucesso, int retorno) 
    {
		if (retorno == codigoSucesso) {
			System.out.println(msgSucesso + " com sucesso");
		} else {
			System.out.println(msgNaoSucesso + ", cod retorno: " + retorno);
		}		
	}

}
