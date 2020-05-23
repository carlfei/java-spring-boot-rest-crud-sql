package com.sql2.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sql2.domain.Tienda;

@Repository
public interface TiendaRepositorio extends JpaRepository<Tienda, Integer> {

	@Query(value = "SELECT * FROM tienda WHERE calle=?1", nativeQuery = true)
	Collection<Tienda> findByTiendaWithName(@Param("calle") String calle);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tienda WHERE calle=?1", nativeQuery = true)
	void deleteAllTiendaByCalleNameInQuery(@Param("calle") String calle);

	@Modifying
	@Transactional
	@Query(value = "UPDATE tienda set calle=?1 where idt=?2", nativeQuery = true)
	void updateCalleTiendaByIdQuery(@Param("calle") String calle, @Param("id") Integer id);

}
