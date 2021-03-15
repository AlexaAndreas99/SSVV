package Repository.MemoryRepository;

import Domain.Nota;
import Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}
