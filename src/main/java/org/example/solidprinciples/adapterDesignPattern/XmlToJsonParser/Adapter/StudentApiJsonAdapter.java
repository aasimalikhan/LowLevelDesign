package org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Adapter;

import org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Adaptee.StudentApi;
import org.json.JSONObject;
import org.json.XML;

public class StudentApiJsonAdapter implements StudentApiAdapter{
    StudentApi studentApi;
    public StudentApiJsonAdapter(StudentApi studentApi)
    {
        this.studentApi = studentApi;
    }
    @Override
    public JSONObject getStudentData() {
        try {
            String studentXmlData = studentApi.getStudentData();
            return XML.toJSONObject(studentXmlData);
        } catch (Exception e) {
            System.err.println("Error converting XML to JSON: " + e.getMessage());
            return new JSONObject();
        }
    }
}
