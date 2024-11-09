package org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Client;

import org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Adaptee.StudentApiXml;
import org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Adapter.StudentApiAdapter;
import org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Adapter.StudentApiJsonAdapter;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        StudentApiAdapter studentApiJsonAdapter = new StudentApiJsonAdapter(new StudentApiXml());
        JSONObject jsonData = studentApiJsonAdapter.getStudentData();
        String jsonDataString = jsonData.toString(4);
        System.out.println(jsonDataString);

    }
}
