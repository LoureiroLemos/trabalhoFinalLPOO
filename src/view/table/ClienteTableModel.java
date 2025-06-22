/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author loure
 */
public class ClienteTableModel extends AbstractTableModel {
    
    private List<Cliente> clientes = new ArrayList<>();
    private String[] colunas = {"Nome", "Sobrenome", "RG", "CPF", "Endereço"};

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column){
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
    
    public void adicionar(Cliente cliente){
        clientes.add(cliente);
        fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
    }
    
    public void remover(int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public void atualizar (int indice, Cliente cliente){
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);
    }
    
    public Cliente getCliente(int indice){
        return clientes.get(indice);
    }
    
    public List<Cliente> getTodos(){
        return clientes;
    }
    
    public void limpar(){
        clientes.clear();
        fireTableDataChanged();
    }
    
    
    
}
