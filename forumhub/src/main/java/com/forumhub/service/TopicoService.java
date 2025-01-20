package com.forumhub.service;

import com.forumhub.model.Topico;
import com.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> buscarPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico salvar(Topico topico) {
        return topicoRepository.save(topico);
    }

    public void excluir(Long id) {
        topicoRepository.deleteById(id);
    }
}
