package com.ferreteria.web.controller;

import com.ferreteria.persistance.entity.ClientesEntity;
import com.ferreteria.server.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClientesService clientesService;

    @Autowired
    public ClienteController(ClientesService clientesService){
        this.clientesService = clientesService;
    }



    // Obtener todos los clientes
    @GetMapping("/todos")
    public ResponseEntity<List<ClientesEntity>> getAll(){
        List<ClientesEntity> clientes = clientesService.getAll();
        return ResponseEntity.ok(clientes);
    }

    // Obtener cliente por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ClientesEntity> findByName(@PathVariable String nombre) {
        ClientesEntity cliente = this.clientesService.findByName(nombre);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener cliente por apellido
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<ClientesEntity> findByApellido(@PathVariable String apellido){
        ClientesEntity cliente = this.clientesService.findByApellido(apellido);
        if (cliente != null){
            return ResponseEntity.ok(cliente);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener cliente por email
    @GetMapping("/email/{email}")
    public ResponseEntity<ClientesEntity>findByEmail(@PathVariable String email){
        ClientesEntity cliente = this.clientesService.findByEmail(email);
        if (cliente != null){
            return ResponseEntity.ok(cliente);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener cliente por teléfono
    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<ClientesEntity> getByTelefono(@PathVariable String telefono){
        ClientesEntity cliente = this.clientesService.findByTelefono(telefono);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //                          Méthods             CRUD                          //

    @PostMapping("/crear")
    public ResponseEntity<ClientesEntity> crearCliente(@RequestBody ClientesEntity cliente) {
        ClientesEntity clienteCreado = clientesService.save(cliente);
        return ResponseEntity.ok(clienteCreado);
    }

    @GetMapping("/read/{idCliente}")
    public ResponseEntity<ClientesEntity> getById(@PathVariable int idCliente){
        ClientesEntity cliente = this.clientesService.findById(idCliente);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{idCliente}")
    public ResponseEntity<ClientesEntity> updateCliente(@PathVariable int idCliente, @RequestBody ClientesEntity updateCliente) {
        boolean existeCliente = clientesService.IfExistClienteById(idCliente);
        if (existeCliente) {
            updateCliente.setIdCliente(idCliente);
            ClientesEntity clienteActualizado = clientesService.save(updateCliente);
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int idCliente) {
        boolean existeCliente = clientesService.IfExistClienteById(idCliente);
        if (existeCliente) {
            clientesService.deleteById(idCliente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
/*
{
   "nombre": "Llave de tubo",
   "descripcion": "Llave de tubo de acero cromado",
   "precio": 24.50,
   "stock": 60
}
 */