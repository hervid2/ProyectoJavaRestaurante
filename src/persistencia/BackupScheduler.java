package persistencia;

import java.util.Timer;
import java.util.TimerTask;

public class BackupScheduler {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                realizarBackup();
            }
        }, 0, 24 * 60 * 60 * 1000); // Ejecutar cada 24 horas
    }

    private static void realizarBackup() {
        try {
            String command = "mysqldump -u root -ppassword restaurante > backup.sql";
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Backup realizado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}