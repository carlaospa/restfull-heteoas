package com.carlaospa.restfull.repostory;

import com.carlaospa.restfull.entity.SoldadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldadoRepository extends JpaRepository<SoldadoEntity, Long> {
}
