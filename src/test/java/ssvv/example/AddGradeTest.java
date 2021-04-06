package ssvv.example;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

public class AddGradeTest {
    NotaValidator validator;
    NotaXMLRepo repo;
    NotaXMLService service;

    @Before
    public void init() {
        validator = new NotaValidator();
        repo = new NotaXMLRepo(validator, "StudentiXML.xml");
        service = new NotaXMLService(repo);
    }

    //int, string, int, double, datetime
    @Test
    public void addGradeWBT() {
        try {
            service.add(new String[]{"1", "2", "3", "9", "2007-12-03T10:15:30"});
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
    }
}
