package ssvv.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

/**
 * Unit test for simple App.
 */
public class AppTest {
    StudentValidator validator;
    StudentXMLRepo repo;
    StudentXMLService service;

    @Before
    public void init() {
        validator = new StudentValidator();
        repo = new StudentXMLRepo(validator, "StudentiXML.xml");
        service = new StudentXMLService(repo);
    }

    @Test
    public void shouldAddStudentToRepo() {
        assertEquals(0, repo.getSize());

        try {
            service.add(new String[]{"1", "nume", "2", "email", "prof"});
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        assertEquals(1, repo.getSize());
    }

    @Test
    public void groupShouldBeInt() {
        try {
            service.add(new String[]{"1", "nume", "d2", "email", "prof"});
            assert (false);
        } catch (ValidatorException e) {
            assert (true);
        }
    }

    @Test
    public void idShouldNotBeEmpty() {
        try {
            service.add(new String[]{"", "nume", "7", "email", "prof"});
            assert (false);
        } catch (ValidatorException e) {
            assert (true);
        }
    }

    @Test
    public void nameShouldNotBeEmpty() {
        try {
            service.add(new String[]{"1", "", "7", "email", "prof"});
            assert (false);
        } catch (ValidatorException e) {
            assert (true);
        }
    }

    @Test
    public void groupShouldNotBeEmpty() {
        try {
            service.add(new String[]{"1", "name", "", "email", "prof"});
            assert (false);
        } catch (ValidatorException e) {
            assert (true);
        }
    }

    @Test
    public void emailShouldNotBeEmpty() {
        try {
            service.add(new String[]{"1", "nume", "7", "", "prof"});
            assert (false);
        } catch (ValidatorException e) {
            assert (true);
        }
    }

    @Test
    public void teacherShouldNotBeEmpty() {
        try {
            service.add(new String[]{"1", "nume", "7", "email", ""});
            assert (false);
        } catch (ValidatorException e) {
            assert (true);
        }
    }
}
