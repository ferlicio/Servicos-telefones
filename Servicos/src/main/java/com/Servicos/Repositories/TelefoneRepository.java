package com.Servicos.Repositories;

import com.Servicos.Models.Cliente;
import com.Servicos.Models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone,Integer> {

    List<Telefone> findByCliente(Optional<Cliente> cliente);

}
