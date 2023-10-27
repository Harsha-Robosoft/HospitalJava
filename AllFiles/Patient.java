package AllFiles;


enum GenderTypes{
    Male,Female,Other;
}

enum PatientAdmissionType{
    Opd,Non_Opd;
}

enum Departments{
    Orthipedics, Cardiology, Neurology, Pediatrics;
}

public class Patient {

    private String patientID;
    private String fullName;
    private int age;
    private GenderTypes gender;
    private int contectNumber;
    private PatientAdmissionType admissionType;
    private Departments departmentToVisit; 
    private int numberOfdayToStay;
    private int policyNnumber;
    private int clamAmmount;


    public Patient(){

    }
    
    public Patient(String patientId,String name,int age,GenderTypes gender, int contactNum,PatientAdmissionType admissionType,Departments departmentToVisit){
        this.patientID = patientId;
        this.fullName = name;
        this.age = age;
        this.gender = gender;
        this.contectNumber = contactNum;
        this.admissionType = admissionType;
        this.departmentToVisit = departmentToVisit;
    }

    public Patient(String patientId,String name,int age,GenderTypes gender, int contactNum,PatientAdmissionType admissionType,Departments departmentToVisit, int numberOfDaysToStay, int policyNum, int clamAmount){
        this.patientID = patientId;
        this.fullName = name;
        this.age = age;
        this.gender = gender;
        this.contectNumber = contactNum;
        this.admissionType = admissionType;
        this.departmentToVisit = departmentToVisit;
        this.numberOfdayToStay = numberOfDaysToStay;
        this.policyNnumber = policyNum;
        this.clamAmmount = clamAmount;
    }

    public void patientCameToHospital(){
        System.out.println("Patient Came to hospital.===========");
        new Hospital().contactHelpDeskForPatientRegistration();
    }
    

}
