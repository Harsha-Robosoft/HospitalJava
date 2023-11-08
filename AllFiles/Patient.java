package AllFiles;

import java.util.ArrayList;
import java.util.HashMap;
import AllFiles.AllEnums.*;


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
    private HashMap<Departments, ArrayList<PatientCheckUpDetails>> checkUpDetails = new HashMap<>();
    
    public HashMap<Departments, ArrayList<PatientCheckUpDetails>> getCheckUpDetails() {
        return checkUpDetails;
    }
    public void setCheckUpDetails(HashMap<Departments, ArrayList<PatientCheckUpDetails>> checkUpDetails) {
        this.checkUpDetails = checkUpDetails;
    }

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

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    @Override
    public String toString() {
        return "ID: "+ patientID + "\n" + "name: " + fullName + "\n" + "age: " + age + "\n" + "gender: " + gender + "\n" + "contact num: " + contectNumber + "\n" + "admission type: " + admissionType + "\n" +  "department to visit: " + departmentToVisit + "\n" + "number of days to stay: " + numberOfdayToStay + "\n" + "policy number: " + policyNnumber + "\n" + "clam amount: " + clamAmmount + "\n" + "checkup details: " + checkUpDetails ;
    }

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
}
