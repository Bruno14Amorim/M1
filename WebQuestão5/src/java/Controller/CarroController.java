/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CarroDAO;
import java.util.List;
import model.Carro;

/**
 *
 * @author bruno
 */
public class CarroController {

    public List<Carro> getCarro() {
        CarroDAO cdao = new CarroDAO();
        return cdao.mostrar_carro();
    }

    public boolean addCarro(Carro obj) {
        CarroDAO cdao = new CarroDAO();
        if (cdao.add_carro(obj)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(int id, Carro obj) {
        boolean Achou = false;

        CarroDAO cdao = new CarroDAO();
        Carro c = cdao.achar_carro(id);
        if (c.getModelo() != null) {
            cdao.alterar_carro(c.getId(),
                    obj.getCor(),
                    obj.getModelo(),
                    obj.getAno(),
                    obj.getPreco());
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

    public boolean delete(int id) {
        boolean Achou = false;

        CarroDAO cdao = new CarroDAO();
        Carro c = cdao.achar_carro(id);
        if (c.getModelo() != null) {
            cdao.delete_carro(id);                    
            Achou = true;
        } else {
            return false;
        }
        return Achou;
    }

}
