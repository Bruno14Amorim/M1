/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendasDAO;
import java.util.List;
import model.Vendas;

/**
 *
 * @author bruno
 */
public class VendasController {

    public List<Vendas> get() {
        VendasDAO dao = new VendasDAO();
        return dao.mostrar_vendas();
    }

    public boolean add(Vendas obj) {
        VendasDAO dao = new VendasDAO();
        if (dao.add_venda(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int id, Vendas obj) {
        boolean Achou = false;

        VendasDAO dao = new VendasDAO();
        Vendas c = dao.achar_vendas(id);
        if (c.getPreco()!= 0) {
            dao.alterar_venda(c.getId(),                   
                    obj.getId_carro(),
                    obj.getId_funcionario(),
                    obj.getId_pessoaFisica(),
                    obj.getPreco()
            );
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

    public boolean delete(int id) {
        boolean Achou = false;

        VendasDAO dao = new VendasDAO();
        Vendas c = dao.achar_vendas(id);
        if (c.getPreco()!= 0) {
            dao.delete_vendas(id);                    
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

}
