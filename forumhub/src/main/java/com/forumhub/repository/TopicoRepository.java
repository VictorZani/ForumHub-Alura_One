package com.forumhub.repository;

import com.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // Métodos personalizados, se necessário
}
