import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppTW {
    public static void main(String[] args) {
        ClinicDAO clinicDAO = new ClinicDAO();

//        DoctorDTO doctorDTO = new DoctorDTO("Jan", "Kowalski", "okulista", "5");
//        clinicDAO.addDoctor(doctorDTO);
//
//        System.out.println(clinicDAO.getAllDoctors());
//
//        doctorDTO.setFirstName("Janusz");
//        clinicDAO.modifyDoctor(8, doctorDTO);
//        System.out.println(clinicDAO.getAllDoctors());
//
        clinicDAO.removeDoctor(7);
//        clinicDAO.removeDoctor(8);

//        ClientDTO clientDTO = new ClientDTO();
//        clientDTO.setPesel("00000000001");
//        clientDTO.setFirstName("zzzz");
//        clientDTO.setLastName("ccccc");
//        clientDTO.setCity("łódź");
//        clientDTO.setStreet("Polna");
//        clientDTO.setStreetNumber("122/7");
//        clientDTO.setPhone("997");
//
//        clinicDAO.addClient(clientDTO);
//        clinicDAO.modifyClient(clientDTO);

//        List<AppointmentDetails> visitsByClientPesel = clinicDAO.getVisitsByClientPesel("00000000001");
//        System.out.println(visitsByClientPesel);
//        System.out.println(clinicDAO.getClient("2222222222"));
//
//        clinicDAO.setAppointment("3333333333", 1, 30);
//        clinicDAO.setAppointment("1111111111", 1, 31);
//        List<AppointmentDetails> appByDoctorId = clinicDAO.getAppByDoctorId(1, false);
//        appByDoctorId.forEach(System.out::println);
//        clinicDAO.cancelVisit("3333333333", 30);
//        clinicDAO.getAppByDoctorId(1, false).forEach(System.out::println);

//        List<Client> clients = clinicDAO.getAllClients();
//        clients.forEach(System.out::println);

//        clinicDAO.setAppointment("00000000001", 7, 34);
//        clinicDAO.setAppointment("00000000011", 1, 34);
//        clinicDAO.setAppointment("00000000001", 1, 834);
//        clinicDAO.setAppointment("00000000001", 1, 32);
//        clinicDAO.setAppointment("00000000001", 3, 34);
//        clinicDAO.setAppointment("00000000001", 1, 34);
//        appByDoctorId = clinicDAO.getAppByDoctorId(1, false);
//        appByDoctorId.forEach(System.out::println);

        VisitFactory visitFactory = new VisitFactory(clinicDAO);
//        LocalDate startDay = LocalDate.of(2021, 06, 01);
//        LocalDate endDay = LocalDate.of(2021, 06, 3);
//        LocalTime startTime = LocalTime.of(8, 0);
//        LocalTime endTime = LocalTime.of(16, 0);

//        visitFactory.addAppointments(1, startDay, endDay, startTime, endTime);
        visitFactory.menu();


        clinicDAO.factoryClose();
    }
}
