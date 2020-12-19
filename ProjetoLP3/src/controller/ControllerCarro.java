package controller;

import dao.DaoCarro;
import dao.DaoCarroImp;
import java.util.List;
import javax.swing.JOptionPane;
import model.Carro;

public class ControllerCarro {
    DaoCarro dao;

    public ControllerCarro() {
        dao = new DaoCarroImp();
    }
    
    public void inserirCarro(Carro carro)
    {
        if(carro != null && !carro.getModelo().equals("") && !carro.getMarca().equals("--Selecionar--") && carro.getAno()!=0)
        {
            dao.salvar(carro);
            JOptionPane.showMessageDialog(null, "Carro inserido com sucesso!!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        }
    }
    public List<Carro> getCarros()
    {
        return dao.getCarros();
    }
    
    public void excluirCarro(int id)
    {
        int op = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o registo de id"+id,"Excluir",JOptionPane.YES_NO_OPTION);
        if(op ==0)
        {
            dao.excluir(id);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
    }
    
    
    
}
