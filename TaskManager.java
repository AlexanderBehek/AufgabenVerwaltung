import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Aufgabe hinzugefügt: " + task);
    }

    public void removeTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                System.out.println("Aufgabe mit ID " + id + " entfernt.");
                return;
            }
        }
        System.out.println("Aufgabe mit ID " + id + " nicht gefunden.");
    }

    public void updateTaskStatus(int id, String newStatus) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setStatus(newStatus);
                System.out.println("Status von Aufgabe " + id + " geändert zu " + newStatus + ".");
                return;
            }
        }
        System.out.println("Aufgabe mit ID " + id + " nicht gefunden.");
    }

    public void listTasks() {
        System.out.println("Alle Aufgaben:");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void listTasksByStatus(String status) {
        System.out.println("Aufgaben mit Status " + status + ":");
        for (Task t : tasks) {
            if (t.getStatus().equals(status)) {
                System.out.println(t);
            }
        }
    }

    public void listTasksByPriority(String priority) {
        System.out.println("Aufgaben mit Priorität " + priority + ":");
        for (Task t : tasks) {
            if (t.getPriority().equals(priority)) {
                System.out.println(t);
            }
        }
    }

    public void printStatistics() {
        int total = tasks.size();
        int open = 0;
        int inProgress = 0;
        int done = 0;
        int low = 0;
        int medium = 0;
        int high = 0;

        for (Task t : tasks) {
            // Status count
            if (t.getStatus().equals("OPEN")) open++;
            else if (t.getStatus().equals("IN_PROGRESS")) inProgress++;
            else if (t.getStatus().equals("DONE")) done++;
            // Priority count
            if (t.getPriority().equals("LOW")) low++;
            else if (t.getPriority().equals("MEDIUM")) medium++;
            else if (t.getPriority().equals("HIGH")) high++;
        }

        System.out.println("\n=== Statistik ===");
        System.out.println("Gesamtanzahl: " + total);
        System.out.println("Offen: " + open + ", In Bearbeitung: " + inProgress + ", Erledigt: " + done);
        System.out.println("Priorität - Niedrig: " + low + ", Mittel: " + medium + ", Hoch: " + high);
        System.out.println("=================\n");
    }
}

