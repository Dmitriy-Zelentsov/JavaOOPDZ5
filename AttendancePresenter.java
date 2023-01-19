import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AttendancePresenter {
    private AttendanceService attendanceService;
    private AttendanceView attendanceView;

    public AttendancePresenter(AttendanceService attendanceService, AttendanceView attendanceView) {
        this.attendanceService = attendanceService;
        this.attendanceView = attendanceView;
    }

    ///////////////// вывести текущую посещаемость всех студентов
    public void printCurrentAttendance() {
        Map<String, Map<LocalDate, Boolean>> loggerAttendance = attendanceService.getLogAttendance();
        for (String student : loggerAttendance.keySet()) {
            Map<LocalDate, Boolean> studentLogAttendance = loggerAttendance.get(student);
            double attendanceGrade = 100.0 * (double) studentLogAttendance.values().stream().filter(a -> a).count() / (double) studentLogAttendance.size();
            System.out.println(student + " : " + attendanceGrade + "%");
        }
        System.out.println();
    }

    //////////////////// вывод с сортировкой
    public void printSortedAttendance() {
        Map<String, Map<LocalDate, Boolean>> loggerAttendance = attendanceService.getLogAttendance();

        ////////////////////// сортировка по посещаемости
        TreeMap<Double, List<String>> sortedLogAttendance = new TreeMap<>();
        for (String student : loggerAttendance.keySet()) {
            Map<LocalDate, Boolean> studentLogAttendance = loggerAttendance.get(student);

            double attendanceGrade = 100.0 * (double) studentLogAttendance.values().stream().filter(a -> a).count() / (double) studentLogAttendance.size();

            // добавление отсортированных данных
            if (!sortedLogAttendance.containsKey(attendanceGrade)) {
                sortedLogAttendance.put(attendanceGrade, new ArrayList<>());
            }
            sortedLogAttendance.get(attendanceGrade).add(student);
        }

        ////////////////////////////////// визуализация
        for (double attendanceGrade : sortedLogAttendance.descendingKeySet()) {
            System.out.println("Посещаемость: " + attendanceGrade + "%");
            for (String student : sortedLogAttendance.get(attendanceGrade)) {
                System.out.println(student);
            }
            System.out.println();
        }
    }
    /////////////////////////////////////// вывод с сортировкой менее 25%
    public void printLowAttendance() {
        Map<String, Map<LocalDate, Boolean>> loggerAttendance = attendanceService.getLogAttendance();

        ///////////////////add с посещаемостью ниже 25%
        List<String> studentsLowAttendance = new ArrayList<>();
        for (String student : loggerAttendance.keySet()) {
            Map<LocalDate, Boolean> studentLogAttendance = loggerAttendance.get(student);

            double attendanceGrade = 100.0 * (double) studentLogAttendance.values().stream().filter(a -> a).count() / (double) studentLogAttendance.size();
            if (attendanceGrade <= 25.0) {
                studentsLowAttendance.add(student);
            }
        }

        /////////////////////// выод с посещаемостью ниже 25%
        for (String student : studentsLowAttendance) {
            System.out.println(student);
        }
    }
}