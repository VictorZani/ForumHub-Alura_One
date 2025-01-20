package com.forumhub.service;

import com.forumhub.model.Curso;
import com.forumhub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }
}
