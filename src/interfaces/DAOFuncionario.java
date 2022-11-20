package interfaces;

import clases.Funcionario;

public interface DAOFuncionario {
    
    public void registrar(Funcionario funcionario);
    public void modificar(Funcionario funcionario);
    public void eliminar(Funcionario funcionario);
    public void buscar(Funcionario funcionario);
    
}
