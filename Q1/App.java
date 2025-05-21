import java.util.*;

class Student{
    private int studentId = 0;
    private String name = "";
    private int daysAttended = 0;

    void setData(int studentId, String name, int daysAttended){
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }
    void setStudentID(int studentId){
        this.studentId = studentId;
    }
    void setName(String name){
        this.name = name;
    }
    void setDaysAttended(int daysAttended){
        this.daysAttended = daysAttended;
    }

    int getStudentID(){
        return studentId;
    }
    String getName(){
        return name;
    }
    int getDaysAttended(){
        return daysAttended;
    }
}

class Classroom{
        int studentLimit = 10;
        Student[] student = new Student[studentLimit];
        int counter = 0;

        void updateAttendense(){
            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter student ID need to update");
            int id = Integer.parseInt(scan.nextLine());

            for(int i = 0; i < studentLimit; i++){
                if(student[i] == null){

                }
                else{
                    if(i == 9){
                        System.out.println("Student is not registered");
                    }
                    else{
                        if(student[i].getStudentID() == id){
                            System.out.println("Please enter the days attended");
                            int day = Integer.parseInt(scan.nextLine());
                            student[i].setDaysAttended(day);
                            System.out.println("Please enter the days Sucsessfuly Updated");
                            break;
                        }   
                    }
                }
            }
        }

        void showData(){

            System.out.println("Student Report");
            System.out.println("---------------------------------------------");
            
            for (int i = 0; i < studentLimit; i++){
                if(student[i] == null){
                    System.out.println("");
                    System.out.println("null");
                    System.out.println("------------------------------");
                }
                else{
                    System.out.println("");
                    System.out.print("ID    : ");
                    System.out.println(student[i].getStudentID());
                    System.out.print("Name  : ");
                    System.out.println(student[i].getName());
                    System.out.print("Days  : ");
                    System.out.println(student[i].getDaysAttended());
                    System.out.println("");
                    System.out.println("------------------------------");
                }
            }
        }

        void addNewStudent(){

            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter student ID");
            int id = Integer.parseInt(scan.nextLine());

            System.out.println("Please enter student name");
            String stdName = scan.nextLine();

            System.out.println("Please enter the days attended");
            int doa = Integer.parseInt(scan.nextLine());

            for (int i = 0 ; i < studentLimit; i++ ){
                if ( student[i] == null ){
                    student[i] = new Student();
                    student[i].setStudentID(id);
                    student[i].setName(stdName);
                    student[i].setDaysAttended(doa);
                    System.out.println("Data saved in posistion " + i );
                    break;
                }
            }
        }
}

class App{
    public static void main(String[] args){

            int system = 1;
            Classroom classroom = new Classroom();


            while(system == 1){
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to the Classroom App");
            System.out.println("---------------------------------------------");
            System.out.println("");
            System.out.println("Please select an input ...");
            System.out.println("   1 - Add a new student");
            System.out.println("   2 - Update Attendense");
            System.out.println("   3 - Student report");
            System.out.println("   4 - Exit");
            System.out.println("");

            Scanner scan = new Scanner(System.in);

            String input = scan.nextLine();
            switch (input) {
                case "1":
                    classroom.addNewStudent();
                    break;
            
                case "2":
                    classroom.updateAttendense();
                    break;
            
                case "3":
                    classroom.showData();
                    break;
            
                case "4":
                    system = 0;
                    break;
            
                default:
                    System.out.println("Please enter a valid input ");
                    break;
            }
        }
    }
}