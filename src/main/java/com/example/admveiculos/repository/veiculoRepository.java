package com.example.admveiculos.repository;

import com.example.admveiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface veiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByMarcaAno(String marca, String ano);
}
