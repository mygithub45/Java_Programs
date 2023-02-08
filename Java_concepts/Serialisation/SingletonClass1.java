package Java_concepts.Serialisation;
//Full Program/SourceCode to Serialize Singleton class
// such that object returned by Deserialization process
// is in same state as it was during Serialization time
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
public class SingletonClass1 implements Serializable {

    private static final long serialVersionUID = 1L;
    private static SingletonClass1 INSTANCE = new SingletonClass1();
    private int x;

    @Override
    public String toString() {
        return "SingletonClass [x=" + x + "]";
    }

    //method returns INSTANCE of Singleton class.
    public static SingletonClass1 getInstance() {
        return INSTANCE;
    }

    //constructor
    private SingletonClass1() {}

    /**
     *customize Serialization process.
     */
    private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException {
        System.out.println("in readObject()");
        ois.defaultReadObject();
        INSTANCE = this;  //rather than creating new instance, assign current object to INSTANCE
    }
    /**
     * Method ensures that we don't impact state of object in which it was Serialized.
     */
    private Object readResolve() {
        System.out.println("in readResolve()");
        return INSTANCE;  //return INSTANCE.
    }

    public static void main(String[] args) throws Throwable {

        SingletonClass1 object1 = SingletonClass1.getInstance();
        object1.x = 22;

        OutputStream fout = new FileOutputStream("ser.txt");
        ObjectOutput oout = new ObjectOutputStream(fout);
        System.out.println("Serialization process has started, serializing objects...");
        oout.writeObject(getInstance());
        System.out.println("Object state at time of Serialization : "+getInstance());
        fout.close();
        oout.close();
        System.out.println("Object Serialization completed.");

        object1.x = 33; // modified after serialization (but it's not going to change state of object in which it was Serialized, as modification is made after serialization)
        System.out.println("Object state modified after Serialization : "+getInstance());

        //DeSerialization process >>>>>>>.

        InputStream fin=new FileInputStream("ser.txt");
        ObjectInput oin=new ObjectInputStream(fin);
        System.out.println("\nDeSerialization process has started, displaying objects...");
        oin.readObject();
        System.out.println("Object state after DeSerialization : "+getInstance()); //It's showing value of x as 22 not 33 (i.e. state in which object was serialized), although x was changed to 33 after serialization.
        fin.close();
        oin.close();
        System.out.println("Object DeSerialization completed.");


    }
}

/*OUTPUT

Serialization process has started, serializing objects...
Object state at time of Serialization : SingletonClass [x=22]
Object Serialization completed.
Object state modified after Serialization : SingletonClass [x=33]

DeSerialization process has started, displaying objects...
in readObject()
in readResolve()
Object state after DeSerialization : SingletonClass [x=22]
Object DeSerialization completed.

*/