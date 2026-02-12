package org.ust.prop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ust.prop.model.Prop;
@Repository

public interface PropRepository extends JpaRepository<Prop, Long> {

}
