package com.example.prix.data;

import com.example.prix.model.Prix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrixDAO extends JpaRepository<Prix,Long>{
}
