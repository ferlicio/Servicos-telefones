package com.Servicos.Repositories;

import com.Servicos.Models.Cliente;
import com.Servicos.Models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {

    @Query(value = "SELECT * FROM cliente WHERE nm_nome =:nm_cliente",nativeQuery = true )
    List<Cliente> findByNome(String nm_cliente);

    @Query(value = "SELECT * FROM cliente WHERE nm_email =:nm_email",nativeQuery = true )
    Optional<Cliente> findByEmail(String nm_email);

    @Query(value = "SELECT * FROM cliente WHERE nm_cidade =:nm_cidade",nativeQuery = true )
    List<Cliente> findByCidade(String nm_cidade);

    @Query(value = "SELECT * FROM cliente WHERE id =:cliente_id",nativeQuery = true )
    List<Cliente> findByTelefone(Integer cliente_id);

}
