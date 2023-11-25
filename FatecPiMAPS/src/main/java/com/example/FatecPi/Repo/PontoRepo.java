package com.example.FatecPi.Repo;

import com.example.FatecPi.Entity.Ponto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PontoRepo extends MongoRepository<Ponto, String> {
    List<Ponto> findByMaterialPontoIn(List<String> materialPonto);
}
