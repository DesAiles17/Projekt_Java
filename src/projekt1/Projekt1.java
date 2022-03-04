package projekt1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class Projekt1 {
    public static void main(String[] args) throws IOException {
       
        Scanner kl=new Scanner(System.in);
        Person men = new Person();
        Interfejs menu = new Interfejs(); 
        try {
            File file = new File("BazaDanych.txt");
            FileWriter plikZapisywany;
            plikZapisywany=new FileWriter(file, true);
            int a = 0;
            while (a!=6) {
                System.out.println(" 1 - " + menu.getA1() + "\n 2 - " + menu.getA2() + "\n 3 - " + menu.getA3() + "\n 4 - " + menu.getA4() + "\n 5 - " + menu.getA5() + "\n 6 - " + menu.getA6() + "\n");
                a = getSelectedItem(6);
                
                switch (a) {
                    case 1 : PiszdoBd();
                    break;
                    case 2 : Czytaj();
                    break;
                    case 3 : Certyfikat();
                    break;
                    case 4 : EditMenu(menu);
                    break;
                    case 5 : searchMenu();
                    break;
                }
            }
            plikZapisywany.close();
        }     
        catch (FileNotFoundException ex) { System.err.println("Nie udało się otworzyć pliku do odczytu/ zapisu..."); }
        catch (IOException ex){System.out.println("Koniec pliku do odczytu...");}  
    }
    
    private static String getLine(String type) {
    Scanner scanner = new Scanner(System.in);
    String line = "";
    boolean OK;
    do {
        try {
            OK = true;
            System.out.printf("Podaj %s :\n>", type);
            line = scanner.nextLine();
            if (line == "") {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ex) {
            OK = false;
            System.err.println("Incorrect input. Podaj jeszcze raz:");
        }
    } while (!OK);
    return line;
    }
    
    public static int getInt(String type) {
    Scanner scanner = new Scanner(System.in);
    String line;
    int item = 0;
    boolean OK;
    do {
        try {
            OK = true;
            System.out.printf("Podaj %s :\n>", type);
            line = scanner.nextLine();
            item = Integer.parseInt(line);
        } catch (InputMismatchException | NumberFormatException ex) {
            OK = false;
            System.err.println("Incorrect input. Podaj jeszcze raz:");
        }
    } while (!OK);

    return item;
}
    
    public static int getSelectedItem(int maxMenuItem) {
    Scanner scanner = new Scanner(System.in);
    String line;
    int item = 0;
    boolean OK;
    do {
        try {
            OK = true;
            System.out.print("Podaj pozycję menu:\n>");
            line = scanner.nextLine();
            item = Integer.parseInt(line);
            if (item <= 0 || item > maxMenuItem) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException | NumberFormatException ex) {
            OK = false;
            System.err.println("Incorrect input. Podaj jeszcze raz:");
        }
    } while (!OK);
    return item;
    }
    
    public static void searchMenu() {
        boolean OK = true;
        while (OK) {
            System.out.println("\n***************************");
            System.out.println("1 - Wyszukiwanie według imienia/nazwiska/numeru telefonu/e-mailu/numeru certyfikatu/numeru umowy/numeru karty");
            /*System.out.println("2 - Wyszukiwanie według nazwiska");
            System.out.println("3 - Wyszukiwanie według numeru telefonu");
            System.out.println("4 - Wyszukiwanie według e-mailu");
            System.out.println("5 - Wyszukiwanie według numeru certyfikatu");
            System.out.println("6 - Wyszukiwanie według numeru umowy");
            System.out.println("7 - Wyszukiwanie według numeru karty");*/
            System.out.println("2 - Wyjście");
            int a = getSelectedItem(2);
            switch (a) {
                case 1:
               /* case 2:
               // case 3:
                //case 4:
                //case 5:
                //case 6:
                case 7:*/
                    Search();
                    break;
                case 2:
                    OK = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public static void EditMenu(Interfejs menu) {
        Scanner kl = new Scanner(System.in);
        int b=0;
        while (b!=7) {    
            
            System.out.println("\n************************************");
            System.out.println("Proszę wybrać element do edytowania: \n"
                + " 1 - " + "'"+ menu.getA1() +"'" 
                + "\n 2 - " + "'"+ menu.getA2() + "'"
                + "\n 3 - " + "'"+ menu.getA3() + "'"
                + "\n 4 - " + "'"+menu.getA4() +"'"
                + "\n 5 - " + "'"+menu.getA5() +"'"
                + "\n 6 - " + "'"+menu.getA6() +"'"
                + "\n 7 - " +"Zakończyć edycję" );
            b = getSelectedItem(7);             
           
        if (b!=7) {
            String edit = getLine("nowy tytuł");
            switch (b) {
                case 1 : menu.setA1(edit);
                break;
                case 2 : menu.setA2(edit);
                break;
                case 3 : menu.setA3(edit);
                break;
                case 4 : menu.setA4(edit);
                break;
                case 5 : menu.setA5(edit);
                break;
                case 6: menu.setA6(edit);
                break;
            }
        }
        }
    }   
    
    public static void PiszdoBd() {
        
        File csvFile = new File("BazaDanych.csv");
        FileWriter writer;

        File file = new File("BazaDanych.txt"); 
        FileWriter plikZapisywany;
        try {
            
            writer=new FileWriter(csvFile, true);
            
            plikZapisywany=new FileWriter(file, true);
            
            Person men = new Person();
            men.name = getLine("imię");
            men.nazwisko = getLine("nazwisko");
            men.nrtelefonu = getLine("numer telefonu w formacie +48XXXXXXXXX");
            men.mail = getLine("e-mail");
            men.nrcertyfikatu = getLine("numer certyfikatu");
            System.out.println("Podaj datę końca ważności certyfikatu");
            men.rok = getLine("rok w formacie 'XXXX'");
            men.mies = getLine("miesiąc w formacie 'XX'");
            men.dz = getLine("dzień w formacie 'XX'");
            System.out.println("Podaj czas końca ważności certyfikatu");
            men.godzina = getLine("godzinę w formacie 'XX'");
            men.min = getLine("minuty w formacie 'XX'");
            men.sek = getLine("sekundy w formacie 'XX'");
            men.nrkarty = getLine("numer karty");
            men.setRodKarty();
            men.nrumowy = getLine("numer umowy");
            men.setStatus();
            men.setUwagi();
            
            plikZapisywany.write(men.getName()+"###"+men.getNazwisko()+"###"+men.getNrTelefonu()+"###"+men.getMail()+"###"+men.getNrCertyfikatu()+"###"+men.getRok()+"###");
            plikZapisywany.write(men.getMies()+"###"+men.getDz()+"###"+men.getGod()+"###"+men.getMin()+"###"+men.getSek()+"###"+men.getNrKarty()+"###"+men.getRodKarty()+"###"+men.getNrUmowy()+"###"+men.getStatus()+"###"+men.getUwagi()+"\r\n");
            plikZapisywany.flush();
            
            writer.write(men.getName()+";"+men.getNazwisko()+";"+men.getNrTelefonu()+
           ";"+men.getMail()+";"+men.getNrCertyfikatu()+";"+men.getRok()+";"+men.getMies()+";"
            +men.getDz()+";"+men.getGod()+";"+men.getMin()
            +";"+men.getSek()+";"+men.getNrKarty()+";"+men.getRodKarty()+";"+men.getNrUmowy()
           +";"+men.getStatus()+";"+men.getUwagi()+"\r\n");
            writer.flush();
        }
        catch (FileNotFoundException ex) { System.err.println("Nie udało się otworzyć pliku do odczytu/ zapisu..."); }
        catch (IOException ex){System.out.println("Koniec pliku do odczytu...");}
    }
    
    public static void Czytaj() {
        File file=new File("BazaDanych.txt");
        try {
            Scanner kl=new Scanner(file);
            while (kl.hasNextLine()) {
                String[]lista = null;
                String delimeter = "###";
                String text = kl.nextLine();
                lista = text.split(delimeter);
                Show(lista);
            }
        }
        catch (FileNotFoundException ex) {System.out.println("Nie udało się otworzyć pliku do odczytu/ zapisu...");}
    }
    
    public static void Search() {
       
        File file=new File("BazaDanych.txt");
        try {
            int i=0,j =0;
            Scanner kl=new Scanner(file);
            Scanner linia = new Scanner(System.in);
            String par = getLine("dowolne dane z wymienionych (w formacie, jak są zapisane w bazie danych)"); 
            while (kl.hasNextLine()) {
                i++;
                String text = kl.nextLine();
                if (text.contains(par)) {
                    String[]lista = null;
                    String delimeter = "###";
                    lista = text.split(delimeter);
                    Show(lista);      
                } 
                else j++;
            }    
            if (j==i) System.out.println("Nie znaleziono żadnego meczu!");
        }
        catch (FileNotFoundException ex) { System.err.println("Nie udało się otworzyć pliku do odczytu/ zapisu..."); }
    }
    
    public static void Show(String[]lista) {
        String str = String.format("%-15s|%-18s|%-15s|%-25s", "Imię", "Nazwisko", "Numer telefonu", "E-mail");
        for (int i =0;i<73;i++) System.out.print("-");
        System.out.println();
        System.out.println(str);
        for (int i =0;i<73;i++) System.out.print("-");
        System.out.println();
        System.out.printf("%-15s|%-18s|%-15s|%-25s\n", lista[0], lista[1], lista[2], lista[3]);
        for (int i =0;i<73;i++) System.out.print("-");
        System.out.println();
        System.out.printf("Numer certyfikatu: %s \n"
            +"Data końca ważności certyfikatu: %s-%s-%s - %s:%s:%s GMT \n"
            +"Numer karty: %s (%s) \n" 
            + "Numer umowy: %s \n"
            + "Status: %s \n"
            + "Uwagi: %s \n\n", lista[4], lista[5], lista[6], lista[7], lista[8], lista[9], lista[10], lista[11], lista[12], lista[13], lista[14], lista[15]);
    } 
    
    public static void Certyfikat() {
        File file=new File("BazaDanych.txt");
        
        try {
            Scanner kl=new Scanner(file);
            while (kl.hasNextLine()) {
                String text = kl.nextLine();
                String[]lista = null;
                String delimeter = "###";
                lista = text.split(delimeter);
                if (Integer.parseInt(lista[6])<3) {
                    int rok = Integer.parseInt(lista[5]) - 1;
                    int mies = Integer.parseInt(lista[6]) + 10;
                    LocalDate date2 = LocalDate.of(rok, mies, Integer.parseInt(lista[7]));
                    LocalDate date1 = LocalDate.of(Integer.parseInt(lista[5]), Integer.parseInt(lista[6]), Integer.parseInt(lista[7]));
                    if (LocalDate.now().isBefore(date1) && LocalDate.now().isAfter(date2)) {
                        Show(lista);    
                    }
                }
                else {
                    int rok = Integer.parseInt(lista[5]);
                    int mies = Integer.parseInt(lista[6])-2 ;
                    LocalDate date2 = LocalDate.of(rok, mies, Integer.parseInt(lista[7]));
                    LocalDate date1 = LocalDate.of(Integer.parseInt(lista[5]), Integer.parseInt(lista[6]), Integer.parseInt(lista[7]));
                    if (LocalDate.now().isBefore(date1) && LocalDate.now().isAfter(date2)) {
                        Show(lista);
                    }
                } 
            }    
        }
        catch (FileNotFoundException ex) { System.err.println("Nie udało się otworzyć pliku do odczytu/ zapisu..."); }  
    }    
}