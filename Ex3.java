class Student{
    String StudentId;
    String StudentName;
    int age;
    public void displayData(){
        System.out.print("ID: "+this.StudentId+",Name: "+this.StudentName+",Age: "+this.age);
    }
}
public class Ex771 {
    public static void main(String[] args){
        Student A=new Student();
        A.StudentId="2022";
        A.StudentName="Yolo";
        A.age=20;
        Student B=new Student();
        B.StudentId="20223";
        B.StudentName="Oke";
        B.age=21;
        A.displayData();
        B.displayData();
    }
}
