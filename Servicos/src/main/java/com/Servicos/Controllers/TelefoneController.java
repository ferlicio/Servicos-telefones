package com.Servicos.Controllers;

import com.Servicos.Models.Telefone;
import com.Servicos.Services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class TelefoneController {

    @Autowired
    TelefoneService telefoneService;

    @GetMapping("/telefones")
    public List<Telefone> mostrarTodosTelefones(){
        List<Telefone> telefones = telefoneService.mostrarTodosTelefones();
        return telefones;
    }

    @GetMapping("/telefones/{idTelefone}")
    public ResponseEntity<Telefone> buscarUmTelefone(@PathVariable Integer idTelefone){
        Telefone telefone  = telefoneService.mostrarUmTelefone(idTelefone);
        return ResponseEntity.ok().body(telefone);

    }

    @GetMapping("/telefonesPeloCliente/{idCliente}")
    public List<Telefone> buscarTelefonesPeloCliente(@PathVariable Integer idCliente){
        List<Telefone> telefones = telefoneService.buscarTelefonesPeloCliente(idCliente);
        return telefones;
    }

    @PostMapping("/telefones/{idCliente}")
    public ResponseEntity<Telefone> cadastrarTelefone(@PathVariable Integer idCliente,
                                                    @RequestBody Telefone telefone){
        telefone = telefoneService.cadastrarTelefone(telefone,idCliente);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(novaUri).body(telefone);
    }

    @PutMapping("/telefones/{idTelefone}")
    public ResponseEntity<Telefone> editarTelefone(@PathVariable Integer idTelefone,
                                                 @RequestBody Telefone telefone){
        telefone.setId(idTelefone);
        telefoneService.editarTelefone(telefone, idTelefone);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/telefones/{idTelefone}")
    public ResponseEntity<Void> excluirTelefone(@PathVariable Integer idTelefone){
        telefoneService.excluirTelefone(idTelefone);
        return ResponseEntity.noContent().build();
    }

}
