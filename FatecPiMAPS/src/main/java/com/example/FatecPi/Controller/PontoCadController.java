package com.example.FatecPi.Controller;


import com.example.FatecPi.Entity.Empresa;
import com.example.FatecPi.Entity.Ponto;
import com.example.FatecPi.Service.PontoService;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class PontoCadController {
    @Autowired
    private PontoService pontoService;
    
    
     @PostMapping("/savePonto")
    public ResponseEntity<String> savePonto(@ModelAttribute Ponto ponto){

        boolean cadastroValido = pontoService.saveorUpdatePonto(ponto);
        if (cadastroValido) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getAllPonto")
    @ResponseBody
    public Iterable<Ponto> getPontos(){
        return pontoService.listAll();
    }

  @GetMapping("/procurarPonto")
    public String getPontoByMaterial(@RequestParam(name = "materialPonto", required = false)List<String> materialPonto, Model model){
        List<Ponto> ponto = pontoService.findPontoByMaterial(materialPonto);
        model.addAttribute("ponto", ponto);
        return"resultadoPonto";
    }
    
    @GetMapping("/editP/{id}")
    public String getEmpresaById(@PathVariable(name = "id") String _id, Model model) {
        Ponto ponto = pontoService.getPontoById(_id);
        model.addAttribute("ponto", ponto);
        return "localPonto";
    }

}
