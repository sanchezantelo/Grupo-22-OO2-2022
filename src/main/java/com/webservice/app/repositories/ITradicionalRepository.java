package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Tradicional;


@Repository("tradicionalRepository")
public interface ITradicionalRepository extends JpaRepository<Tradicional, Serializable>{

}
