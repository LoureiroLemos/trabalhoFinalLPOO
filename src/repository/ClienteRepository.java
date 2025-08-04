/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.Cliente;

/**
 *
 * @author loure
 */
public class ClienteRepository {

    private static ClienteRepository instance;
    private List<Cliente> clientes;

    public ClienteRepository(){
        this.clientes = new ArrayList<>();

//        adicionar(new Cliente("João", "Silva", "112233445", "12345678901", "Rua A, 123" ));
//        adicionar(new Cliente("Maria", "Souza", "987654321", "10987654321", "Rua B, 456" ));
//        adicionar(new Cliente("Carlos", "Souza", "111222333", "123123123123", "Rua C, 789" ));
    }
    
    public static ClienteRepository getInstance() {
        if (instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }


    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }
    
    
    public List<Cliente> getTodos() {
        return clientes;
    }

    public List<Cliente> listarTodos(){
        return new ArrayList<>(clientes);
    }

    public Cliente buscarPorCpf(String cpf){
        for(Cliente c : clientes) {
            if (Objects.equals(c.getCpf(), cpf)){
                return c;
            }
        }
        return null;
    }

    public Cliente buscarPorRg(String rg) {
        for (Cliente c : clientes){
            if (Objects.equals(c.getRg(), rg)){
                return c;
            }
        }
        return null;
    }

    public List<Cliente> buscarPorNome(String nome){
        return clientes.stream().filter( c -> c.getNome().equalsIgnoreCase(nome)).collect(Collectors.toList());
    }

    public List<Cliente> buscarPorSobrenome(String sobrenome){
        return clientes.stream().filter( c -> c.getSobrenome().equalsIgnoreCase(sobrenome)).collect(Collectors.toList());
    }

    public boolean atualizar(Cliente clienteAtualizado){
        for (int i = 0; i< clientes.size(); i++){
            Cliente c = clientes.get(i);
            if(Objects.equals(c.getCpf(), clienteAtualizado.getCpf())){
                clientes.set(i, clienteAtualizado);
                System.out.println("Cliente com CPF '" + clienteAtualizado.getCpf() + "' atualizado");
                return true;
            }
        }
        System.out.println("Erro: Cliente com CPF '" + clienteAtualizado.getCpf() + "' não encontrado");
        return false;
    }

    public boolean remover(Cliente clienteParaRemover){
        if(clientes.remove(clienteParaRemover)){
            System.out.println("Cliente " + clienteParaRemover.getNome() + " removido.");
            return true;
        }
        System.out.println("Erro: Cliente " + clienteParaRemover.getNome() + " não encontrado.");
        return false;
    }

}
