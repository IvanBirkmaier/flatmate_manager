package htw.berlin.wgverwaltung.web;

import htw.berlin.wgverwaltung.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanzenController {
    @Autowired
    private Service service;
}
