import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan nama file teks: ");
            String filename = scanner.nextLine();

            System.out.print("Masukkan jumlah baris per potongan: ");
            int linesPerPart = scanner.nextInt();
            scanner.nextLine(); 

            Queue<String> queue = new LinkedList<>();

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                queue.add(line);
            }
            br.close();

            System.out.println("File berhasil dibaca. Total baris: " + queue.size());

            int partNumber = 1;

            while (!queue.isEmpty()) {
                FileWriter writer = new FileWriter("part_" + partNumber + ".txt");

                for (int i = 0; i < linesPerPart && !queue.isEmpty(); i++) {
                    writer.write(queue.poll() + "\n");
                }

                writer.close();
                System.out.println("Membuat file: part_" + partNumber + ".txt");

                partNumber++;
            }

            System.out.println("\nPemotongan selesai!");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
