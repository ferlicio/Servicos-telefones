package com.Servicos.Services;

import com.Servicos.Repositories.ClienteRepository;
import com.Servicos.Repositories.TelefoneRepository;
import com.Servicos.Models.Cliente;
import com.Servicos.Models.Telefone;
import com.Servicos.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public List<Telefone> mostrarTodosTelefones(){
        return telefoneRepository.findAll();	}

    public Telefone mostrarUmTelefone(Integer idTelefone) {
        Optional<Telefone> telefone = telefoneRepository.findById(idTelefone);
        return telefone.orElseThrow(
                () -> new EntityNotFoundException("Telefone não cadastrado: " + idTelefone)
        );
    }

    public List<Telefone> buscarTelefonesPeloCliente(Integer idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return telefoneRepository.findByCliente(cliente);

    }

    public Telefone cadastrarTelefone(Telefone telefone, Integer idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        telefone.setCliente(cliente.get());
        return telefoneRepository.save(telefone);
    }

    public Telefone editarTelefone(Telefone telefone, Integer idTelefone){

        Telefone telefoneSemAsNovasAlteracoes = mostrarUmTelefone(idTelefone);
        Cliente cliente = telefoneSemAsNovasAlteracoes.getCliente();

        telefone.setCliente(cliente);

        return telefoneRepository.save(telefone);
    }

    public void excluirTelefone(Integer idTelefone){
        telefoneRepository.deleteById(idTelefone);
    }

}
