/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PessoaFisicaDAO;
import java.util.List;
import model.PessoaFisica;

/**
 *
 * @author bruno
 */
public class PessoaFisicaController {

    public List<PessoaFisica> get() {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        return dao.mostrar_pessoaFisica();
    }

    public boolean add(PessoaFisica obj) {
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        if (dao.add_pessoaFisica(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int id, PessoaFisica obj) {
        boolean Achou = false;

        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        PessoaFisica c = dao.achar_pessoaFisica(id);
        if (c.getCpf()!= null) {
            dao.alterar_pessoaFisica(c.getId(),
                    obj.getNome(),
                    obj.getProfissao(),      
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

        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        PessoaFisica c = dao.achar_pessoaFisica(id);
        if (c.getCpf()!= null) {
            dao.delete_pessoaFisica(id);                    
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

}
