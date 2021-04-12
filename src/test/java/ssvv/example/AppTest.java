package ssvv.example;

import static org.junit.Assert.assertTrue;

import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;


/**
 * Unit test for simple App.
 */
public class AppTest
{
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
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addStudentTest1() {
        try {
        Student stud = new Student("88","abc", -1, "loranz@loranz");
        assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest2() {
        try {
            Student stud = new Student("","abc", -1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect! Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest3() {
        try {
            Student stud = new Student("88","", -1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Nume incorect! Grupa incorecta!");
            e.printStackTrace();
        }
    }


    @Test
    public void addStudentTest4() {
        try {
            Student stud = new Student("88","abc", -1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest5() {
        try {
            Student stud = new Student("88","abc", -1, "");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Grupa incorecta! Email incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest6() {
        try {
            Student stud = new Student("88","abc", 0, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest7() {
        try {
            Student stud = new Student("","abc", 0, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect! Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest8() {
        try {
            Student stud = new Student("88","", 0, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Nume incorect! Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest9() {
        try {
            Student stud = new Student("88","abc", -1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Grupa incorecta!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest10() {
        try {
            service.addStudent(new Student("55","khu", 0, ""));
            int counter = service.getStudNr();
            assert counter == 2;
        }catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Grupa incorecta! Email incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest11() {
        Student stud = new Student("55","khu", 1, "fghj");
        assert service.addStudent(stud) == stud;
    }

    @Test
    public void addStudentTest12() {
        try {
            Student stud = new Student("","abc", 1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest13() {
        try {
            Student stud = new Student("54","", 1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Nume incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest14() {
        Student stud = new Student("4567","abc", 1, "loranz@loranz");
        assert service.addStudent(stud) == stud;
    }

    @Test
    public void addStudentTest15() {
        try {
            Student stud = new Student("64","abc", 1, "");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Email incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest16() {
        Student stud = new Student("4","abc", Integer.MAX_VALUE-1, "loranz@loranz");
        assert service.addStudent(stud) == stud;
    }

    @Test
    public void addStudentTest17() {
        try {
            Student stud = new Student("","abc", Integer.MAX_VALUE - 1, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest18() {
        try {
            Student stud = new Student("654","", Integer.MAX_VALUE - 1 , "loranz@loranz");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Nume incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest19() {
        Student stud = new Student("654","abc", Integer.MAX_VALUE - 1, "loranz@loranz");
        assert service.addStudent(stud) == stud;
    }

    @Test
    public void addStudentTest20() {
        try {
            Student stud = new Student("654","abc", Integer.MAX_VALUE - 1, "");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Email incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest21() {
        Student stud = new Student("654","abc", Integer.MAX_VALUE, "loranz@loranz");
        assert service.addStudent(stud) == stud;
    }

    @Test
    public void addStudentTest22() {
        try {
            Student stud = new Student("","abc", Integer.MAX_VALUE, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Id incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest23() {
        try {
            Student stud = new Student("654","", Integer.MAX_VALUE, "loranz@loranz");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Nume incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentTest24() {
        Student stud = new Student("654","abc", Integer.MAX_VALUE, "loranz@loranz");
        assert service.addStudent(stud) == stud;
    }
    @Test
    public void addStudentTest25() {
        try {
            Student stud = new Student("654","abc", Integer.MAX_VALUE, "");
            assert service.addStudent(stud) == stud;
        } catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Email incorect!");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest1(){
        try{
        Tema tema = new Tema("","desc1",12,9);
        assert service.addTema(tema) == tema;}
        catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Numar tema invalid!");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest2(){
        try{
            Tema tema = new Tema("22","",12,9);
            assert service.addTema(tema) == tema;}
        catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Descriere invalida!");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest3(){
        try{
            Tema tema = new Tema("22","desc1",-15,9);
            assert service.addTema(tema) == tema;}
        catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Deadlineul trebuie sa fie intre 1-14.");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest4(){
        try{
            Tema tema = new Tema("22","desc1",16,9);
            assert service.addTema(tema) == tema;}
        catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Deadlineul trebuie sa fie intre 1-14.");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest5(){
        try{
            Tema tema = new Tema("22","desc1",12,-1);
            assert service.addTema(tema) == tema;}
        catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Saptamana primirii trebuie sa fie intre 1-14.");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest6(){
        try{
            Tema tema = new Tema("22","desc1",12,15);
            assert service.addTema(tema) == tema;}
        catch (ValidationException e) {
            assert e.toString().equals("validation.ValidationException: Saptamana primirii trebuie sa fie intre 1-14.");
            e.printStackTrace();
        }
    }

    @Test
    public void addAsignmentTest7(){
        Tema tema = new Tema("22","desc1",13,9);
        assert service.addTema(tema) == tema;
    }



}
