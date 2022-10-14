package repositorios;

public class FabricaRepositorios 
{
    private static RepositorioCorrentista repositorioCorrentista =  new RepositorioCorrentista();
	private static RepositorioConta repositorioConta = new RepositorioConta();
	public static RepositorioCorrentista getRepositorioCorrentista() {
        return repositorioCorrentista;
    }
    public static RepositorioConta getRepositorioConta() {
        return repositorioConta;
    }
}
