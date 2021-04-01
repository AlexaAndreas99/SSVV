package ssvv.example;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

public class AddHomeworkTest {
    TemaLabValidator validator;
    TemaLabXMLRepo repo;
    TemaLabXMLService service;

    @Before
    public void init() {
        validator = new TemaLabValidator();
        repo = new TemaLabXMLRepo(validator, "StudentiXML.xml");
        service = new TemaLabXMLService(repo);
    }

//    @Test
//    public void homeworkShouldBeValidWBT() {
//        try {
//            validator.validate(new TemaLab(1, "o descriere mai descriere", 5, 3));
//            assert true;
//        } catch (ValidatorException e) {
//            assert false;
//        }
//    }
//
//    @Test
//    public void homeworkShouldNotBeValidWBT()  {
//        try {
//            validator.validate(new TemaLab(0, "o descriere mai descriere", 5, 3));
//            assert false;
//        } catch (ValidatorException e) {
//            assert true;
//        }
//    }

    @Test
    public void addHomeworkWBT() {
        // 1 - 2 - 4 - 5 - 7
        try {
            repo.save(new TemaLab(1, "o descriere mai descriere", 5, 3));
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
    }

    @Test
    public void addHomeworkFailWBT() {
        // 1 - 2 - 3 - 7
        try {
            repo.save(null);
            assert false;
        } catch (IllegalArgumentException | ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addHomeworkFailIdWBT() {
        // 1 - 2 - 4 - 5 - 7
        try {
            repo.save(new TemaLab(0, "o descriere mai descriere", 5, 3));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addHomeworkFailDescWBT() {
        // 1 - 2 - 4 - 6 - 7
        try {
            repo.save(new TemaLab(1, "", 5, 3));
            assert false;
        } catch (IllegalArgumentException | ValidatorException e) {
            assert true;
        }
    }
}
