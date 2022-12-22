package com.juniorsilvacc.logistics.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorsilvacc.logistics.domain.models.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

}
