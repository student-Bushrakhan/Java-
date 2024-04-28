 // Date Differnce 
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifferenceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first date (yyyy-MM-dd):");
        String firstDateStr = scanner.nextLine();

        System.out.println("Enter the second date (yyyy-MM-dd):");
        String secondDateStr = scanner.nextLine();

        long differenceInDays = calculateDateDifference(firstDateStr, secondDateStr);

        // Output the result
        System.out.println("The difference between the two dates is: " + differenceInDays + " days.");

        scanner.close();
    }

    public static long calculateDateDifference(String firstDateStr, String secondDateStr) {
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        return Math.abs(ChronoUnit.DAYS.between(firstDate, secondDate));
    }
}


 // Time Conversion 
 import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time in 24-hour format (HH:mm):");
        String inputTime = scanner.nextLine();

        // Parse input time string into LocalTime object
        LocalTime time24 = LocalTime.parse(inputTime);

        // Convert to 12-hour format
        LocalTime time12 = time24.minusHours(12); // Subtract 12 hours to get AM/PM format

        // Format the time in 12-hour format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String time12Formatted = time12.format(formatter);

        // Output the result
        System.out.println("Time in 12-hour format: " + time12Formatted);

        scanner.close();
    }
}

 // Birthday Calculator
 import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for birth date
        System.out.println("Enter your birth date (yyyy-MM-dd):");
        String birthDateStr = scanner.nextLine();

        // Parse the input string to LocalDate
        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Calculate age
        int age = calculateAge(birthDate, currentDate);

        // Output the result
        System.out.println("Your age is: " + age + " years.");

        scanner.close();
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        // Calculate period between birth date and current date
        Period period = Period.between(birthDate, currentDate);
        // Extract years from the period
        return period.getYears();
    }
}

// Data Parsing 
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateParsing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for date string
        System.out.println("Enter a date string in the format yyyy-MM-dd:");
        String dateString = scanner.nextLine();

        try {
            // Parse the date string to a LocalDate object
            LocalDate date = LocalDate.parse(dateString);
            System.out.println("Parsed LocalDate: " + date);
        } catch (DateTimeParseException e) {
            // Handle parsing exception
            System.out.println("Error: Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        }

        scanner.close();
    }
}

// Duration Between Two Events 
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventDurationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for start and end times
        System.out.println("Enter the start time of the event (yyyy-MM-dd HH:mm):");
        String startTimeStr = scanner.nextLine();
        System.out.println("Enter the end time of the event (yyyy-MM-dd HH:mm):");
        String endTimeStr = scanner.nextLine();

        // Parse the input strings to LocalDateTime objects
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Calculate the duration between start and end times
        Duration duration = Duration.between(startTime, endTime);

        // Extract hours and minutes from the duration
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        // Output the result
        System.out.println("Duration of the event: " + hours + " hours and " + minutes + " minutes.");

        scanner.close();
    }
}

// Time Zone Conversion
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for date and time
        System.out.println("Enter the date and time (yyyy-MM-dd HH:mm):");
        String dateTimeStr = scanner.nextLine();

        // Prompt user for source time zone
        System.out.println("Enter the source time zone (e.g., UTC):");
        String sourceTimeZone = scanner.nextLine();

        // Prompt user for target time zone
        System.out.println("Enter the target time zone (e.g., America/Los_Angeles):");
        String targetTimeZone = scanner.nextLine();

        // Parse the input string to LocalDateTime object
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Convert to ZonedDateTime with source time zone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(sourceTimeZone));

        // Convert to target time zone
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

        // Output the result
        System.out.println("Converted date and time in " + targetTimeZone + ": " + targetZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z")));

        scanner.close();
    }
}

// Periodic Reminder 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for reminder details
        System.out.println("Enter the reminder message:");
        String reminderMessage = scanner.nextLine();

        System.out.println("Enter the date and time for the reminder (yyyy-MM-dd HH:mm):");
        String dateTimeString = scanner.nextLine();

        // Parse the input date and time
        LocalDateTime reminderDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Create a timer object
        Timer timer = new Timer();

        // Schedule the reminder task
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Display the reminder message when the scheduled time arrives
                System.out.println("Reminder: " + reminderMessage);
                // Terminate the timer
                timer.cancel();
            }
        }, java.sql.Timestamp.valueOf(reminderDateTime));

        System.out.println("Reminder set successfully.");

        scanner.close();
    }
}

// Date Time Validation 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateTimeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a date and time
        System.out.println("Enter a date and time in the format yyyy-MM-dd HH:mm:");
        String inputDateTime = scanner.nextLine();

        // Validate the input date and time
        if (isValidDateTime(inputDateTime)) {
            System.out.println("Valid date and time: " + inputDateTime);
        } else {
            System.out.println("Invalid date and time format or not a future date.");
        }

        scanner.close();
    }

    public static boolean isValidDateTime(String dateTimeStr) {
        try {
            // Parse the input string to LocalDateTime
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            // Check if the date and time are in the future
            LocalDateTime now = LocalDateTime.now();
            return dateTime.isAfter(now);
        } catch (DateTimeParseException e) {
            // Parsing error
            return false;
        }
    }
}

// Holidays Calender 
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HolidayCalendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a year
        System.out.println("Enter the year:");
        int year = scanner.nextInt();

        // Display the list of major holidays for the specified year
        Map<String, LocalDate> holidays = getMajorHolidays(year);
        System.out.println("Major holidays in " + year + ":");
        for (Map.Entry<String, LocalDate> entry : holidays.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    public static Map<String, LocalDate> getMajorHolidays(int year) {
        Map<String, LocalDate> holidays = new HashMap<>();

        // Add major holidays to the map
        holidays.put("New Year's Day", LocalDate.of(year, 1, 1));
        holidays.put("Valentine's Day", LocalDate.of(year, 2, 14));
        holidays.put("St. Patrick's Day", LocalDate.of(year, 3, 17));
        holidays.put("Easter Sunday", getEasterSunday(year));
        holidays.put("Independence Day", LocalDate.of(year, 7, 4));
        holidays.put("Halloween", LocalDate.of(year, 10, 31));
        holidays.put("Christmas Day", LocalDate.of(year, 12, 25));

        return holidays;
    }

    // Method to calculate Easter Sunday for the specified year (algorithm from Gauss)
    public static LocalDate getEasterSunday(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }
}

// Bonus Challenge 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalCalendar {
    private static Map<String, LocalDateTime> events = new HashMap<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your Personal Calendar!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Event");
            System.out.println("2. Edit Event");
            System.out.println("3. Delete Event");
            System.out.println("4. View Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEvent(scanner);
                    break;
                case 2:
                    editEvent(scanner);
                    break;
                case 3:
                    deleteEvent(scanner);
                    break;
                case 4:
                    viewEvents();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEvent(Scanner scanner) {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        events.put(eventName, dateTime);
        System.out.println("Event added successfully.");
    }

    private static void editEvent(Scanner scanner) {
        System.out.print("Enter event name to edit: ");
        String eventName = scanner.nextLine();

        if (events.containsKey(eventName)) {
            System.out.print("Enter new date and time (yyyy-MM-dd HH:mm): ");
            String dateTimeStr = scanner.nextLine();

            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            events.put(eventName, dateTime);
            System.out.println("Event edited successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private static void deleteEvent(Scanner scanner) {
        System.out.print("Enter event name to delete: ");
        String eventName = scanner.nextLine();

        if (events.containsKey(eventName)) {
            events.remove(eventName);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Events:");
            for (Map.Entry<String, LocalDateTime> entry : events.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue().format(formatter));
            }
        }
    }
}


