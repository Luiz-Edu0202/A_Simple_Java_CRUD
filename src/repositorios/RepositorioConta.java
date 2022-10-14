package repositorios;
import entidades.*;

public class RepositorioConta 
{
    private Conta[] listaContas;
    private int tamanhoAtual;

    public RepositorioConta()
    {
        listaContas = new Conta[200];
        tamanhoAtual = -1;
    }
    
    public void incluir(Conta conta)
    {
        tamanhoAtual++;
        listaContas[tamanhoAtual] = conta;
    }

    public Conta buscar(int agencia, long numero)
    {
        for( Conta cadaConta: listaContas)
        {
            if(cadaConta != null && cadaConta.getNumeroAgencia() == agencia && cadaConta.getNumeroConta() == numero)
            {
                return cadaConta;
            }
        }
        return null;
    }

    public Conta[] consultarTodos()
    {
        Conta[] contasUsadas = new Conta[tamanhoAtual + 1];
        for(int i = 0; i < contasUsadas.length; i++)
        {
            contasUsadas[i] = listaContas[i];
        }
        return contasUsadas;
    }
    
}
