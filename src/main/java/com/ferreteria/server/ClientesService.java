package com.ferreteria.server;

import com.ferreteria.persistance.entity.ClientesEntity;
import com.ferreteria.persistance.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

 private final ClientesRepository clientesRepository;

 @Autowired
 public ClientesService(ClientesRepository clientesRepository) {
  this.clientesRepository = clientesRepository;
 }


 public List<ClientesEntity> getAll(){
  return clientesRepository.findAll();
 }

 public ClientesEntity findByTelefono(String telefono) {
  return clientesRepository.findByTelefono(telefono);
 }

 public ClientesEntity findByName(String nombre){
  return clientesRepository.findAllByNombre(nombre);
 }

 public ClientesEntity findByApellido(String apellido) {
  return clientesRepository.findByApellido(apellido);
 }

 public ClientesEntity save(ClientesEntity cliente){
  return clientesRepository.save(cliente);
 }
 public boolean IfExistClienteById(int idCliente){
  Optional<ClientesEntity> clientes = clientesRepository.findById(idCliente);
  return clientes.isPresent();
 }

 public ClientesEntity findByEmail(String email){
  return clientesRepository.findByEmail(email);
 }

//                                CRUD     Method

 public ClientesEntity findById(int idCliente) {
  return clientesRepository.findById(idCliente).orElse(null);
 }

 public void deleteById(int idCliente) {
  clientesRepository.deleteById(idCliente);
 }

}
