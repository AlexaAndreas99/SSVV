package ssvv.example;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncIntTD {
    StudentValidator studentValidator;
    StudentXMLRepo studentRepo;
    StudentXMLService studentService;

    NotaValidator gradeValidator;
    NotaXMLRepo gradeRepo;
    NotaXMLService gradeService;

    TemaLabValidator hwValidator;
    TemaLabXMLRepo hwRepo;
    TemaLabXMLService hwService;

    @Before
    public void init() {
        gradeValidator = new NotaValidator();
        gradeRepo = new NotaXMLRepo(gradeValidator, "GradeXML.xml");
        gradeService = new NotaXMLService(gradeRepo);

        studentValidator = new StudentValidator();
        studentRepo = new StudentXMLRepo(studentValidator, "StudentXML.xml");
        studentService = new StudentXMLService(studentRepo);

        hwValidator = new TemaLabValidator();
        hwRepo = new TemaLabXMLRepo(hwValidator, "HWXML.xml");
        hwService = new TemaLabXMLService(hwRepo);
    }

    @Test
    public void addStudent() {
        try {
            studentService.add(new String[]{"1", "nume", "2", "email", "prof"});
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
    }


    @Test
    public void addHomework() {
        // 1 - 2 - 4 - 5 - 7
        try {
            studentService.add(new String[]{"1", "nume", "2", "email", "prof"});
            hwService.add(new String[]{"1", "o descriere mai descriere", "5", "3"});
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
    }

    //int, string, int, double, datetime
    @Test
    public void addGrade() {
        try {
            studentService.add(new String[]{"1", "nume", "2", "email", "prof"});
            hwService.add(new String[]{"1", "o descriere mai descriere", "5", "3"});
            gradeService.add(new String[]{"1", "2", "3", "9", "2007-12-03T10:15:30"});
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
    }

}
