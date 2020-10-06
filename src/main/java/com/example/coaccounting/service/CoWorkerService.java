package com.example.coaccounting.service;

import com.example.coaccounting.model.CoWorker;
import com.example.coaccounting.repository.CoWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoWorkerService {
    private final CoWorkerRepository coWorkerRepository;

    @Autowired
    public CoWorkerService(CoWorkerRepository coWorkerRepository) {
        this.coWorkerRepository = coWorkerRepository;
    }

    public CoWorker findById(Integer id) {
        return coWorkerRepository.getOne(id);
    }

    public List<CoWorker> findAll() {
        return coWorkerRepository.findAll();
    }

    public CoWorker saveCoWorker(CoWorker coWorker) {
        return coWorkerRepository.save(coWorker);
    }

    public void deleteById(Integer id) {
        coWorkerRepository.deleteById(id);
    }

}
