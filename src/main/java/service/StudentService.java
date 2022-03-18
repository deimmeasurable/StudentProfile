package service;

import data.dtos.RegisterContactRequest;
import exception.RegisterContactException;

public interface StudentService {
    RegisterContactRequest register(RegisterContactRequest registerForm) throws RegisterContactException;
}
