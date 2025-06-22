/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Cliente;
import repository.ClienteRepository;

/**
 *
 * @author loure
 */
public class ClienteService {
    
    private ClienteRepository clienteRepository;
    private VeiculoService veiculoService;
    
    public ClienteService(ClienteRepository clienteRepository, VeiculoService veiculoService){
        this.clienteRepository = clienteRepository;
        this.veiculoService = veiculoService;
    }
    
    public void cadastrarCliente(String nome, String sobrenome, String rg, String cpf, String endereco) throws IllegalArgumentException {
        if(nome == null || nome.trim().isEmpty() ||
           sobrenome == null || sobrenome.trim().isEmpty() ||
           rg == null || rg.trim().isEmpty() ||
           cpf == null || cpf.trim().isEmpty() ||
           endereco == null || endereco.trim().isEmpty()){
            throw new IllegalArgumentException("Todos os campos dio cliente são obrigatórios.");
        }
        
        if (clienteRepository.buscarPorCpf(cpf) != null){
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este CPF.");
        }
        
        if (clienteRepository.buscarPorRg(rg) != null){
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este RG.");
        }
        
        Cliente novoCliente = new Cliente(nome, sobrenome, rg, cpf, endereco);
        clienteRepository.adicionar(novoCliente);
        System.out.println("Cliente '" + nome + " " + sobrenome + "' cadastrado com sucesso.");
    }
    
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.listarTodos();
    }
    
    public void atualizarCliente(Cliente clienteAtualizado) throws IllegalArgumentException {
        if (clienteAtualizado == null || clienteAtualizado.getCpf() == null || clienteAtualizado.getCpf().trim().isEmpty()){
            throw new IllegalArgumentException ("Dados do cliente para atualização invalidos. CPF é necessário.");
        }
        
        if (!clienteRepository.atualizar(clienteAtualizado)){
            throw new IllegalArgumentException ("Cliente com CPF '" + clienteAtualizado.getCpf() + "' não encontrado para atualização");
        }
        System.out.println("Cliente com CPF '" + clienteAtualizado.getCpf() + "' atualizado.");
    }
    
    public void excluirCliente(Cliente clienteParaExcluir) throws IllegalArgumentException{
        if (clienteParaExcluir == null){
            throw new IllegalArgumentException("Cliente para exclusão não pode ser nulo.");
        }
        
        if(veiculoService.clientePossuiLocacaoAtiva(clienteParaExcluir)){
            throw new IllegalArgumentException("Não é possível excluir o cliente '" + clienteParaExcluir.getNome() + "'. Ele possui um veículo locado.");
        }
        
        if (!clienteRepository.remover(clienteParaExcluir)) {
            throw new IllegalArgumentException("Cliente com CPF '" + clienteParaExcluir.getCpf() + "' não encontrado para exclusão.");
        }
        System.out.println("Cliente '" + clienteParaExcluir.getNome() + " " + clienteParaExcluir.getSobrenome() + "' excluído com sucesso.");
    }
    
    public Cliente buscarClientePorCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF para busca não pode ser vazio.");
        }
        return clienteRepository.buscarPorCpf(cpf);
    }
    
    public List<Cliente> buscarClientesPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome para busca não pode ser vazio.");
        }
        return clienteRepository.buscarPorNome(nome);
    }
    

    public List<Cliente> buscarClientesPorSobrenome(String sobrenome) {
        if (sobrenome == null || sobrenome.trim().isEmpty()) {
            throw new IllegalArgumentException("O sobrenome para busca não pode ser vazio.");
        }
        return clienteRepository.buscarPorSobrenome(sobrenome);
    }
        
}