package com.sql2.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sql2.repository.TiendaRepositorio;
import com.sql2.service.TiendaServicio;

import com.sql2.domain.Tienda;

@RestController
public class DataBaseController {

	@Autowired
	TiendaRepositorio tiendaRepositorio;

	@Autowired
	TiendaServicio tiendaServicio;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicion() {

		return "<fieldset> <legend>Spring boot</legend><br>"
				+ " <a href='http://127.0.0.1:9090/show'>Listar la tabla</a>  <br> "
				+ "<a href='http://127.0.0.1:9090/insert/(calle)/(numero)/(distrito)/(cp)/'>Insertar</a> <br>"
				+ " <a href='http://127.0.0.1:9090/deletebyid/(id)'>Borrar por ID</a>  <br>"
				+ " <a href='http://127.0.0.1:9090/findbycalle/(calle)'>Buscar por calle</a>  <br> "

				+ "<a href='http://127.0.0.1:9090/updateCalleById/(calle)/(id)'>Cambiar calle por ID</a>      </fieldset>\";";

	}

	@RequestMapping(value = "findbyid/{id}", method = RequestMethod.GET)
	public Tienda bucaId(@PathVariable Integer id) {

		return tiendaRepositorio.findById(id).get();

	}

	@RequestMapping(value = "deletebyid/{id}", method = RequestMethod.GET)
	public String deleteId(@PathVariable Integer id) {

		try {
			tiendaRepositorio.deleteById(id);
			return "OK";
		} catch (Exception e) {
			return "FAIL";
		}

	}

	@RequestMapping(value = "insert/{calle}/{numero}/{distrito}/{cp}", method = RequestMethod.GET)
	public Tienda meteDentro(@PathVariable String calle, @PathVariable String numero, @PathVariable String distrito,
			@PathVariable Integer cp) {

		Tienda seterTienda = new Tienda();

		seterTienda.setCalle(calle);
		seterTienda.setNumero(numero);
		seterTienda.setDistrito(distrito);
		seterTienda.setCp(cp);
		return tiendaRepositorio.saveAndFlush(seterTienda);

	}

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public List<Tienda> showDataBase() {

		return tiendaRepositorio.findAll();

	}

	@RequestMapping(value = "findbycalle/{calle}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Collection<Tienda>> getCalleByName(@Valid @PathVariable("calle") final String calle) {

		Collection<Tienda> tiendaCollection = tiendaRepositorio.findByTiendaWithName((calle));

		return new ResponseEntity<Collection<Tienda>>(tiendaCollection, HttpStatus.OK);

	}

	@RequestMapping(value = "deletebycalle/{calle}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllProblem(@Valid @PathVariable("calle") final String calle) {

		if (!tiendaServicio.deleteAllCalleWithName(calle))
			return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "updateCalleById/{calle}/{id}", method = RequestMethod.GET)
	public Tienda updateCalle(@Valid @PathVariable("calle") String calle, @Valid @PathVariable("id") Integer id) {

		if (!tiendaServicio.updateTienda(calle, id))
			return tiendaRepositorio.findById(id).get();

		return tiendaRepositorio.findById(id).get();

	}

}
