package controller;

import entity.VeiculoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.veiculoService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class veiculoController {

    @Autowired
    private repository.veiculoRepository veiculoRepository;

    //retorna todos os veiculos
    @GetMapping("/veiculos")
    public List<VeiculoEntity> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    //retorna os veiculos com um parametros passados
    @GetMapping("/veiculos")
    public ResponseEntity<List<VeiculoEntity>> getUsersByParams(@RequestParam(required = false) String marca,
                                                                @RequestParam(required = false) String ano) {
        List<VeiculoEntity> users = veiculoRepository.findByMarcaAno(marca, ano);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    //retorna os dados de um veiculo
    @GetMapping("/veiculos/{id}")
    public VeiculoEntity buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    //criar um novo veiculo
    @PostMapping("/veiculos")
    public VeiculoEntity criar(@RequestBody VeiculoEntity veiculo) {
        return veiculoService.criar(veiculo);
    }

    //atualiza os dados de um veiculo
    @PutMapping("/veiculos/{id}")
    public VeiculoEntity atualizar(@PathVariable Long id, @RequestBody VeiculoEntity veiculoAtualizado) {
        return veiculoService.atualizar(id, veiculoAtualizado);
    }

    //atualiza apenas alguns dados do veiculo
    @PatchMapping("/veiculos/{id}")
    public Optional<Object> atualizarVeiculo(@PathVariable Long id, @RequestBody VeiculoEntity veiculo) {
        Optional<Object> veiculoAtualizado = veiculoRepository.findById(id)
                .map(u -> {
                    u.setNomeVeiculo(veiculo.getNomeVeiculo());
                    u.setAno(veiculo.getAno());
                    return veiculoRepository.save(u);
                });
        return  veiculoAtualizado;
    }


    //Deleta um veiculo
    @DeleteMapping("/veiculos/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
    }

}
