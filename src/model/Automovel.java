/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Marca;
import model.enums.ModeloAutomovel;

/**
 *
 * @author loure
 */
public class Automovel extends Veiculo {
    
    private ModeloAutomovel modelo;

    public Automovel(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca, ModeloAutomovel modelo) {
        super(ano, placa, valorDeCompra, estado, categoria, marca);
        this.modelo = modelo;
    }
    
    public ModeloAutomovel getModelo(){
        return this.modelo;
    }
    
    @Override
    public double getValorDiariaLocacao(){
        return switch (getCategoria()) {
            case POPULAR -> 100.0;
            case INTERMEDIARIO -> 300.0;
            case LUXO -> 450.0;
            default -> 0.0;
        };
    }
}
