package AllFiles;

import AllFiles.AllEnums.Departments;



public class PatientCheckUpDetails {
    private Departments departmentVisited;
    private String prescription;
    private int consultAmount;
    private boolean amountPaied = false;

    public PatientCheckUpDetails(Departments departmentVisited, String prescription, int consultAmount){
        this.departmentVisited = departmentVisited;
        this.prescription = prescription;
        this.consultAmount = consultAmount;
    }

    @Override
    public String toString() {
        
        return "patient checkup details is \n" + "department visited: " + departmentVisited + "\n" + "prescription: " + prescription + "\n" + "consulting amount: " + consultAmount + "\n" + "amount paied:" + amountPaied;
    }

    public Departments getDepartmentVisited() {return departmentVisited;}
    public String getPrescription() {return prescription;}
    public int getConsultAmount() {return consultAmount;}
    public boolean isAmountPaied() {return amountPaied;}

    public void setAmountPaied(boolean amountPaied) {
        this.amountPaied = amountPaied;
    }

    
    
    
}
