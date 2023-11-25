package com.example.FatecPi.Repo;

import com.example.FatecPi.Entity.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepo extends MongoRepository<Empresa, String> {
    List<Empresa> findByMaterialIn(List<String> material);
}
