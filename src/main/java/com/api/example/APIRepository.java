

package com.api.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   APIRepository  extends JpaRepository<PersonEntity, Long> {}


