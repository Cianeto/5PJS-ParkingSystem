package faeterj._5pjs.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import faeterj._5pjs.parkingsystem.repository.ClienteRepo;

@Service
public class ClienteService {
    @Autowired
    ClienteRepo repository;

    public void insertNewCliente(){
        repository.save();
    }

}
