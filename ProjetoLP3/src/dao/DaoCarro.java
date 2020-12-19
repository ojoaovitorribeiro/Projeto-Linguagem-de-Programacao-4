package dao;
import model.Carro;
import java.util.List;

public interface DaoCarro {
    
    public void salvar(Carro carro);
    public void alterar(Carro carro);
    public void excluir(int id);
    public List<Carro> getCarros();


    
}
