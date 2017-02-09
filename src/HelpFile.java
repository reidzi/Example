import java.io.*;

class Help{
    private String helpfile;
    Help(String fname) {
        helpfile = fname;
    }
    boolean helpon(String what){
        int ch;
        String topic, info;
        try (BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile))){
            do{
                ch = helpRdr.read();
                if(ch == '#'){
                    topic = helpRdr.readLine();
                    System.out.println("найдена тема " + topic);
                    System.out.println("Сравниваю" + topic + " " + what);
                    if(what.compareTo(topic) == 0) {
                        do {info = helpRdr.readLine();
                            if(info != null) System.out.println(info);
                        }while ((info != null) && (info.compareTo("") !=0));
                        return true;
                    }
                }

            }while (ch != -1);
        }
        catch (IOException exc){
            System.out.println("Ошибка при попытке доступа к файлу справки.");
            return false;
        }
        return false;
    }

    String getSelection(){
        String topic = "";
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"Cp866"));
        System.out.print("Укажите тему: ");

            topic = br.readLine();
        }
        catch (UnsupportedEncodingException exc) {
            System.out.println("Не подходящая кодировка.");
        }
        catch (IOException exc) {
            System.out.println("Ошибка при чтении с консоли.");
        }

        return topic;
    }
}
class HelpFile {
    public static void main(String[] args){
        Help helpobj = new Help("helpfile.txt");
        String topic;
        System.out.println("Воспользуйтесь справочной системой.\n" + "Для выхода из системы введите 'stop'.");
        do{
            topic = helpobj.getSelection();
            if(!helpobj.helpon(topic))
                System.out.println("Тема не найдена.\n");
        }while(topic.compareTo("stop") != 0);
    }

}
