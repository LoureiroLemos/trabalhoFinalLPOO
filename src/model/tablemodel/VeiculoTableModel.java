/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tablemodel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import model.Automovel;
import model.Motocicleta;
import model.Van;
import model.Veiculo;

/**
 *
 * @author loure
 */
public class VeiculoTableModel extends AbstractTableModel {
    
    private List<Veiculo> veiculos = new ArrayList<>();
    
    private final String[] colunas = {"Tipo", "Marca", "Modelo", "Placa", "Ano", "Estado", "Categoria", "Valor Venda", "Valor Diaria"};

    @Override
    public int getRowCount() {
        return veiculos.size();
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
        Veiculo v = veiculos.get(rowIndex);
        
        switch(columnIndex){
            case 0 -> { 
                if (v instanceof Automovel) return "Automóvel";
                if (v instanceof Motocicleta) return "Motocicleta";
                if (v instanceof Van) return "Van";
                return "Outro";
            }
            case 1 -> {
                return v.getMarca();
            }
            case 2 -> {
                if (v instanceof Automovel) return ((Automovel) v).getModelo();
                if (v instanceof Motocicleta) return ((Motocicleta)v).getModelo();
                if (v instanceof Van) return ((Van)v).getModelo();
                return "N/A";
            }
            case 3 -> {
                return v.getPlaca();
            }
            case 4 -> {
                return v.getAno();
            }
            case 5 -> {
                return v.getEstado();
            }
            case 6 -> {
                return v.getCategoria();
            }
            case 7 -> {
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                return nf.format(v.getValorParaVenda());
            }
            case 8 -> {
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                return nf.format(v.getValorDiariaLocacao());
            }
            default -> {       
                return null;
            }
        }
    }
    
    public void adicionar(Veiculo v){
        veiculos.add(v);
        fireTableRowsInserted(veiculos.size() - 1, veiculos.size() - 1);
    }

    public void remover(int linha) {
        veiculos.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }

    public Veiculo getVeiculo(int linha) {
        return veiculos.get(linha);
    }

    public List<Veiculo> getTodos() {
        return veiculos;
    }

    public void limpar() {
        veiculos.clear();
        fireTableDataChanged();
    }

    public void setVeiculos(List<Veiculo> novaLista) {
        this.veiculos = novaLista;
        fireTableDataChanged();
    }
}
