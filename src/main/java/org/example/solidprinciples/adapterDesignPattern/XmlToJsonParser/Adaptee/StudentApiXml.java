package org.example.solidprinciples.adapterDesignPattern.XmlToJsonParser.Adaptee;

public class StudentApiXml implements StudentApi{
    @Override
    public String getStudentData() {
        return "<student><id>1</id><name>John Doe</name><age>20</age><grade>A</grade></student><student><id>2</id><name>Jane Smith</name><age>22</age><grade>B</grade></student><student><id>3</id><name>Emily Johnson</name><age>21</age><grade>A</grade></student><student><id>4</id><name>Michael Brown</name><age>23</age><grade>C</grade></student>";
    }
}
