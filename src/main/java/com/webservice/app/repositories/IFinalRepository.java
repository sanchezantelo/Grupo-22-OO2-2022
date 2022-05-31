package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.app.entities.Final;

@Repository("finalRepository")
public interface IFinalRepository extends JpaRepository<Final, Serializable> {

}
