package Java_concepts.Serialisation;
//Full Program/SourceCode to avoid Deserialization process creating another instance of Singleton class
//We can simply use readResove() method to return same instance of class,
// rather than creating a new one.
//
//Defining readResolve() method ensures that
// we don't break singleton pattern during DeSerialization process.
//https://www.javamadesoeasy.com/2015/02/avoid-deserialization-process-creating.html
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
public class SingletonClass implements Serializable{

    private static final long serialVersionUID = 1L;
    private static SingletonClass INSTANCE = null;

    //method returns instance of Singleton class.
    public static SingletonClass getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonClass.class) {
                INSTANCE = new SingletonClass();
            }
        }
        return INSTANCE;
    }

    //constructor
    private SingletonClass() {}

    /**
     *customize Serialization process.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("in readObject()");
        ois.defaultReadObject();
        synchronized (SingletonClass.class) {
            if (INSTANCE == null) {
                INSTANCE = this;
            }
        }
    }
    /**
     * Method ensures that we don't break singleton pattern during DeSerialization process- method must not be called other than DeSerialization time.
     */
    private Object readResolve() throws ObjectStreamException {
        System.out.println("in readResolve()");
        return INSTANCE;
    }

    public static void main(String[] args) throws Throwable {
        System.out.println("Are objects same before serialization : "+ (getInstance() == getInstance()) );

        OutputStream fout = new FileOutputStream("ser.txt");
        ObjectOutput oout = new ObjectOutputStream(fout);
        System.out.println("Serialization process has started...");
        oout.writeObject(getInstance());
        fout.close();
        oout.close();
        System.out.println("Object Serialization completed.");

        //DeSerialization process >>>>>>>.

        InputStream fin=new FileInputStream("ser.txt");
        ObjectInput oin=new ObjectInputStream(fin);
        System.out.println("\nDeSerialization process has started...");
        SingletonClass deSerializedObj = (SingletonClass)oin.readObject();
        fin.close();
        oin.close();
        System.out.println("Object DeSerialization completed.");
        System.out.println("Are objects same after serialization : "+ (deSerializedObj == getInstance()) );

    }
}
/*OUTPUT

Are objects same before serialization : true
Serialization process has started...
Object Serialization completed.

DeSerialization process has started...
in readObject()
in readResolve()
Object DeSerialization completed.
Are objects same after serialization : true

*/