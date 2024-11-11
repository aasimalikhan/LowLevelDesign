package org.example.solidprinciples.builderDesignPattern;

public class Director {
    StudentBuilder studentBuilder;
    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }
    public Student createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder)
        {
            return createEngineeringStudent();
        }
        else
        {
            return createMBAStudent();
        }
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setRollNumber(1).setAge(22).setName("sj").build();
    }

    private Student createMBAStudent() {
        return studentBuilder.setRollNumber(2).setAge(24).setName("sj").setFatherName("MyFatherName").setMotherName("MyMotherName").build();
    }
}
