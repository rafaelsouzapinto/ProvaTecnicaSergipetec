package dev.rafael.ProvaSergipetec.repository;

import dev.rafael.ProvaSergipetec.model.ServidorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServidorRepository extends JpaRepository<ServidorModel,Long> {

    Optional<ServidorModel> findByMatriculaAndSenha(String matricula, String senha);
}
