package com.example.Aprendendo.service;

import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.Aprendendo.exceptions.RecursoNaoEncontradoException;
import com.example.Aprendendo.model.Produto;
import com.example.Aprendendo.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {

        if(!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado.");
        }
        
        produtoRepository.deleteById(id);
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado.")); 
        }

    
}
