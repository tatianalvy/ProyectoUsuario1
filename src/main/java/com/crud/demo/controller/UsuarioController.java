package com.crud.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.Usuario;
import com.crud.demo.services.IUsuarioService;

@RestController
@RequestMapping("/apis")
public class UsuarioController {
	@Autowired 
	private IUsuarioService Servi;
	
	@GetMapping("/listado")
	public Object listadoproveedor() {
		return Servi.listarTodo();

	}
	
	// buscar por id
		@GetMapping("/listadoID/{id}")
		public Usuario show(@PathVariable Long id) {
			return Servi.buscarPorID(id);
		}

		// guardar 
		@PostMapping("/IngresarUsuario")
		@ResponseStatus(HttpStatus.CREATED)
		public Usuario create(@RequestBody Usuario provee) {
			return Servi.save(provee);
		}

		// editar 

		@PutMapping("/editarUsuario/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
			Usuario uActual = Servi.buscarPorID(id);
			uActual.setNombre(usuario.getNombre());
			uActual.setEmail(usuario.getEmail());
			uActual.setClave(usuario.getClave());
			uActual.setEstado(usuario.getEstado());
			
			
			return Servi.save(usuario);
		}

		//eliminar
		@DeleteMapping("/eliminarID/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void Eliminar(@PathVariable("id") Long id) {
			Servi.Eliminar(id);
		}
		
		
		
	
}
