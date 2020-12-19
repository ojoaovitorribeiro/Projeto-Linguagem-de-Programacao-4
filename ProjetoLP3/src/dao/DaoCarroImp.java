package dao;
import conexao.Conexao;
import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carro;
public class DaoCarroImp implements DaoCarro {
    Connection con = null;
    PreparedStatement pstm=null;
    
    @Override
    public void excluir(int id)
    {
        
        con = new Conexao().getConnection();
        
        String del = "DELETE FROM tb_carro WHERE id=?";
        try{
        pstm = con.prepareStatement(del);
        pstm.setInt(1, id);
        pstm.execute();
        pstm.close();
        JOptionPane.showMessageDialog(null, "Excluído com sucesso!!!");
        }catch(SQLException delet)
        {
            JOptionPane.showMessageDialog(null,"Erro ao excluir "+ delet+ " SQL "+del);
        }
        finally
        {
            try{
            con.close();
           // JOptionPane.showMessageDialog(null, "Fim da conexão");
            }catch(SQLException erro)
            {
                JOptionPane.showMessageDialog(null,"Erro ao fechar a conexao com o banco "+erro);
            }
        }
        
       
    }
    
    
    @Override
    public void alterar(Carro carro)
    {
        con = new Conexao().getConnection();
        
        String atual = "UPDATE tb_carro SET modelo=?,marca=?,ano=? where id=?";
        try{
        pstm = con.prepareStatement(atual);
        pstm.setString(1, carro.getModelo());
        pstm.setString(2, carro.getMarca());
        pstm.setInt(3, carro.getAno());
        pstm.setInt(4, carro.getId());
        pstm.execute();
        pstm.close();
        JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");
        }catch(SQLException atualizar)
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+atualizar+" SQL "+atual);
        }
        finally
        {
            try{
            con.close();
           // JOptionPane.showMessageDialog(null, "Conexão acabou");
            }catch(SQLException erro)
            {
                JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão" +erro);
            }
        }
    }
    
    @Override
    public void salvar(Carro carro)
    {
        con = new Conexao().getConnection();
        String inserir = "INSERT INTO tb_carro(modelo,marca,ano) VALUES (?,?,?)";
        try{
        pstm = con.prepareStatement(inserir);
        pstm.setString(1, carro.getModelo());
        pstm.setString(2, carro.getMarca());
        pstm.setInt(3, carro.getAno());
        pstm.execute();
        pstm.close();
       
        }catch(SQLException insert)
        {
            JOptionPane.showMessageDialog(null,"Erro ao inserir "+insert+" SQL "+inserir);
        }
        finally
        {
            try{
            con.close();
            //JOptionPane.showMessageDialog(null,"Deconectado com Sucesso!!!");
            }catch(SQLException erro)
            {
                JOptionPane.showMessageDialog(null,"Erro ao Deconectar"+erro);
            }
        }
        
    }
    
    @Override
    public List<Carro> getCarros()
    {
        ResultSet rs =null;
        List<Carro> lista = new ArrayList<Carro>();
        
        
        con = new Conexao().getConnection();
       
        
        
        
        
        try{
        pstm = con.prepareStatement("select * from tb_carro");
        rs = pstm.executeQuery();
        rs.first();
        do{
           Carro carro = new Carro(); 
            
        carro.setId(rs.getInt("id"));
        carro.setModelo(rs.getString("modelo"));
        carro.setMarca(rs.getString("marca"));
        carro.setAno(rs.getInt("ano"));
        
        lista.add(carro);
        
        }while(rs.next());
        }catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados "+erro);
        }
        finally
        {
            try{
            con.close();
            //JOptionPane.showMessageDialog(null, "Conect finalizada");
            }catch(SQLException erro)
            {
                JOptionPane.showMessageDialog(null, "Erro ao fechar "+erro);
            }
        }
        
        
        return lista;
    }
}
