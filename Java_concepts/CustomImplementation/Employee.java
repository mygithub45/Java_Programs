package Java_concepts.CustomImplementation;

import java.util.HashMap;
 
class Employee {
    
    private Integer id;
    private String name;
    
    public Employee(Integer id, String name) { // constructor
           this.id = id;
           this.name = name;
    }
 
    @Override
    public String toString() {
           return "Employee[id=" + id + ", name=" + name + "] ";
    }
 
    @Override
    public boolean equals(Object obj){
           
           if(obj==null) //If obj is null, return without comparing obj & Employee class.
                  return false;
           
           if(this.getClass()!=obj.getClass())   //identifies whether obj is instance of Employee class or not.
                  return false;
    
           Employee emp=(Employee)obj; //type cast obj into employee instance.
           return (emp.id==this.id || emp.id.equals(this.id))
                               && (emp.name==this.name || emp.name.equals(this.name));        
    }
    @Override
    public int hashCode(){
        int hash=(this.id==null ? 0: this.id.hashCode() ) +
                (this.name==null ? 0: this.name.hashCode() );
        return hash;
    }

}

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
 class EmployeeOverride {
    public static void main(String...a){

        HashMap<Employee, String> hm=new HashMap<Employee, String>();
        hm.put(new Employee(1,"sam"), "employee1 data");
        hm.put(new Employee(2,"amy"), "employee2 data");

        System.out.println("HashMap's data> "+hm);
        System.out.println(hm.get(new Employee(1,"sam")));

        hm.put(new Employee(1,"sam"), "employee1 data OVERRIDDEN");
        System.out.println("\nAgain display HashMap after overriding data "+
                "of Employee with id=1 and name=’sam’\n");

        System.out.println("HashMap's data> "+hm);
        System.out.println(hm.get(new Employee(1,"sam")));

    }
}
/*OUTPUT

HashMap's data> {Employee[id=1, name=sam] =employee1 data, Employee[id=2, name=amy] =employee2 data}
employee1 data

Again display HashMap after overriding data of Employee with id=1 and name=’sam’

HashMap's data> {Employee[id=1, name=sam] =employee1 data OVERRIDDEN, Employee[id=2, name=amy] =employee2 data}
employee1 data OVERRIDDEN


*/