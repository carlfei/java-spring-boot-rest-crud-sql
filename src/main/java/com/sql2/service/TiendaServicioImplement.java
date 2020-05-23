package com.sql2.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sql2.repository.TiendaRepositorio;

@Service("tiendaServicio")
public class TiendaServicioImplement implements TiendaServicio {

	@Autowired
	private TiendaRepositorio tiendaRepositorio;

	@Override
	public Boolean deleteAllCalleWithName(String calle) {

		try {
			tiendaRepositorio.deleteAllTiendaByCalleNameInQuery(calle);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateTienda(String calle, Integer id) {

		try {

			tiendaRepositorio.updateCalleTiendaByIdQuery(calle, id);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
