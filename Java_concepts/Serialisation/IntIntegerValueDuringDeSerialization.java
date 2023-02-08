package Java_concepts.Serialisation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
//int will be initialized to 0 and
// Integer will be initialized to null during DeSerialization
// (if they were not part of Serialization process).
//https://www.javamadesoeasy.com/2015/02/what-values-will-int-and-integer-will.html
class Employee1 implements Serializable  {

    private static final long serialVersionUID = 1L;
    private int idInt;
    private Integer idInteger;
    private String name;

    public Employee1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [idInt=" + idInt + ", idInteger=" + idInteger
                + ", name=" + name + "]";
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        System.out.println("In, writeObject() method.");
        os.writeObject(this.name);

    }
    private void readObject(ObjectInputStream ois) {
        System.out.println("In, readObject() method.");
        try {
            name=(String)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

    public class IntIntegerValueDuringDeSerialization {
    public static void main(String[] args) {

        Employee1 object1 = new Employee1("ankit");

        try {
            OutputStream fout = new FileOutputStream("ser.txt");
            ObjectOutput oout = new ObjectOutputStream(fout);
            System.out.println("Serialization process has started, serializing employee objects...");
            oout.writeObject(object1);
            fout.close();
            oout.close();
            System.out.println("Object Serialization completed.");


            //DeSerialization process >


            InputStream fin=new FileInputStream("ser.txt");
            ObjectInput oin=new ObjectInputStream(fin);
            System.out.println("\nDeSerialization process has started, displaying employee objects...");
            Employee1 emp=(Employee1)oin.readObject();
            System.out.println(emp);
            fin.close();
            oin.close();
            System.out.println("Object DeSerialization completed.");


        } catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
}
}

/*OUTPUT

Serialization process has started, serializing employee objects...
Object Serialization completed.

DeSerialization process has started, displaying employee objects...
Employee [idInt=0, idInteger=null, name=ankit]
Object DeSerialization completed.

*/