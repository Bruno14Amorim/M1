/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DepartamentoDAO;
import java.util.List;
import model.Departamento;

/**
 *
 * @author bruno
 */
public class DepartamentoController {

    public List<Departamento> get() {
        DepartamentoDAO dao = new DepartamentoDAO();
        return dao.mostrar_departamento();
    }

    public boolean add(Departamento obj) {
        DepartamentoDAO dao = new DepartamentoDAO();
        if (dao.add_departamento(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int id, Departamento obj) {
        boolean Achou = false;

        DepartamentoDAO dao = new DepartamentoDAO();
        Departamento c = dao.achar_departamento(id);
        if (c.getDescricao()!= null) {
            dao.alterar_departamento(c.getId(),
                    obj.getDescricao());
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

    public boolean delete(int id) {
        boolean Achou = false;

        DepartamentoDAO dao = new DepartamentoDAO();
        Departamento c = dao.achar_departamento(id);
        if (c.getDescricao()!= null) {
            dao.delete_departamento(id);                    
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

}
