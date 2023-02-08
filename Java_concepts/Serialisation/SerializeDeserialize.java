package Java_concepts.Serialisation;
//https://www.javamadesoeasy.com/2015/02/can-subclass-avoid-serialization-if-its.html
//Full Program/SourceCode to show how
// subclass can avoid Serialization if its superClass has implemented Serialization interface
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
class Super2 implements Serializable{

    private static final long serialVersionUID = 1L;

}
class Sub2 extends Super {

    private static final long serialVersionUID = 1L;
    private Integer id;

    public Sub2(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + "]";
    }

    /*
     * define how Serialization process will write objects.
     */
    private void writeObject(ObjectOutputStream os) throws NotSerializableException {
        throw new NotSerializableException("This class cannot be Serialized");
    }


}

public class SerializeDeserialize {
    public static void main(String[] args) {

        Sub object1 = new Sub(8);

        try {
            OutputStream fout = new FileOutputStream("ser.txt");
            ObjectOutput oout = new ObjectOutputStream(fout);
            System.out.println("Serialization process has started, serializing objects...");
            oout.writeObject(object1);
            fout.close();
            oout.close();
            System.out.println("Object Serialization completed.");


        } catch (IOException  e) {
            e.printStackTrace();
        }

    }

}
/*OUTPUT

Serialization process has started, serializing objects...
java.io.NotSerializableException: This class cannot be Serialized
    at SerDeser11throwNotSerExc.Sub.writeObject(SerializeConstructorCheck.java:35)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
    at java.lang.reflect.Method.invoke(Unknown Source)
    at java.io.ObjectStreamClass.invokeWriteObject(Unknown Source)
       at java.io.ObjectOutputStream.writeSerialData(Unknown Source)
    at java.io.ObjectOutputStream.writeOrdinaryObject(Unknown Source)
    at java.io.ObjectOutputStream.writeObject0(Unknown Source)
    at java.io.ObjectOutputStream.writeObject(Unknown Source)
    at SerDeser11throwNotSerExc.SerializeConstructorCheck.main(SerializeConstructorCheck.java:51)

*/

