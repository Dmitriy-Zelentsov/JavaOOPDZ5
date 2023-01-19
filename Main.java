import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AttendanceService attendanceService = new AttendanceService();

        attendanceService.addLogAttendance("Зеленцов", LocalDate.of(2023, 1, 11), true);
        attendanceService.addLogAttendance("Зеленцов", LocalDate.of(2023, 1, 12), true);
        attendanceService.addLogAttendance("Зеленцов", LocalDate.of(2023, 1, 13), true);
        attendanceService.addLogAttendance("Зеленцов", LocalDate.of(2023, 1, 14), true);
        attendanceService.addLogAttendance("Зеленцов", LocalDate.of(2023, 1, 15), true);


        attendanceService.addLogAttendance("Рабе", LocalDate.of(2023, 1, 11), true);
        attendanceService.addLogAttendance("Рабе", LocalDate.of(2023, 1, 12), false);
        attendanceService.addLogAttendance("Рабе", LocalDate.of(2023, 1, 13), true);
        attendanceService.addLogAttendance("Рабе", LocalDate.of(2023, 1, 14), true);
        attendanceService.addLogAttendance("Рабе", LocalDate.of(2023, 1, 15), true);

        attendanceService.addLogAttendance("Учайкин", LocalDate.of(2023, 1, 11), true);
        attendanceService.addLogAttendance("Учайкин", LocalDate.of(2023, 1, 12), false);
        attendanceService.addLogAttendance("Учайкин", LocalDate.of(2023, 1, 13), false);
        attendanceService.addLogAttendance("Учайкин", LocalDate.of(2023, 1, 14), true);
        attendanceService.addLogAttendance("Учайкин", LocalDate.of(2023, 1, 15), true);

        attendanceService.addLogAttendance("Кукушкин", LocalDate.of(2023, 1, 11), true);
        attendanceService.addLogAttendance("Кукушкин", LocalDate.of(2023, 1, 12), false);
        attendanceService.addLogAttendance("Кукушкин", LocalDate.of(2023, 1, 13), false);
        attendanceService.addLogAttendance("Кукушкин", LocalDate.of(2023, 1, 14), false);
        attendanceService.addLogAttendance("Кукушкин", LocalDate.of(2023, 1, 15), false);


        attendanceService.addLogAttendance("Деев", LocalDate.of(2023, 1, 11), false);
        attendanceService.addLogAttendance("Деев", LocalDate.of(2023, 1, 12), false);
        attendanceService.addLogAttendance("Деев", LocalDate.of(2023, 1, 13), false);
        attendanceService.addLogAttendance("Деев", LocalDate.of(2023, 1, 14), false);
        attendanceService.addLogAttendance("Деев", LocalDate.of(2023, 1, 15), true);

        attendanceService.addLogAttendance("Лосев", LocalDate.of(2023, 1, 11), true);
        attendanceService.addLogAttendance("Лосев", LocalDate.of(2023, 1, 12), false);
        attendanceService.addLogAttendance("Лосев", LocalDate.of(2023, 1, 13), false);
        attendanceService.addLogAttendance("Лосев", LocalDate.of(2023, 1, 14), true);
        attendanceService.addLogAttendance("Лосев", LocalDate.of(2023, 1, 15), true);
        
        AttendanceView attendanceView = new AttendanceView(attendanceService);

        AttendancePresenter attendancePresenter = new AttendancePresenter(attendanceService, attendanceView);

        // System.out.println("Журнал посещаемости студентов:");
        // attendancePresenter.printAllAttendance();

        System.out.println("Текущая посещаемость студентов:");
        attendancePresenter.printCurrentAttendance();

        System.out.println("Журнал посещаемости студентов с сортировкой:");
        attendancePresenter.printSortedAttendance();

        System.out.println("Журнал посещаемости студентов менее 25%:");
        attendancePresenter.printLowAttendance();
    }     
}
