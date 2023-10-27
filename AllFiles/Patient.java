package AllFiles;


enum GenderTypes{
    Male,Female,Other;
}

enum PatientAdmissionType{
    Opd,Non_Opd;
}

enum Departments{
    Orthopedics, Cardiology, Neurology, Pediatrics;
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


    public String getPatientID() {return patientID; }
    public String getFullName() {return fullName;}
    public int getAge() {return age;}
    public GenderTypes getGender() {return gender;}
    public int getContectNumber() {return contectNumber;}
    public PatientAdmissionType getAdmissionType() {return admissionType;}
    public Departments getDepartmentToVisit() {return departmentToVisit;}
    public int getNumberOfdayToStay() {return numberOfdayToStay;}
    public int getPolicyNnumber() {return policyNnumber;}
    public int getClamAmmount() {return clamAmmount;}


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
