package AllFiles;

public class Hospital {
    

    public void contactHelpDeskForPatientRegistration(){
        System.out.println("Contacted the helpdesk for registration.=============");
        new HelpDesk().patientRegistation();
    }
}
