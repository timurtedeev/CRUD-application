package net.proselyte.console.repository;

import net.proselyte.console.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Human class.
 */
public interface HumanRepository extends JpaRepository<Human,Long> {
}
