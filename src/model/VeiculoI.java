/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import model.enums.Marca;
import java.util.Calendar;
import model.enums.Categoria;
import model.enums.Estado;

/**
 *
 * @author loure
 */
public interface VeiculoI {
    
    void locar(int dias, Calendar data, Cliente cliente);
    void vender();
    void devolver();
    Estado getEstado();
    Marca getMarca();
    Categoria getCategoria();
    Locacao getLocacao();
    String getPlaca();
    int getAno();
    double getValorParaVenda();
    double getValorDiariaLocacao();
    
}
