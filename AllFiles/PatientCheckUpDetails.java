package AllFiles;

public class PatientCheckUpDetails {
    private Departments departmentVisited;
    private String prescription;
    private int consultAmount;
    private boolean paidConsultingAmmount = false;

    public PatientCheckUpDetails(Departments departmentVisited, String prescription, int consultAmount){
        this.departmentVisited = departmentVisited;
        this.prescription = prescription;
        this.consultAmount = consultAmount;
    }

    public Departments getDepartmentVisited() {return departmentVisited;}
    public String getPrescription() {return prescription;}
    public int getConsultAmount() {return consultAmount;}
    public boolean isPaidConsultingAmmount() {return paidConsultingAmmount;}
    
    public void setPaidConsultingAmmount(boolean paidConsultingAmmount) {this.paidConsultingAmmount = paidConsultingAmmount;}
}
