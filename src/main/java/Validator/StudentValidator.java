package Validator;

import Domain.Student;
import Exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if(s.getNume().equals("") || s.getNume()==null){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail().equals("") || s.getEmail()==null){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if(s.getIndrumator().equals("") || s.getIndrumator()==null){
            //throw new ValidatorException("Indrumator invalid\n");
            errors+="Indrumator invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}
