package faeterj._5pjs.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faeterj._5pjs.parkingsystem.repository.VagaRepo;

@Service
public class VagaService {
    @Autowired
    VagaRepo repository;
}
