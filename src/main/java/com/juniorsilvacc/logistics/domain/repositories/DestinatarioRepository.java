package com.juniorsilvacc.logistics.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorsilvacc.logistics.domain.models.Destinatario;

public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {

}
