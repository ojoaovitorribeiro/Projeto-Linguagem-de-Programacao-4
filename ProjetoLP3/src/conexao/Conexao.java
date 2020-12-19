package conexao;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexao {
    public Connection conexao;
    //public Statement stm;
    //public ResultSet rs;
    
    private final String url ="jdbc:mysql://localhost:3306/db_projlp3";
    private final String usuario="root";
    private final String senha="";
    private final String driver = "com.mysql.jdbc.Driver";
    
    
    
    public Connection getConnection() //void conecta
    {
        try{
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, usuario,senha);
        //JOptionPane.showMessageDialog(null,"Conectado com sucesso!!!");
        }catch(ClassNotFoundException drive)
        {
            JOptionPane.showMessageDialog(null, "Driver não encontrado "+drive);
        }
        catch(SQLException fonte)
        {
            JOptionPane.showMessageDialog(null,"Banco de Dados não encontrado "+fonte);
        }
        return conexao;//retorna conexao
    }
    /*
    public void desconecta()
    {
        try{
        conexao.close();
        JOptionPane.showMessageDialog(null, "Deconectado");
        }catch(SQLException descon)
        {
            JOptionPane.showMessageDialog(null, "Não desconectado "+descon);
        }
    }
   
    public void executarSql(String sql)
    {
        try{
        stm = conexao.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_SENSITIVE);
        rs = stm.executeQuery(sql);
        JOptionPane.showMessageDialog(null, "Sucesso na consulta");
        }catch(SQLException erroexec)
        {
            JOptionPane.showMessageDialog(null,"Erro ao consultar no banco "+erroexec+" SQL "+sql);
        }
    } */
}
