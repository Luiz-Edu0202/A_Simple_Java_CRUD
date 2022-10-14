package mediators;
import repositorios.FabricaRepositorios;
import repositorios.RepositorioConta;
import repositorios.RepositorioCorrentista;
import entidades.Conta;
import entidades.Correntista;


public class ContaMediator 
{
    public static final int SUCESSO = 0;
	public static final int NUMERO_DA_AGENCIA_INVALIDO = 1;
	public static final int NUMERO_DA_CONTA_INVALIDO = 2;
    public static final int VALOR_INVALIDO = 3;
    public static final int CONTA_INEXISTENTE = 4;
    public static final int CORRENTISTA_NAO_CADASTRADO = 5;
    private RepositorioCorrentista repositorioCorrentista;
    private RepositorioConta repositorioConta;
    //public enum erros{SUCESSO,NUMERO_DA_AGENCIA_INVALIDO, NUMERO_DA_CONTA_INVALIDO}
    
    public ContaMediator() 
    {
        repositorioCorrentista = FabricaRepositorios.getRepositorioCorrentista();
        repositorioConta = FabricaRepositorios.getRepositorioConta();
    }

    public int incluir(Conta conta, long cpf)
    {
        if(conta.getNumeroAgencia() <= 0)
        {
            return NUMERO_DA_AGENCIA_INVALIDO;
        }
        else if(conta.getNumeroConta() <= 0)
        {
            return NUMERO_DA_CONTA_INVALIDO;
        }
        else 
        {
            Correntista correntista = repositorioCorrentista.buscar(cpf);
            if(correntista == null)
            {
               return CORRENTISTA_NAO_CADASTRADO; 
            }
            else
            {
                conta.setCorrentista(correntista);
            }
        }
        repositorioConta.incluir(conta);
        return SUCESSO;
    }


    public int debitar(int numeroAgencia, long numeroConta, double valor)
    {
        if(valor < 0)
        {
            return VALOR_INVALIDO;
        }
        else
        {
            Conta conta = repositorioConta.buscar(numeroAgencia, numeroConta);
            if(conta == null)
            {
                return CONTA_INEXISTENTE;
            }
            else
            {
                if(conta.getSaldo() >= valor)
                {
                    conta.debitar(valor);
                    return SUCESSO;
                }
                else
                {
                    return VALOR_INVALIDO;
                }
            }
        }
    }

    public int creditar(int numeroAgencia, long numeroConta, double valor)
    {
        if(valor < 0)
        {
            return VALOR_INVALIDO;
        }
        else
        {
            Conta conta = repositorioConta.buscar(numeroAgencia, numeroConta);
            if(conta == null)
            {
                return CONTA_INEXISTENTE;
            }
            else
            {
                conta.creditar(valor);
                return SUCESSO;
            }
        }
    }

    public Conta[] consultarOrdenadoPorSaldo()
    {
        Conta[] contas = repositorioConta.consultarTodos();
        Conta aux = null;
        for(int i=0; i<contas.length; i++)
        {
            for (int k=i; k<contas.length; k++)
            {
                double saldo1 = contas[i].getSaldo();
                double saldo2 = contas[k].getSaldo();
                if(saldo1 > saldo2)
                {
                    aux = contas[i];
                    contas[i] = contas[k];
                    contas[k] = aux;
                }
            }
        } 
        return contas;
    }
}
