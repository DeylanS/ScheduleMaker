package schedulemaker;
import java.util.*;


class Schedule {
    private static final int START_HOUR = 8;
    private static final int END_HOUR = 18;
    private static final int SUBJECT_DURATION = 2;

    public static void main(String[] args) {
        List<String> subjects = Arrays.asList("Math", "English", "Science", "History", "Geography", "Art");

        Map<String, Map<String, String>> timetable = initializeTimetable();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n----- TIMETABLE EDITOR -----");
            System.out.println("1. View Timetable");
            System.out.println("2. Insert Subject");
            System.out.println("3. Remove Subject");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayTimetable(timetable);
                    break;
                case 2:
                    insertSubject(timetable, subjects, scanner);
                    break;
                case 3:
                    removeSubject(timetable, scanner);
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the Timetable Editor. Goodbye!");
    }

    public static Map<String, Map<String, String>> initializeTimetable() {
        Map<String, Map<String, String>> timetable = new HashMap<>();

        List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

        for (String day : days) {
            Map<String, String> dayTimetable = new HashMap<>();
            for (int hour = START_HOUR; hour < END_HOUR; hour += SUBJECT_DURATION) {
                dayTimetable.put(String.format("%02d:00 - %02d:00", hour, hour + SUBJECT_DURATION), "");
            }
            timetable.put(day, dayTimetable);
        }

        return timetable;
    }

    public static void displayTimetable(Map<String, Map<String, String>> timetable) {
        System.out.println("\n----- TIMETABLE -----");
        for (Map.Entry<String, Map<String, String>> entry : timetable.entrySet()) {
            String day = entry.getKey();
            Map<String, String> dayTimetable = entry.getValue();

            System.out.println("\n" + day + ":");
            for (Map.Entry<String, String> slotEntry : dayTimetable.entrySet()) {
                String timeSlot = slotEntry.getKey();
                String subject = slotEntry.getValue();

                System.out.println(timeSlot + ": " + (subject.isEmpty() ? "No subject" : subject));
            }
        }
    }

    public static void insertSubject(Map<String, Map<String, String>> timetable, List<String> subjects, Scanner scanner) {
        System.out.println("\nAvailable subjects: " + subjects);

        System.out.print("Enter the subject: ");
        String subject = scanner.nextLine();

        if (!subjects.contains(subject)) {
            System.out.println("Invalid subject. Please try again.");
            return;
        }

        System.out.println("Available days: Monday, Tuesday, Wednesday, Thursday, Friday");

        System.out.print("Enter the day: ");
        String day = scanner.nextLine();

        if (!timetable.containsKey(day)) {
            System.out.println("Invalid day. Please try again.");
            return;
        }

        Map<String, String> dayTimetable = timetable.get(day);

        System.out.println("Available time slots:");
        List<String> availableSlots = getAvailableSlots(dayTimetable);
        for (int i = 0; i < availableSlots.size(); i++) {
            System.out.println((i + 1) + ". " + availableSlots.get(i));
        }

        System.out.print("Enter the number of the time slot: ");
        int slotNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (slotNumber < 1 || slotNumber > availableSlots.size()) {
            System.out.println("Invalid time slot number. Please try again.");
            return;
        }

        String selectedSlot = availableSlots.get(slotNumber - 1);
        dayTimetable.put(selectedSlot, subject);
        System.out.println("Subject inserted into the timetable.");
    }

    public static void removeSubject(Map<String, Map<String, String>> timetable, Scanner scanner) {
        System.out.println("\n----- REMOVE SUBJECT -----");
        System.out.println("Available days: Monday, Tuesday, Wednesday, Thursday, Friday");

        System.out.print("Enter the day: ");
        String day = scanner.nextLine();

        if (!timetable.containsKey(day)) {
            System.out.println("Invalid day. Please try again.");
            return;
        }

        Map<String, String> dayTimetable = timetable.get(day);

        System.out.println("Current timetable for " + day + ":");
        displayTimetableForDay(dayTimetable);

        System.out.print("Enter the time slot to remove the subject from: ");
        String timeSlot = scanner.nextLine();

        if (!dayTimetable.containsKey(timeSlot)) {
            System.out.println("Invalid time slot. Please try again.");
            return;
        }

        dayTimetable.put(timeSlot, "");
        System.out.println("Subject removed from the timetable.");
    }

    public static List<String> getAvailableSlots(Map<String, String> dayTimetable) {
        List<String> availableSlots = new ArrayList<>();
        for (Map.Entry<String, String> entry : dayTimetable.entrySet()) {
            String timeSlot = entry.getKey();
            String subject = entry.getValue();

            if (subject.isEmpty()) {
                availableSlots.add(timeSlot);
            }
        }
        return availableSlots;
    }

    public static void displayTimetableForDay(Map<String, String> dayTimetable) {
        for (Map.Entry<String, String> entry : dayTimetable.entrySet()) {
            String timeSlot = entry.getKey();
            String subject = entry.getValue();

            System.out.println(timeSlot + ": " + (subject.isEmpty() ? "No subject" : subject));
        }
    }
}