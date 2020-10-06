package com.example.coaccounting.service;

import com.example.coaccounting.model.CoWorker;
import com.example.coaccounting.model.Passport;
import com.example.coaccounting.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportService {
    private final PassportRepository passportRepository;

    @Autowired
    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport findById(Integer id) {
        return passportRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        passportRepository.deleteById(id);
    }

    public Passport savePassport(Passport passport) {
        return passportRepository.save(passport);
    }
}
