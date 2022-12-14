package mediators;

import entidades.Correntista;
import repositorios.FabricaRepositorios;
import repositorios.RepositorioCorrentista;

public class CorrentistaMediator 
{
    private RepositorioCorrentista repositorioCorrentista;
    public static final int SUCESSO = 0;
	public static final int CPF_INVALIDO = 1;
	public static final int NOME_INVALIDO = 2;
    
    public CorrentistaMediator() 
    {
        repositorioCorrentista = FabricaRepositorios.getRepositorioCorrentista();
    }

    public int incluir(Correntista correntista)
    {
        if(correntista.getCpf() <= 0)
        {
            return CPF_INVALIDO;
        }
        else if(correntista.getNome() == null || correntista.getNome().trim().equals(""))
        {
            return NOME_INVALIDO;
        }
        else 
        {
            repositorioCorrentista.incluir(correntista);
            return SUCESSO;
        }
    }
    
    public Correntista[] consultarOrdenadoPorNome()
    {
        Correntista[] correntistas = repositorioCorrentista.consultarTodos();
        Correntista aux = null;
        for (int i=0; i < correntistas.length; i++) 
        {
            for (int k=i; k < correntistas.length; k++)
            {
                String nome1 = correntistas[i].getNome();
				String nome2 = correntistas[k].getNome();
				if (nome1.compareTo(nome2) > 0) 
                {
					aux = correntistas[i];
					correntistas[i] = correntistas[k];
					correntistas[k] = aux;
                }
            }
        }
        return correntistas;
    }
}
