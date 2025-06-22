/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Marca;
import model.enums.ModeloMotocicleta;

/**
 *
 * @author loure
 */
public class Motocicleta extends Veiculo {
    
    private ModeloMotocicleta modelo;

    public Motocicleta(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca, ModeloMotocicleta modelo) {
        super(ano, placa, valorDeCompra, estado, categoria, marca);
        this.modelo = modelo;
    }
    
    public ModeloMotocicleta getModelo(){
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao(){
        return switch (getCategoria()) {
            case POPULAR -> 70.0;
            case INTERMEDIARIO -> 200.0;
            case LUXO -> 350.0;
            default -> 0.0;
        };
    }
}
