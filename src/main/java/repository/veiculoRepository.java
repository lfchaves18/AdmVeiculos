package repository;

import entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface veiculoRepository extends JpaRepository<VeiculoEntity, Long> {
    List<VeiculoEntity> findByMarcaAno(String marca, String ano);
}
