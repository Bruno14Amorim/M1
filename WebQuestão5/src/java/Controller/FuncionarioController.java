/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FuncionarioDAO;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author bruno
 */
public class FuncionarioController {

    public List<Funcionario> get() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.mostrar_funcionario();
    }

    public boolean add(Funcionario obj) {
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.add_funcionario(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int id, Funcionario obj) {
        boolean Achou = false;

        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario c = dao.achar_funcionario(id);
        if (c.getCpf()!= null) {
            dao.alterar_funcionario(c.getId(),
                    obj.getNome(),
                    obj.getId_departamentos(),      
                    obj.getEndereco(),
                    obj.getTelefone(),
                    obj.getCpf());
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

    public boolean delete(int id) {
        boolean Achou = false;

        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario c = dao.achar_funcionario(id);
        if (c.getCpf()!= null) {
            dao.delete_funcionario(id);                    
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

}
