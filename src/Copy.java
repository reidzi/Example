import java.io.*;

public class Copy {
    public static void main(String[] args){
        int a;
        try (FileWriter fout = new FileWriter("output.txt");
             FileReader fin = new FileReader("input.txt"))
        {

            do {
                a = fin.read();
                if(a == 32) a = 45;

                    if(a != -1) fout.write(a);

            } while( a != -1);
        }
        catch (FileNotFoundException exc){
            System.out.println("Не найден входящий файл.");
        }
        catch (IOException exc){
            System.out.println("Ошибка ввода-вывода");
        }

        }



}

