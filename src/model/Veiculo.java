/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public abstract class Veiculo implements VeiculoI {
    
    private String placa;
    private int ano;
    private Categoria categoria;
    private Estado estado;
    private Marca marca;
    Locacao locacao;
    private double valorDeCompra;

    public Veiculo(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca) {
        this.ano = ano;
        this.placa = placa;
        this.valorDeCompra = valorDeCompra;
        this.estado = estado;
        this.categoria = categoria;
        this.marca = marca;
        this.locacao = null;
    }
    
    @Override
    public void locar(int dias, Calendar data, Cliente cliente){
        if (estado == Estado.DISPONIVEL || estado == Estado.NOVO) {
            this.locacao = new Locacao(dias, getValorDiariaLocacao() * dias, data, cliente);
            this.estado = Estado.LOCADO;
        }
    }

    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    }

    @Override
    public void devolver() {
        this.locacao = null;
        this.estado = Estado.DISPONIVEL;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public Locacao getLocacao() {
        return locacao;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public double getValorParaVenda() {
        int idade = Calendar.getInstance().get(Calendar.YEAR) - this.ano;
        double valor = valorDeCompra - (idade * 0.15 * valorDeCompra);

        double minimo = valorDeCompra * 0.1;
        if (valor < minimo) {
            return minimo;
        }
        return valor;
    }

    

}
