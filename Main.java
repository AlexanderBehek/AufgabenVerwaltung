import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Aufgabenverwaltung ---");
            System.out.println("1. Aufgabe hinzufügen");
            System.out.println("2. Aufgabe entfernen");
            System.out.println("3. Status ändern");
            System.out.println("4. Alle Aufgaben auflisten");
            System.out.println("5. Aufgaben nach Status auflisten");
            System.out.println("6. Aufgaben nach Priorität auflisten");
            System.out.println("7. Statistik anzeigen");
            System.out.println("8. Beenden");
            System.out.print("Wahl: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Beschreibung: ");
                    String desc = scanner.nextLine();
                    System.out.print("Priorität (LOW, MEDIUM, HIGH): ");
                    String pr = scanner.nextLine().toUpperCase();
                    manager.addTask(new SimpleTask(desc, pr));
                    break;
                case 2:
                    System.out.print("ID der zu entfernenden Aufgabe: ");
                    int remId = Integer.parseInt(scanner.nextLine());
                    manager.removeTask(remId);
                    break;
                case 3:
                    System.out.print("ID: ");
                    int updId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Neuer Status (OPEN, IN_PROGRESS, DONE): ");
                    String st = scanner.nextLine().toUpperCase();
                    manager.updateTaskStatus(updId, st);
                    break;
                case 4:
                    manager.listTasks();
                    break;
                case 5:
                    System.out.print("Status (OPEN, IN_PROGRESS, DONE): ");
                    String filterStatus = scanner.nextLine().toUpperCase();
                    manager.listTasksByStatus(filterStatus);
                    break;
                case 6:
                    System.out.print("Priorität (LOW, MEDIUM, HIGH): ");
                    String filterPriority = scanner.nextLine().toUpperCase();
                    manager.listTasksByPriority(filterPriority);
                    break;
                case 7:
                    manager.printStatistics();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Wahl.");
            }
        }

        scanner.close();
        System.out.println("Programm beendet.");
    }
}