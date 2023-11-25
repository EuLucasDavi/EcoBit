package com.example.FatecPi.Service;

import com.example.FatecPi.Entity.Empresa;
import com.example.FatecPi.Repo.EmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepo repo;

    public boolean saveorUpdate(Empresa empresa) {
        try {
            repo.save(empresa);
            return true; // Cadastro bem-sucedido
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Falha no cadastro
        }
    }

    public Iterable<Empresa> listAll() {
        return this.repo.findAll();
    }

    public void deleteEmpresa(String id) {
        repo.deleteById((id));
    }

    public Empresa getEmpresaById(String empresaid) {
        return repo.findById(empresaid).get();
    }

    public List<Empresa> findEmpresasByMateriais(List<String> materiais) {
        return repo.findByMaterialIn(materiais);
    }

}
