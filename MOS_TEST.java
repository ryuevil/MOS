package MOS;

import javax.swing.*;
import java.lang.*;

public class Mos_Test
{
    public void main()
    {
        String nama = null;
        String nomatrix = null;
        
        nama = JOptionPane.showInputDialog ("Nama Anda?");
        nomatrix = JOptionPane.showInputDialog ("Umur?");
        
        int pilih;
        pilih = choice();
      
        while (pilih <= 0 || pilih >= 0)
        {
            if (pilih == 1)
            {
                Mos_Word baru = new Mos_Word();
                baru.startword();
                pilih = choice();
            }
          
            else if (pilih == 2)
            {
                Mos_Excel baru = new Mos_Excel();
                baru.startexcel();
                pilih = choice();
            }
          
            else if (pilih == 0)
            {
                JOptionPane.showMessageDialog(null, "Terima Kasih");
                System.exit(0);
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Maaf, pilihan anda tiada dalam Menu..\n Sila cuba lagi");
                pilih = choice();
            }
        }
    }
    
    public static int choice()
    {
        int pilihan;
        pilihan = Integer.parseInt (JOptionPane.showInputDialog ("Selamat Datang" + "\n Latihan Set Soalan MOS" +"\n1 - MOS WORD" + "\n2 - MOS EXCEL" + "\n0 - Keluar"));
        return pilihan;
    }
}
        