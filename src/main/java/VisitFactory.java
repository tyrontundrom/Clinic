import model.Appointment;
import model.AppointmentDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class VisitFactory {

    private ClinicDAO clinicDAO;
    private List<AppointmentDetails> appointments;
    private Scanner scanner, scanInt;

    private int doctorId;
    private LocalDate startDay, endDay;
    private LocalTime startTime, endTime;

    public VisitFactory(ClinicDAO clinicDAO) {
        this.clinicDAO = clinicDAO;
        scanner = new Scanner(System.in);
        scanInt = new Scanner(System.in);
    }

    private boolean checkIfVisitTermExist(LocalDateTime dateTime) {

        if (appointments.stream().anyMatch(a -> a.getDateTime().equals(dateTime))) {
            return true;
        } else {
            return false;
        }
    }

    public void menu() {
        String choice = "";
        do {
            showMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    getDoctorId();
                    showAppointsments();
                    break;
                case "2":
                    setAppointmentsDetailsToAdd();
                    addAppointments();
                    showAppointsments();
                    break;
                case "3":
                    setAppointmentsDetailsToRemove();
                    removeAppointments();
                    showAppointsments();
                    break;
            }
        } while (!"x".equalsIgnoreCase(choice));
    }

    private void showAppointsments() {
        clinicDAO.getAppByDoctorId(doctorId, false).forEach(System.out::println);
//        List<AppointmentDetails> appByDoctorId = clinicDAO.getAppByDoctorId(doctorId, false);
//        appByDoctorId.forEach(System.out::println);
    }

    public void showAppointsments(int doctorId) {
        clinicDAO.getAppByDoctorId(doctorId, false).forEach(System.out::println);
//        List<AppointmentDetails> appByDoctorId = clinicDAO.getAppByDoctorId(doctorId, false);
//        appByDoctorId.forEach(System.out::println);
    }

    public void addAppointments() {
        int period = 30;
        LocalDate currentDay = startDay;
        LocalTime currentTime = startTime;
        while (currentDay.isBefore(endDay.plusDays(1))) {
            while (currentTime.isBefore(endTime)) {
                LocalDateTime dateTime = currentDay.atTime(currentTime);
                clinicDAO.addDoctorAppointment(doctorId, dateTime);
                currentTime = currentTime.plusMinutes(period);
            }
            currentDay = currentDay.plusDays(1);
            currentTime = startTime;
        }
    }

    private void removeAppointments() {
        LocalDate currentDay = startDay;
        while (currentDay.isBefore(endDay.plusDays(1))) {

            LocalDateTime from = currentDay.atTime(startTime);
            LocalDateTime to = currentDay.atTime(endTime);

            List<Appointment> appointments = clinicDAO.getDoctorAppointmentsBetween(doctorId, from, to);
            appointments.forEach(a -> clinicDAO.removeDoctorAppointment(a.getId()));
            System.out.println("Usunięto: ");
            appointments.forEach(System.out::println);

            currentDay = currentDay.plusDays(1);
        }
        System.out.println("\nPozostały harmonogram:\n");
    }

    private void setAppointmentsDetailsToRemove() {
        getDoctorId();
        System.out.println("Podaj pierwszy dzień w formacie 'yyyy-mm-dd'");
        startDay = getDate();
        System.out.println("Podaj ostatni dzień w formacie 'yyyy-mm-dd'");
        endDay = getDate();
        System.out.println("Podaj godzinę od w formacie 'hh:mm'");
        startTime = getTime();
        System.out.println("Podaj godzinę do w formacie 'hh:mm'");
        endTime = getTime();
    }

    private void setAppointmentsDetailsToAdd() {

        showDoctors();
        getDoctorId();
        System.out.println("Podaj pierwszy dzień w formacie 'yyyy-mm-dd'");
        startDay = getDate();
        System.out.println("Podaj ostatni dzień w formacie 'yyyy-mm-dd'");
        endDay = getDate();
        System.out.println("Podaj godzinę rozpoczęcia pracy w formacie 'hh:mm'");
        startTime = getTime();
        System.out.println("Podaj godzinę zakończenia pracy w formacie 'hh:mm'");
        endTime = getTime();
    }

    private void showDoctors() {
        System.out.println("\nLista lekarzy:");
        clinicDAO.getAllDoctors().forEach(System.out::println);
        System.out.println();
    }

    private void getDoctorId() {
        showDoctors();
        System.out.println("Podaj ID lekarza");
        int[] id = {0};
        boolean exist = false;
        do {
            id[0] = scanInt.nextInt();
            if (!clinicDAO.getAllDoctors().stream().anyMatch(x -> x.getId() == id[0])) {
                System.out.println("Nie ma lekarza o takim ID");
            } else exist = true;
        } while (!exist);
        doctorId = id[0];
    }

    private LocalDate getDate() {
        System.out.println("[Enter] - dzisiejsza data: " + LocalDate.now());
        LocalDate date = null;
        String dateAsString = scanner.nextLine();
        if ("".equals(dateAsString)) {
            date = LocalDate.now();
        }
        while (date == null) {
            try {
                date = LocalDate.parse(dateAsString);
            } catch (DateTimeParseException e) {
                System.out.println("Błedny format daty, musi być podana w formacie 'yyyy-mm-dd'");
            }
        }
        return date;
    }

    private LocalTime getTime() {
        LocalTime time = null;
        do {
            try {
                time = LocalTime.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Błedny format godziny, musi być podana w formacie 'hh:mm'");
            }
        } while (time == null);
        return time;
    }

    private void showMenu() {
        System.out.println("\nObsługa harmonogramu wizyt lekarzy:");
        System.out.println("1. Wyświetl");
        System.out.println("2. Dodaj");
        System.out.println("3. Usuń");
        System.out.println("x. Wyjście");
    }

}
