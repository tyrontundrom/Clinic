import model.*;

import java.util.ArrayList;
import java.util.List;

public class AppP {
    public static void main(String[] args) {

        Client client = new Client();
//        System.out.println(client.getPesel());
        ClinicDAO clinicDAO = new ClinicDAO();
//        clinicDAO.getVisitsByClientPesel("2222222222");
        ClientDTO clientDTO = new ClientDTO();
//        System.out.println(clientDTO.getPesel());
//        System.out.println(clinicDAO.getClient("1111111111"));
//        System.out.println(clinicDAO.getPesel());
        VisitFactory visitFactory = new VisitFactory(clinicDAO);
        List<AppointmentDetails> appointmentDetails = new ArrayList<>();
        visitFactory.showAppointsments(3);



    }
}
