package com.corparation;

import static com.corparation.Main.*;
import java.io.*;
import java.util.List;

public class Methods {


    //вывод информации обо всех сотрудниках, фамилия которых начинается на указанную букву;
    public static void outInformationByLastName() throws IOException {
        System.out.println("Введите первую букву шамилии");
        String s = reader.readLine();
        for (Imployee i : corparation.getImployeeList()) {
            char[] ch = i.getLastName().toCharArray();
            if (ch[0] == s.charAt(0)) {
                ageImployee.add(i);
                System.out.println(i);
            }
        }
        wreateFile(pathFileAgeImplouee, ageImployee);
    }

    //вывод информации обо всех сотрудниках, указанного возраста;
    public static void outInformationByAge() throws IOException {
        System.out.println("Введите возраст сотрудников информацию о которых хотите получить");
        int age = Integer.parseInt(reader.readLine());
        for (Imployee i : corparation.getImployeeList()) {
            if (age == i.getAge()) {
                LastNameImployee.add(i);
                System.out.println(i);
            }
        }
        wreateFile(pathFileLastNameImplouee, LastNameImployee);
    }

    //поиск сотрудника корпорации по фамилии
    public static void search() throws IOException {
        corparation.print();
        System.out.println("Введите фамилию сотрудника которого ищите");
        String lastName = reader.readLine();
        for (Imployee i : corparation.getImployeeList()) {
            if (i.getLastName().equals(lastName)) {
                System.out.println(i);
            }
        }
    }

    //удаление сотрудника корпорации (выбор по имени)
    public static void removal() throws IOException {
        System.out.println("Введите имя сотрудника которого хотите удалить из списка");
        String removeImpl = reader.readLine();
        boolean b = corparation.getImployeeList().removeIf(x -> x.getName().equals(removeImpl));
        if (b) {
            System.out.println("Сотрудник " + removeImpl + " удален!!!");
        } else {
            System.out.println("Сотрудника с таким именем нет в списке!!!");
        }
    }

    //2 редактирование данных сотрудника корпорации
    public static void dataEditing() throws IOException {
        corparation.print();
        int length = corparation.getImployeeList().size() + 1;
        System.out.println("Введите порядковый номер сотрудника которого хотите отредактировать");
        int id = Integer.parseInt(reader.readLine());
        for (Imployee i : corparation.getImployeeList()) {
            if (id == i.getId()) {
                System.out.println("Вы выбрали сотрудника :\n" + i.toString());
                System.out.println("1 - изменить имя\n" +
                        "2 - изменить фамилию\n" +
                        "3 - изменить возрост:");
                String num = reader.readLine();
                switch (num) {
                    case "1":
                        System.out.println("Введите новое имя");
                        i.setName(reader.readLine());
                        System.out.println("Данные сотрудника изменены");
                        break;
                    case "2":
                        System.out.println("Введите новую фамилию");
                        i.setLastName(reader.readLine());
                        System.out.println("Данные сотрудника изменены");
                        break;
                    case "3":
                        System.out.println("Введите новый возрост");
                        try {
                            i.setAge(Integer.parseInt(reader.readLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Некоректно введен возрост!!!");
                        }
                        System.out.println("Данные сотрудника изменены");
                        break;
                }
            }
        }
    }

    public static void readFileAge(String pathFileAgeImplouee) {
        try (FileInputStream fis = new FileInputStream(pathFileAgeImplouee);
             ObjectInputStream object = new ObjectInputStream(fis)) {
            ageImployee = (List) object.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readFileLastName(String pathFileLastNameImplouee) {
        try (FileInputStream fis = new FileInputStream(pathFileLastNameImplouee);
             ObjectInputStream object = new ObjectInputStream(fis)) {
            LastNameImployee = (List) object.readObject();

            System.out.println("nsvkj           *********  " + LastNameImployee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //метод записывает занные в файл (путь к файлу, объект)
    public static void wreateFile(String pathFile, List<Imployee> imployeeList) {
        try (FileOutputStream fos = new FileOutputStream(pathFile);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fos)) {
            objectOutput.writeObject(imployeeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String newFile2(String pathFolder, String nameFile) {
        String pathFileListImployee = pathFolder + File.separator + nameFile;
        ListImployee = new File(pathFileListImployee);
        return pathFileListImployee;
    }

    // этот метод создает файл по указанному пути и с указанным именем и возвращает путь к созданному файлу
    public static String newFile(String pathFolder, String nameFile) {
        String pathFileListImployee = pathFolder + File.separator + nameFile;
        ListImployee = new File(pathFileListImployee);

        if (ListImployee.exists()) { // проверяем существует ли файл
            System.out.println("Файл " + nameFile + " уже существует");

        } else {
            try {
                ListImployee.createNewFile();//создаем файл
                System.out.println("Файл " + nameFile + " создан!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pathFileListImployee; //возвращаем путь к файлу
    }

    // метод создает папку по указанному пути и с указанным именем и возвращаем путь к папке
    public static String newFolder(String path, String nameFolder) {
        String pathForFolder = path + File.separator + nameFolder;

        File file1 = new File(pathForFolder);
        if (file1.mkdir()) { // если папка существует то false и это действие не выполнится
            System.out.println("Создалась папка " + nameFolder + "!!!");
            file1.mkdir(); // создание папки
        } else {
            System.out.println("Папка " + nameFolder + " еже существует");
        }
        return pathForFolder;
    }

    //читаем из файла (путь к папке)
    public static void readFile(String p) {
        try (FileInputStream fis = new FileInputStream(p);
             ObjectInputStream object = new ObjectInputStream(fis)) {
            List<Imployee> i = (List) object.readObject();
            corparation.setImployeeList(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // метод для ввода данных
    public static void addImpl() throws IOException {
        int implId = corparation.getImployeeList().size() + 1;
        System.out.println("Введите имя");
        String implName = reader.readLine();
        System.out.println("Введите фамилию");
        String implLastName = reader.readLine();
        System.out.println("Введите возрост");
        int implAge = Integer.parseInt(reader.readLine());
        Imployee i = new Imployee(implId, implName, implLastName, implAge);
        corparation.addList(i);
    }

    public static void menu() {
        System.out.println("1 ввод данных;\n" +
                "2 редактирование данных сотрудника корпорации;\n" +
                "3 удаление сотрудника корпорации;\n" +
                "4 поиск сотрудника корпорации по фамилии;\n" +
                "5 вывод информации обо всех сотрудниках, указанного возраста;\n" +
                "6 вывод информации обо всех сотрудниках, фамилия которых начинается на указанную букву; \n" +
                "7 сохранение данных в файл; \n" +
                "0 выход.");
    }
}
