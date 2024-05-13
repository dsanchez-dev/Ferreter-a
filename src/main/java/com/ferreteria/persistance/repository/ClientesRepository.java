package com.ferreteria.persistance.repository;

import com.ferreteria.persistance.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientesRepository extends JpaRepository<ClientesEntity,Integer> {


    List<ClientesEntity> findAll();

    @Query(value = "SELECT c FROM  ClientesEntity c WHERE  c.email=:email")
    ClientesEntity findByEmail(@Param("email")String email);


    @Query(value = "SELECT c FROM ClientesEntity c WHERE c.telefono =:telefono")
    ClientesEntity findByTelefono(@Param("telefono") String telefono);

    @Query(value = "SELECT c FROM ClientesEntity c WHERE c.nombre =:nombre")
    ClientesEntity findAllByNombre(@Param("nombre")String nombre);

    @Query(value = "SELECT c From ClientesEntity c WHERE c.apellido = :apellido")
    ClientesEntity findByApellido(@Param("apellido") String apellido);

    @Modifying
    @Query("UPDATE ClientesEntity c SET c.nombre = :nuevoNombre WHERE c.idCliente = :idCliente")
    void updateByIdCliente(@Param("idCliente") int idCliente, @Param("nuevoNombre") String nuevoNombre);

    @Modifying
    @Query("DELETE FROM ClientesEntity c WHERE c.idCliente =: idCliente")
    void deleteByIdCliente(@Param("idCliente") int idCliente);




}
