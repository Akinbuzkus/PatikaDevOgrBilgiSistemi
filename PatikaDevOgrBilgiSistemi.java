
public class PatikaDevOgrBilgiSistemi {
    public static void main(String[] args) {
        Course mat = new Course("Matematik", "MAT101", "MAT");
        Course fizik = new Course("Fizik", "FZK101", "FZK");
        Course kimya = new Course("Kimya", "KMY101", "KMY");

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
        Teacher t3 = new Teacher("Ali Veli", "90550000002", "KMY");

        mat.addTeacher(t1);
        fizik.addTeacher(t2);
        kimya.addTeacher(t3);

        Student s1 = new Student("Akin Buzkus", "20180808086", 4, mat, fizik, kimya);
        s1.addBulkExamNote(75,85,90);
        s1.isPass();

        Student s2 = new Student("Güdük Necmi","2211133",4, mat, fizik, kimya);
        s2.addBulkExamNote(100,50,40);
        s2.isPass();

        Student s3 = new Student("Hayta İsmail","221121312",4, mat, fizik, kimya);
        s3.addBulkExamNote(50,20,40);
        s3.isPass();
    }
} 

class Course{
    Teacher courseTeacher;
    String name,code,prefix;
    int note;

    public Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
    }
       
    public void addTeacher(Teacher t){
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " Akademisyeni bu dersi veremez.");
        }
    }
    
    public void printTeacher(){
        if (courseTeacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }
} 

class Teacher{
    String name,branch,mpno;
  

    public Teacher(String name, String branch, String mpno) {
        this.name = name;
        this.branch = branch;
        this.mpno = mpno;
    }
}

class Student{

    String name,stuNo;
    int classes;
    Course mat,fizik,kimya;
    boolean isPass;
    double avarage;

    public Student(String name, String stuNo, int classes, Course Mat, Course Fizik, Course Kimya) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.mat = Mat;
        this.fizik = Fizik;
        this.kimya = Kimya;
        calcAverage();
        this.isPass = false;
    }
    
   public void addBulkExamNote(int mat,int fizik,int kimya){
       
        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }
   }
   
   public void isPass(){
    if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
   }
   public void calcAverage(){
       this.avarage = (this.fizik.note + this.kimya.note + this.mat.note) / 3;
   }
   
   public void printNote(){
       System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
   }
   
   public boolean isCheckPass(){
        calcAverage();
        return this.avarage > 55;
   }
    
    
}



