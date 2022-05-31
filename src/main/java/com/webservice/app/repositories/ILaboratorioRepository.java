package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Laboratorio;


@Repository("laboratorioRepository")
public interface ILaboratorioRepository extends JpaRepository<Laboratorio, Serializable>{

}
