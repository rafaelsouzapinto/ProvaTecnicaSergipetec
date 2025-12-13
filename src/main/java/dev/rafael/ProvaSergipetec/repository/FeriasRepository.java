package dev.rafael.ProvaSergipetec.repository;

import dev.rafael.ProvaSergipetec.model.FeriasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeriasRepository extends JpaRepository<FeriasModel, Long> {

    List<FeriasModel> findByServidorId(Long servidorId);
}
