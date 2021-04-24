package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import junit.framework.TestCase;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import java.time.LocalDate;


public class AppTestLab4 {
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    String filenameStudent = "fisiere/Studenti.xml";
    String filenameTema = "fisiere/Teme.xml";
    String filenameNota = "fisiere/Note.xml";
    StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test
    public void addStudentNotOk(){
        try {
            Student stud = new Student("","abc", 12, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void integrationTestStudAssignment(){
        Student stud = new Student("55","abc", Integer.MAX_VALUE - 1, "loranz@loranz");
        Tema tema = new Tema("22","desc1",13,9);

        try{
            assert service.addStudent(stud) == stud;
            assert service.addTema(tema) == tema;
        }
        catch (Exception e){
            assert false;
        }

        try {
            Student stud1 = new Student("","abc", 12, "loranz@loranz");
            Tema tema1 = new Tema("22","desc1",13,9);
            assert service.addStudent(stud1) == stud1;
            assert service.addTema(tema1) == tema1;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect!");
            e.printStackTrace();
        }
    }


    @Test
    public void integrationTestAddGrade(){
        Student stud = new Student("55","abc", Integer.MAX_VALUE - 1, "loranz@loranz");
        Tema tema = new Tema("22","desc1",13,9);
        Nota nota = new Nota("1","55","22",7.0, LocalDate.of(2017, 1, 13));

        try{
            assert service.addStudent(stud) == stud;
            assert service.addTema(tema) == tema;
            assert service.addNota(nota,"fb") == 7.0;
        }
        catch (Exception e){
            assert false;
        }


        try {
            Student stud1 = new Student("","abc", 12, "loranz@loranz");
            Tema tema1 = new Tema("22","desc1",13,9);
            Nota nota1 = new Nota("1","55","22",7.0, LocalDate.of(2017, 1, 13));
            assert service.addStudent(stud1) == stud1;
            assert service.addTema(tema1) == tema1;
            assert service.addNota(nota1,"fb") == 7.0;

        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect!");
            e.printStackTrace();
        }
    }
}
