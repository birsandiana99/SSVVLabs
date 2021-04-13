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

import java.time.LocalDate;

public class AddGradeTest {

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
    public void addStudentOk(){
        Student stud = new Student("55","abc", Integer.MAX_VALUE - 1, "loranz@loranz");
        assert service.addStudent(stud) == stud;
    }

    @Test
    public void addAssignmentOk(){
        Tema tema = new Tema("55","desc1",13,9);
        assert service.addTema(tema) == tema;
    }

    @Test
    public void addGradeOk(){
        Nota nota = new Nota("55","55","55",7.0, LocalDate.of(2017, 1, 13));
        try{
            assert service.addNota(nota,"fb") == 7.0;
        }
        catch (Exception e){
//            System.out.println(e);
            assert false;

        }
    }

    @Test
    public void integrationTest(){
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
    }
}