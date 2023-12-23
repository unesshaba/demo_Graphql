package org.sid.videoservice.repositories;

import org.sid.videoservice.entities.Vedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VedioRepository extends JpaRepository<Vedio,Long> {
}
