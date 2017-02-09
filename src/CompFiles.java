
import java.io.*;

public class CompFiles {
    public static void main(String[] args){
        int i, j;
        int count = 0;

        if(args.length !=2){
            System.out.println("Использование: CompFiles файл1 файл2");
            return;
        }

        try(FileInputStream f1 = new FileInputStream(args[0]);
            FileInputStream f2 = new FileInputStream(args[1]))
        {
            do{
                count++;
                i = f1.read();
                j = f2.read();
                System.out.println("Сравниваю i = " + i + " j = " + j) ;
                if((i >=65) & (i <=90)) {
                    if((i != j) && ((i+32) !=j)) {
                        System.out.println("i = " + i + " j = " + j + " алгоритм сравнивания +32");
                        break;
                    }
                    }
                 else if((i >=97) & (i <=122)) {
                    if ((i != j) && ((i - 32) != j)) {
                        System.out.println("i = " + i + " j = " + j + " алгоритм сравнивания +32");
                        break;
                    }
                }
                    else if (i != j) break;



            } while(i != -1 && j != -1);
            if(i != j)
                System.out.println("Содержимое файлов отличается в символе номер "+ count);

            else
                System.out.println("Содержимое файлов совпадает");
        } catch (IOException exc){
            System.out.println("Ошибка ввода-вывода: " +exc);
        }

    }

}

