/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Marca;
import model.enums.ModeloVan;

/**
 *
 * @author loure
 */
public class Van extends Veiculo {
    
    private ModeloVan modelo;

    public Van(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca, ModeloVan modelo) {
        super(ano, placa, valorDeCompra, estado, categoria, marca);
        this.modelo = modelo;
    }
    
    public ModeloVan getModelo(){
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        return switch (getCategoria()) {
            case POPULAR -> 200.0;
            case INTERMEDIARIO -> 400.0;
            case LUXO -> 600.0;
            default -> 0.0;
        };
    }
}
