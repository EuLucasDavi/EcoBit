package com.example.FatecPi.Controller;

import com.example.FatecPi.Entity.Empresa;
import com.example.FatecPi.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmpresaCadController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEmpresa(@ModelAttribute Empresa empresa) {
        boolean cadastroValido = empresaService.saveorUpdate(empresa);

        if (cadastroValido) {
            return ResponseEntity.ok().build(); // Operação bem-sucedida (código 200)
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Falha na operação (código 500)
        }
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Iterable<Empresa> getEmpresas() {
        return empresaService.listAll();
    }

    @GetMapping("/edit/{id}")
    public String getEmpresaById(@PathVariable(name = "id") String _id, Model model) {
        Empresa empresa = empresaService.getEmpresaById(_id);
        model.addAttribute("empresa", empresa);
        return "local";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmpresa(@PathVariable("id") String _id) {
        empresaService.deleteEmpresa(_id);
    }

    @GetMapping("/procura")
    public String getEmpresasByMaterial(@RequestParam(name = "material", required = false) List<String> materiais, Model model) {
        List<Empresa> empresas = empresaService.findEmpresasByMateriais(materiais);
        model.addAttribute("empresas", empresas);
        return "resultadoEmpresa";
    }
}
