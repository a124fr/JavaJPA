package model.tests;

import model.bean.Categoria;
import model.bean.Produto;
import model.dao.ProdutoDAO;

public class ProdutoTest {
    public static void main(String[] args) {
        /*Categoria categoria = new Categoria();
        categoria.setId(1);
                        
        Produto produto = new Produto();        
        produto.setDescricao("Coca-Cola");
        produto.setCategoria(categoria);
        produto.setQtd(10);
        produto.setValor(7.89);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.save(produto);
        */
        /*
        Categoria categoria = new Categoria();
        categoria.setId(2);
                        
        Produto produto = new Produto();        
        produto.setId(1);
        produto.setDescricao("Arroz");
        produto.setCategoria(categoria);
        produto.setQtd(100);
        produto.setValor(14.30);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.save(produto);
        */
        
        ProdutoDAO dao = new ProdutoDAO();
        Produto p = dao.findById(1);
        System.out.println("Produto: " + p.getDescricao() 
                + " Categoria: " + p.getCategoria().getDescricao());
                
    }
}
