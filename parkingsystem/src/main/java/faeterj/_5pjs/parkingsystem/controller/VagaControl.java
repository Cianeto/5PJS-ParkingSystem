package faeterj._5pjs.parkingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import faeterj._5pjs.parkingsystem.repository.VagaRepo;

@Controller
public class VagaControl {
    @Autowired
    private VagaRepo vagaRepo;
}
