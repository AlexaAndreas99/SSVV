package Repository.MemoryRepository;

import Domain.Student;
import Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}
