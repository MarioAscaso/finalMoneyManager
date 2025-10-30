package com.daw.finalmoneymanager.shared.infraestructure;

import com.daw.finalmoneymanager.shared.domain.Movement;
import com.daw.finalmoneymanager.shared.domain.MovementRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementRepository extends JpaRepository<Movement, Long>, MovementRepository {
}
