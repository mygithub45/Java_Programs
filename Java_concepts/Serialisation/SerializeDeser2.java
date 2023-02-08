package Java_concepts.Serialisation;
//https://www.javamadesoeasy.com/2015/02/serialization-top-25-interview.html

//if any of the member does not implement Serializable than  NotSerializableException is thrown.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class MyClass {}

/*Author : AnkitMittal  Copyright- contents must not be reproduced in any form*/
class Employee9 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private MyClass myClass ;

    public Employee9(Integer id) {
        this.id = id;
        myClass=new MyClass();
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + "]";
    }

}
public class SerializeDeser2 {

    public static void main(String[] args) {

        Employee9 object1 = new Employee9(8);

        try {
            OutputStream fout = new FileOutputStream("ser.txt");
            ObjectOutput oout = new ObjectOutputStream(fout);
            System.out.println("Serialization process has started, serializing objects...");
            oout.writeObject(object1);
            System.out.println("Object Serialization completed.");
            fout.close();
            oout.close();

        } catch (IOException  e) {
            e.printStackTrace();
        }

    }

}
/*OUTPUT

Serialization process has started, serializing objects...
java.io.NotSerializableException: SerDeser10memberNotSer.MyClass
    at java.io.ObjectOutputStream.writeObject0(Unknown Source)
    at java.io.ObjectOutputStream.defaultWriteFields(Unknown Source)
    at java.io.ObjectOutputStream.writeSerialData(Unknown Source)
    at java.io.ObjectOutputStream.writeOrdinaryObject(Unknown Source)
    at java.io.ObjectOutputStream.writeObject0(Unknown Source)
    at java.io.ObjectOutputStream.writeObject(Unknown Source)
    at SerDeser10memberNotSer.SerializeConstructorCheck.main(SerializeConstructorCheck.java:42)

*/