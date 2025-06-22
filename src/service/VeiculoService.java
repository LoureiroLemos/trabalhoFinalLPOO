/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.Automovel;
import model.Cliente;
import model.Motocicleta;
import model.Van;
import model.Veiculo;
import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Marca;
import model.enums.ModeloAutomovel;
import model.enums.ModeloMotocicleta;
import model.enums.ModeloVan;
import repository.VeiculoRepository;

/**
 *
 * @author loure
 */
public class VeiculoService {
    
    private VeiculoRepository veiculoRepository;
    
    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }
    
    public void cadastrarAutomovel(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca, ModeloAutomovel modelo) throws IllegalArgumentException {
        if (placa == null || placa.trim().isEmpty() || valorDeCompra <= 0 || ano <= 1900) { // Ano mínimo arbitrário
            throw new IllegalArgumentException("Dados de cadastro do automóvel inválidos.");
        }
        if (veiculoRepository.buscarPorPlaca(placa) != null) {
            throw new IllegalArgumentException("Já existe um veículo com a placa " + placa + " cadastrado.");
        }

        Automovel novoAutomovel = new Automovel(ano, placa, valorDeCompra, estado, categoria, marca, modelo);
        veiculoRepository.adicionar(novoAutomovel);
        System.out.println("Automóvel " + modelo + " (" + placa + ") cadastrado com sucesso.");
    }
    
    public void cadastrarMotocicleta(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca, ModeloMotocicleta modelo) throws IllegalArgumentException {
        if (placa == null || placa.trim().isEmpty() || valorDeCompra <= 0 || ano <= 1900) {
            throw new IllegalArgumentException("Dados de cadastro da motocicleta inválidos.");
        }
        if (veiculoRepository.buscarPorPlaca(placa) != null) {
            throw new IllegalArgumentException("Já existe um veículo com a placa " + placa + " cadastrado.");
        }

        Motocicleta novaMotocicleta = new Motocicleta(ano, placa, valorDeCompra, estado, categoria, marca, modelo);
        veiculoRepository.adicionar(novaMotocicleta);
        System.out.println("Motocicleta " + modelo + " (" + placa + ") cadastrada com sucesso.");
    }
    
    public void cadastrarVan(int ano, String placa, double valorDeCompra, Estado estado, Categoria categoria, Marca marca, ModeloVan modelo) throws IllegalArgumentException {
        if (placa == null || placa.trim().isEmpty() || valorDeCompra <= 0 || ano <= 1900) {
            throw new IllegalArgumentException("Dados de cadastro da van inválidos.");
        }
        if (veiculoRepository.buscarPorPlaca(placa) != null) {
            throw new IllegalArgumentException("Já existe um veículo com a placa " + placa + " cadastrado.");
        }

        Van novaVan = new Van(ano, placa, valorDeCompra, estado, categoria, marca, modelo);
        veiculoRepository.adicionar(novaVan);
        System.out.println("Van " + modelo + " (" + placa + ") cadastrada com sucesso.");
    }
    
    public void locarVeiculo(String placaVeiculo, int dias, Calendar data, Cliente cliente) throws IllegalArgumentException {
        Veiculo veiculo = veiculoRepository.buscarPorPlaca(placaVeiculo);
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo com placa " + placaVeiculo + " não encontrado.");
        }
        if (veiculo.getEstado() != Estado.DISPONIVEL && veiculo.getEstado() != Estado.NOVO) {
            throw new IllegalArgumentException("Veículo com placa " + placaVeiculo + " não está disponível para locação. Estado atual: " + veiculo.getEstado());
        }
        if (dias <= 0) {
            throw new IllegalArgumentException("Número de dias para locação deve ser maior que zero.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente para locação não pode ser nulo.");
        }

        veiculo.locar(dias, data, cliente);
        veiculoRepository.atualizar(veiculo); 
        System.out.println("Veículo " + placaVeiculo + " locado com sucesso para o cliente " + cliente.getNome() + " por " + dias + " dias.");
    }
        
    public void devolverVeiculo(String placaVeiculo) throws IllegalArgumentException {
        Veiculo veiculo = veiculoRepository.buscarPorPlaca(placaVeiculo);
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo com placa " + placaVeiculo + " não encontrado.");
        }
        if (veiculo.getEstado() != Estado.LOCADO) {
            throw new IllegalArgumentException("Veículo com placa " + placaVeiculo + " não está locado. Estado atual: " + veiculo.getEstado());
        }

        veiculo.devolver();
        veiculoRepository.atualizar(veiculo);
        System.out.println("Veículo " + placaVeiculo + " devolvido com sucesso.");
    }
    
    public void venderVeiculo(String placaVeiculo) throws IllegalArgumentException {
        Veiculo veiculo = veiculoRepository.buscarPorPlaca(placaVeiculo);
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo com placa " + placaVeiculo + " não encontrado.");
        }

        if (veiculo.getEstado() != Estado.DISPONIVEL) {
            throw new IllegalArgumentException("Veículo com placa " + placaVeiculo + " não pode ser vendido. Estado atual: " + veiculo.getEstado());
        }

        veiculo.vender();
        veiculoRepository.atualizar(veiculo);
        System.out.println("Veículo " + placaVeiculo + " vendido com sucesso.");
    }
    
    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.listarTodos();
    }
    
       public List<Veiculo> filtrarVeiculos(Class<? extends Veiculo> tipoClasse, Marca marca, Categoria categoria, Estado estado) {
        List<Veiculo> resultado = veiculoRepository.listarTodos();

        if (tipoClasse != null) {
            resultado = resultado.stream()
                    .filter(tipoClasse::isInstance)
                    .collect(Collectors.toList());
        }
        if (marca != null) {
            resultado = resultado.stream()
                    .filter(v -> v.getMarca() == marca)
                    .collect(Collectors.toList());
        }
        if (categoria != null) {
            resultado = resultado.stream()
                    .filter(v -> v.getCategoria() == categoria)
                    .collect(Collectors.toList());
        }
        if (estado != null) {
            resultado = resultado.stream()
                    .filter(v -> v.getEstado() == estado)
                    .collect(Collectors.toList());
        }
        return resultado;
    }

    public boolean clientePossuiLocacaoAtiva(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        
        return veiculoRepository.listarTodos().stream()
                .filter(v -> v.getEstado() == Estado.LOCADO)
                .anyMatch(v -> v.getLocacao() != null && Objects.equals(v.getLocacao().getCliente().getCpf(), cliente.getCpf()));
    }
    
}
