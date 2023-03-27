package com.example.admveiculos.controller;

import com.example.admveiculos.entity.Veiculo;
import com.example.admveiculos.service.veiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class veiculoController {

    @Autowired
    private com.example.admveiculos.repository.veiculoRepository veiculoRepository;

    //retorna todos os veiculos
    @GetMapping("/veiculos")
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    //retorna os veiculos com um parametros passados
    @GetMapping("/veiculos")
    public ResponseEntity<List<Veiculo>> getUsersByParams(@RequestParam(required = false) String marca,
                                                                @RequestParam(required = false) String ano) {
        List<Veiculo> users = veiculoRepository.findByMarcaAno(marca, ano);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    //retorna os dados de um veiculo
    @GetMapping("/veiculos/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    //criar um novo veiculo
    @PostMapping("/veiculos")
    public Veiculo criar(@RequestBody Veiculo veiculo) {
        return veiculoService.criar(veiculo);
    }

    //atualiza os dados de um veiculo
    @PutMapping("/veiculos/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoService.atualizar(id, veiculoAtualizado);
    }

    //atualiza apenas alguns dados do veiculo
    @PatchMapping("/veiculos/{id}")
    public Optional<Object> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
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
