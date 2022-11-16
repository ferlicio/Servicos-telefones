package com.Servicos.Services;

import com.Servicos.Models.Cliente;
import com.Servicos.Models.Telefone;
import com.Servicos.Repositories.ClienteRepository;
import com.Servicos.Repositories.TelefoneRepository;
import com.Servicos.Services.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TelefoneRepository telefoneRepository;


    public List<Cliente> mostrarTodosClientes() {

        return clienteRepository.findAll();
    }


    public Cliente mostrarUmCliente(Integer idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente.orElseThrow(
                () -> new EntityNotFoundException("Cliente não cadastrado: " + idCliente)
        );
    }

    public List<Cliente> buscarClientesPeloNome(String nome){
        return clienteRepository.findByNome(nome);
    }

    public Cliente mostrarUmClientePeloEmail(String email){
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        return cliente.orElseThrow();
    }

    public List<Cliente> buscarClientesPelaCidade(String cidade){
        return clienteRepository.findByCidade(cidade);
    }

    public List<Cliente> mostrarClientePorTelefone(Integer idTelefone){
        return clienteRepository.findByTelefone(idTelefone);
    }

    public Cliente inserirCliente(Cliente cliente) {
        cliente.setIdCliente(null);
        return clienteRepository.save(cliente);
    }


    public Cliente editarCliente(Cliente cliente) {
        mostrarUmCliente(cliente.getIdCliente());
        return clienteRepository.save(cliente);
    }


    public void excluirCliente(Integer idCliente) {
        mostrarUmCliente(idCliente);
        clienteRepository.deleteById(idCliente);
    }
}
