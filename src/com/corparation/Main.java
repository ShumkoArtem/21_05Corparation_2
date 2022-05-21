package com.corparation;

import static com.corparation.Methods.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main implements Serializable {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static File ListImployee = null;
    public static Corparation corparation = new Corparation();
    public static String pathFile;
    public static String pathFileLastNameImplouee;
    public static String pathFileAgeImplouee;
    public static List<Imployee> LastNameImployee = new ArrayList<>();
    public static List<Imployee> ageImployee = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        /**
         * Задание 5
         * Напишите информационную систему "Корпорация".
         * Программа должна обеспечивать:
         * ■■ ввод данных (создание Imployee);
         * ■■ редактирование данных сотрудника корпорации;
         * ■■ удаление сотрудника корпорации;
         * ■■ поиск сотрудника корпорации по фамилии;
         * ■■ вывод информации обо всех сотрудниках, указан-
         * ного возраста, или фамилия которых начинается на
         * указанную букву.
         * Организуйте возможность сохранения найденной
         * информации в файл.
         * Также весь список сотрудников корпорации сохраняется
         * в файл (при выходе из программы автоматически, в про-
         * цессе исполнения программы по команде пользователя).
         * При старте программы происходит загрузка списка
         * сотрудников
         */

        //путь к созданию папки
        String path = System.getProperty("user.dir");
        // имя папки
        String nameFolder = "Corparation";
        // метод создает папку по указанному пути и с указанным именем и возвращаем путь к папке
        String pathFolder = newFolder(path, nameFolder);
        //имя файла
        String nameFile = "ArrayListImployee.txt";
        // этот метод создает файл по указанному пути и с указанным именем и возвращает путь к созданному файлу
        pathFile = newFile(pathFolder, nameFile);
        // читаем объект из файла
        readFile(pathFile);

        pathFileLastNameImplouee = newFile(pathFolder, "ArrayListLastNameImployee.txt");
        // читаем объект из файла
        if (!pathFileLastNameImplouee.isEmpty()) {
            readFileLastName(pathFileLastNameImplouee);
        }

        pathFileAgeImplouee = newFile(pathFolder, "ArrayListAgeImployee.txt");
        // читаем объект из файла
        if (!pathFileAgeImplouee.isEmpty()) {
            readFileAge(pathFileAgeImplouee);
        }

        corparation.print();

        // меню
        menu();

        boolean flag = true;
        while (flag) {
            System.out.println("Выберите пункт из меню");
            String num = reader.readLine();
            switch (num) {
                case "1":
                    //1 ввод данных;
                    addImpl();
                    break;
                case "2":
                    //2 редактирование данных сотрудника корпорации
                    dataEditing();
                    break;
                case "3":
                    //удаление сотрудника корпорации (выбор по имени)
                    corparation.print();
                    removal();
                    break;
                case "4":
                    //поиск сотрудника корпорации по фамилии
                    search();
                    break;
                case "5":
                    //вывод информации обо всех сотрудниках, указанного возраста;
                    outInformationByAge();
                    break;
                case "6":
                    //вывод информации обо всех сотрудниках, фамилия которых начинается на указанную букву;
                    outInformationByLastName();
                    break;
                case "7":
                    //сохранение данных в файл
                    wreateFile(pathFile, corparation.getImployeeList());
                    break;
                case "0":
                    //выход
                    flag = false;
                    break;
            }
        }
        //метод записывает занные в файл (путь к файлу, объект)
        wreateFile(pathFile, corparation.getImployeeList());
    }

}
