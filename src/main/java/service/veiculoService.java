package service;

import entity.VeiculoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.veiculoRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class veiculoService {

    @Autowired
    private static veiculoRepository veiculoRepository;
    public List<VeiculoEntity> listar() {
        return veiculoRepository.findAll();
    }

    public static VeiculoEntity buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado"));
    }

    public static VeiculoEntity criar(VeiculoEntity veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public static VeiculoEntity atualizar(Long id, VeiculoEntity veiculoAtualizado) {
        VeiculoEntity veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado"));
        veiculoExistente.setNomeVeiculo(veiculoAtualizado.getNomeVeiculo());
        return veiculoRepository.save(veiculoExistente);
    }

    public static void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}
