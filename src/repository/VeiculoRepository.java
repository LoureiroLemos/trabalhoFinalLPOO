/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.Veiculo;
import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Marca;

/**
 *
 * @author loure
 */
public class VeiculoRepository {
    
    private static VeiculoRepository instance;
    private List<Veiculo> veiculos;
    
    public VeiculoRepository(){
        this.veiculos = new ArrayList<>();
    }
    
        public static VeiculoRepository getInstance() {
        if (instance == null) {
            instance = new VeiculoRepository();
        }
        return instance;
    }
    
    public void adicionar(Veiculo veiculo){
        if (buscarPorPlaca(veiculo.getPlaca()) == null){
            this.veiculos.add(veiculo);
            System.out.println("Veiculo com a placa '" + veiculo.getPlaca() + "'adicionado.");
        } else {
            System.out.println("Erro: Veiculo com a placa '" + veiculo.getPlaca() + "'já existe.");
            
        }
    }
    
    public List<Veiculo> getTodos() {
        return new ArrayList<>(veiculos);
    }
    
    public Veiculo buscarPorPlaca(String placa){
        for (Veiculo v : veiculos){
            if(Objects.equals(v.getPlaca().toLowerCase(), placa.toLowerCase())){
                return v;
            } 
        }
        return null;
    }
    
    public List<Veiculo> buscarPorEstado(Estado estado){
        return veiculos.stream().filter(v -> v.getEstado() == estado).collect(Collectors.toList());
    }
    
    public List<Veiculo> buscarPorMarca(Marca marca){
        return veiculos.stream().filter(v -> v.getMarca() == marca).collect(Collectors.toList());
    }
    
    public List<Veiculo> buscarPorCategoria(Categoria categoria){
        return veiculos.stream().filter(v -> v.getCategoria() == categoria).collect(Collectors.toList());
    }
    
    public List<Veiculo> buscarPorTipo(Class<? extends Veiculo> tipo){
        return veiculos.stream().filter(tipo::isInstance).collect(Collectors.toList());
    }
    
    public boolean atualizar(Veiculo veiculoAtualizado){
        for (int i = 0; i < veiculos.size(); i++){
            Veiculo v = veiculos.get(i);
            if (Objects.equals(v.getPlaca().toLowerCase(), veiculoAtualizado.getPlaca().toLowerCase())){
                veiculos.set(i, veiculoAtualizado);
                System.out.println("Veiculo com a placa '" + veiculoAtualizado.getPlaca() + "' atualizado.");
                return true;
            }
        }
        System.out.println("Erro: Veiculo com a placa '" + veiculoAtualizado.getPlaca() + "' não encontrado.");
        return false;
    }
    
    public boolean remover(Veiculo veiculoParaRemover){
        if (veiculos.remove(veiculoParaRemover)){
            System.out.println("Veiculo com a placa '" + veiculoParaRemover.getPlaca() + "' removido.");
            return true;
        }
        System.out.println("Erro: Veiculo com a placa '" + veiculoParaRemover.getPlaca() + "' não encontrado.");
        return false;
    }

    
}
