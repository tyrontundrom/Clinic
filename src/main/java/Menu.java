import model.*;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {


        ClinicDAO clinicDAO = new ClinicDAO();
        ClientDTO clientDTO = new ClientDTO();
        DoctorDTO doctorDTO = new DoctorDTO();
        VisitFactory visitFactory = new VisitFactory(clinicDAO);



        Scanner keyboard = new Scanner(System.in);
        String user ="";

        while (!user.equals("exit")) {
            System.out.println("MENU:");
            System.out.println("1.|Dodaj klienta|");
            System.out.println("2.|Dodaj wizytę|");
            System.out.println("3.|Edytuj klienta|");
            System.out.println("4.|Usuń wizytę|");
            System.out.println("5.|Pokaż wizyty klienta|");
            System.out.println("6.|Dodaj lekarza|");
            System.out.println("7.|Usuń lekarza|");
            System.out.println("8.|Edytuj lekarza|");
            System.out.println("9.|Pokaż wszystkich lekarzy|");
            System.out.println("10.|Pokaż wizyty lekarza|");
            System.out.println("11.|Pokaż klienta|");
            System.out.println("12.|Harmonogram Wizyt");
            System.out.println("exit.|Wyjście z programu.");
            user = keyboard.nextLine();
            if (user.equals("1")) {
                String pesel;
                boolean one;
                do {
                    System.out.println("Podaj pesel nowego klienta");
                    // Sprawdź czy pesel jest w bazie. OK
                    pesel = keyboard.nextLine();
                    one = clientDTO.checkPesel(pesel, clinicDAO.getPesel());
                } while (one == true);

                System.out.println("Podaj Imię nowego klienta");
                String firstName = keyboard.nextLine();
                System.out.println("Podaj nazwisko nowego klienta");
                String lastName = keyboard.nextLine();
                System.out.println("Podaj miasto");
                String city = keyboard.nextLine();
                System.out.println("Podaj ulicę");
                String street = keyboard.nextLine();
                System.out.println("Podaj numer ulicy");
                String streetNumber = keyboard.nextLine();
                System.out.println("Podaj numer telefonu");
                String phone = keyboard.nextLine();
                clientDTO = new ClientDTO(pesel,firstName,lastName,city,street,
                        streetNumber,phone);
                clinicDAO.addClient(clientDTO);
            } else if (user.equals("2")) {
                System.out.println("Podaj pesel klienta");
                String pesel = keyboard.nextLine();
                clinicDAO.getAllDoctors().forEach(System.out::println);
                System.out.println("Podaj Id lekarza");
                int doctorId = keyboard.nextInt();
                // Wyświetl wizyty lekarza.
                clinicDAO.getAppByDoctorId(doctorId,false).forEach(System.out::println);
                System.out.println("Podaj Id wizyty");
                // Sprawdź id wizyty czy isnieje
                int visitId = keyboard.nextInt();
                clinicDAO.setAppointment(pesel,doctorId,visitId);

            } else if (user.equals("3")) {
                // Lista klientów w bazie
                for (Client a : clinicDAO.getAllClients()) {
                    System.out.println(a);
                }
                System.out.println("Podaj pesel klienta do edycji");
                String pesel = keyboard.nextLine();

                System.out.println("Podaj Imię klienta");
                String firstName = keyboard.nextLine();
                System.out.println("Podaj nazwisko klienta");
                String lastName = keyboard.nextLine();
                System.out.println("Podaj miasto");
                String city = keyboard.nextLine();
                System.out.println("Podaj ulicę");
                String street = keyboard.nextLine();
                System.out.println("Podaj numer ulicy");
                String streetNumber = keyboard.nextLine();
                System.out.println("Podaj numer telefonu");
                String phone = keyboard.nextLine();
                clientDTO = new ClientDTO(pesel,firstName,lastName,city,
                        street,streetNumber,phone);
                clinicDAO.modifyClient(clientDTO);
            } else if (user.equals("4")) {
                // Lista wizyt w bazie
                clinicDAO.getAllDoctors().forEach(System.out::println);
                System.out.println("Podaj id lekarza, którego wizytę chcesz zmodyfikować");
                int doctorId = keyboard.nextInt();
                visitFactory.showAppointsments(doctorId);
//                visitFactory.menu();
                System.out.println("Podaj wizytę którą chcesz zmodyfikować");
                int visit = keyboard.nextInt();
                clinicDAO.removeDoctorAppointment(visit);
                // Usuwana jest cała pozycja z bazy danych.
            } else if (user.equals("5")) {
                System.out.println("Podaj pesel");
                String pesel = keyboard.nextLine();
                // Co chces zrobić? dodaj, edytuj, usuń, wyjdź.
                clinicDAO.getVisitsByClientPesel(pesel).forEach(System.out::println);
                System.out.println("1.| Dodaj wizytę|");
                System.out.println("2.| Edytuj wizytę|");
                System.out.println("exit.| wyjście");
                user = keyboard.nextLine();
                while (!user.equals("exit")) {
                    if (user.equals("1")) {
                        System.out.println(clinicDAO.getAllDoctors());
                        System.out.println("Podaj Id Lekarza");
                        int doctorId = keyboard.nextInt();
                        System.out.println(clinicDAO.getAppByDoctorId(doctorId, false));
                        visitFactory.showAppointsments(doctorId);
                        System.out.println("Podaj Id wizyty");
                        int visitId = keyboard.nextInt();
                        clinicDAO.setAppointment(pesel,doctorId,visitId);
                        System.out.println("Wizyta dodana");

                    }
                }
            } else if (user.equals("6")) {
                System.out.println("Podaj imię lekarza");
                String firstName = keyboard.nextLine();
                System.out.println("Podaj Nazwisko lekarza");
                String lastName = keyboard.nextLine();
                System.out.println("Podaj specjlalizację");
                String spec = keyboard.nextLine();
                System.out.println("Podaj numer pokoju");
                String room = keyboard.nextLine();
                doctorDTO = new DoctorDTO(firstName, lastName, spec, room);
                clinicDAO.addDoctor(doctorDTO);
            } else if (user.equals("7")) {
                // Lista lekarzy w bazie
                System.out.println("Podaj Id lekarza");
                int doctorId = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Usunięcie lekarza będzie nie odwracalne");
                System.out.println("Potwierdź usunięcie wpisująć \"tak\"");
                String tak = keyboard.nextLine();
                if (tak.equalsIgnoreCase("tak")) {
                    clinicDAO.removeDoctor(doctorId);
                } else {

                }

            } else if (user.equals("8")) {
                // Lista lekarzy w bazie.
                System.out.println("Podaj Id lekarza");
                int doctorId = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Podaj imię lekarza");
                String firstName = keyboard.nextLine();
                System.out.println("Podaj Nazwisko lekarza");
                String lastName = keyboard.nextLine();
                System.out.println("Podaj specjlalizację");
                String spec = keyboard.nextLine();
                System.out.println("Podaj numer pokoju");
                String room = keyboard.nextLine();
                doctorDTO = new DoctorDTO(firstName,lastName,spec,room);
                clinicDAO.modifyDoctor(doctorId,doctorDTO);
            } else if (user.equals("9")) {
                // Lista lekarzy, 1. co chcesz zrobić? wybierz lekarza, dodaj, edytuj, usuń, wyjdź. 2. co chcesz zrobić?
                // usuń, edytuj, wyjdź
                // pokaż wizyty. 3. co chcesz zrobić? dodaj, edytuj, usuń.
                clinicDAO.getAllDoctors().forEach(System.out::println);

            } else if (user.equals("10")) {
                // Lista wizyt. Co chcesz zrobić? dodaj, edytuj, usuń, wyjdź.
                System.out.println("Podaj Id lekarza");
                int doctorId = keyboard.nextInt();
//                System.out.println(clinicDAO.getAppByDoctorId(doctorId,true));
                clinicDAO.getAppByDoctorId(doctorId,false).forEach(System.out::println);
            } else if (user.equals("11")) {
                // Lista klientów, co chcesz zrobić? 1. wybierz klienta, wyjdź 2. dodaj, edytuj, usuń, wyjdź.
                System.out.println("Podaj pesel");
                String pesel = keyboard.nextLine();
                System.out.println(clinicDAO.getClient(pesel));
            } else if (user.equals("12")) {
                visitFactory.menu();
            }
        }

        clinicDAO.factoryClose();
    }



}
