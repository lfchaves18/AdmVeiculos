package com.example.admveiculos.service;

import com.example.admveiculos.entity.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class veiculoService {

    @Autowired
    private static com.example.admveiculos.repository.veiculoRepository veiculoRepository;
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public static Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado"));
    }

    public static Veiculo criar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public static Veiculo atualizar(Long id, Veiculo veiculoAtualizado) {
        Veiculo veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado"));
        veiculoExistente.setNomeVeiculo(veiculoAtualizado.getNomeVeiculo());
        return veiculoRepository.save(veiculoExistente);
    }

    public static void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}
