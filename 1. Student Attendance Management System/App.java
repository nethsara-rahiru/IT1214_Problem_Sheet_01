class Student{
    private int studentId;
    private String name;
    private int daysAttended;

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

    int getStudentID{
        return studentId;
    }
    String getName{
        return name;
    }
    int getDaysAttended{
        return daysAttended;
    }
}

class Classroom{
        Student[] student;

}

class App{
    public static void main(String[] args){

    }
}