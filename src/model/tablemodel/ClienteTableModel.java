/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Cliente;

/**
 *
 * @author loure
 */

public class ClienteTableModel extends AbstractTableModel {

    private final String[] colunas = {"Nome", "Sobrenome", "RG", "CPF", "Endereço"};
    private List<Cliente> clientes;

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ClienteTableModel() {
        this.clientes = new ArrayList<>(); 
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = clientes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> c.getNome();
            case 1 -> c.getSobrenome();
            case 2 -> c.getRg();
            case 3 -> c.getCpf();
            case 4 -> c.getEndereco();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Permitir editar todas as células, ou só algumas
        return false; // aqui vamos editar só pelos campos da tela, não direto na tabela
    }

    // Método para atualizar dados do cliente na lista e avisar a tabela
    public void atualizarCliente(int rowIndex, Cliente clienteAtualizado) {
        clientes.set(rowIndex, clienteAtualizado);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    // Método para remover cliente da lista e atualizar tabela
    public void removerCliente(int rowIndex) {
        clientes.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Cliente getClienteAt(int rowIndex) {
        return clientes.get(rowIndex);
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
        fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
    }
}

