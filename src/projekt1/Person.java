
package projekt1;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Person {
    public String name;
    public String nazwisko;
    public String rok;
    public String mies;
    public String dz;
    public String godzina;
    public String min;
    public String sek;
    public String nrumowy;
    public String nrkarty;
    public String rodkarty;
    public String nrcertyfikatu;
    public String status;
    public String nrtelefonu;
    public String mail;
    public String uwagi;
    
    public Person() {
        
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getNazwisko() {
        return this.nazwisko;
    }
    
    public String getNrUmowy() {
        return this.nrumowy;
    }
    
    public String getNrKarty() {
        return this.nrkarty;
    }
    
    public String getRodKarty() {
        return this.rodkarty;
    }
    public void setRodKarty() {
        System.out.println("Podaj rodzaj karty:\n"
                + "1- debetowa\n"
                + "2- kredytowa\n"
                + "3- obciążeniowa\n"
                + "4- wirtualna\n"
                + "5- inna\n");
        Scanner kl = new Scanner(System.in);
        boolean OK;
        int c=0;
        do {
            try {   
                OK=true; 
                c=kl.nextInt();
                }
            catch (InputMismatchException ex) {OK=false;kl.nextLine();}
            }
        while (!OK); 
        switch (c) {
            case 1 : this.rodkarty = "debetowa";
            break;
            case 2 : this.rodkarty = "kredytowa";
            break;
            case 3 : this.rodkarty = "obciążeniowa";
            break;
            case 4 : this.rodkarty = "wirtualna";
            break;
            case 5 : {System.out.println("Podaj inny rodzaj karty:"); this.rodkarty = kl.next();}
            break;
        } 
    }
    
    public String getNrCertyfikatu() {
        return this.nrcertyfikatu;
    }
    
    public String getRok(){
        return this.rok;
    }
    
    public String getMies() {
        return this.mies;
    }
    
    public String getDz() {
        return this.dz;
    }
    
    public String getGod() {
        return this.godzina;
    }
    
    public String getMin() {
        return this.min;
    }
    
    public String getSek() {
        return this.sek;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus() {
        System.out.println("Podaj status:\n"
                + "1 - nowy\n"
                + "2 - proforma wysłana\n"
                + "3 - zapłacone\n"
                + "4 - wygasł\n"
                + "5 - inny\n");
        Scanner kl = new Scanner(System.in);
        boolean OK;
        int c=0;
        do {
            try {   
                OK=true; 
                c=kl.nextInt();
                }
            catch (InputMismatchException ex) {OK=false;kl.nextLine();}
            }
        while (!OK); 
        switch (c) {
            case 1 : this.status = "nowy";
            break;
            case 2 : this.status = "proforma wysłana";
            break;
            case 3 : this.status = "zapłacone";
            break;
            case 4 : this.status = "wygasł";
            break;
            case 5 : {System.out.println("Podaj inny status:"); kl.nextLine();this.status = kl.nextLine();}
            break;
        } 
    }
    
    public String getNrTelefonu() {
        return this.nrtelefonu;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public String getUwagi() {
        return this.uwagi;
    }
    
    public void setUwagi() {
        Scanner kl = new Scanner(System.in);
        
        String uwaga;
        String text="";
        boolean OK;
        do {
            System.out.println("Podaj uwagi (do 1000 znaków)");
            OK = true;
            uwaga = kl.nextLine();
            
            if (uwaga.length()>1000) {
                System.out.println("Przekroczono limit znaków!");
                System.out.println("1 - Zapisać pierwsze 1000 znaków\n"
                       + "2 - Ponownie podać uwagi");
                int c=0;
                boolean OK1;
                do {
                    try {   
                        OK1=true; 
                        c=kl.nextInt();
                        }
                    catch (InputMismatchException ex) {OK1=false; kl.nextLine();}
                }
                while (!OK1); 
                switch (c) {
                    case 1 : {
                        for (int i=0; i<1000; i++) text += uwaga.charAt(i);
                        this.uwagi = text;
                    }
                    break;
                    case 2 : {OK = false; kl.nextLine();}
                    break;
                }
            }  
            else {this.uwagi = uwaga; OK=true;}
        }
        while (!OK);
    }
    
}

