import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Automat
{
    private static  int pieczl=0;
    private static  int dwazl=0;
    private static  int jedenzl=0;
    private static  int piecdziesiatgr=0;
    private static  int dwadziesciagr=0;
    private static  int dziesiecgr=0;
    private static  int wplata=0;
    private static int wplata_gr=0;
    private static  int za_ile=0;
    private static  int za_ile_gr = 0;
    private static  int reszta=0;
    private static List<String> wyplacone_monety= new ArrayList<String>();
    private static List<Float> wplacane_monety = new ArrayList<Float>();


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);;
        java.text.DecimalFormat df=new java.text.DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        System.out.println("Ilosc 5zl");
        pieczl = scanner.nextInt();
        System.out.println("Ilosc 2zl");
        dwazl = scanner.nextInt();
        System.out.println("Ilosc 1zl");
        jedenzl = scanner.nextInt();

        System.out.println("Ilosc 50gr");
        piecdziesiatgr = scanner.nextInt();
        System.out.println("Ilosc 20gr");
        dwadziesciagr = scanner.nextInt();
        System.out.println("Ilosc 10gr");
        dziesiecgr = scanner.nextInt();

        int ile_monet;
        while(za_ile != 99)
        {
            wplacane_monety.clear();
            System.out.println("Ile kosztuje produkt (zl gr)");
            za_ile = scanner.nextInt();
            za_ile_gr = scanner.nextInt();
            za_ile = za_ile * 100 + za_ile_gr;

            System.out.println("Ile wplaca (zl gr)");
            wplata = scanner.nextInt();
            wplata_gr = scanner.nextInt();

            wplata = wplata * 100 +wplata_gr;
            reszta = wplata - za_ile;

            if(reszta<0)
                System.out.println("Wplacono za malo pieniedzy");
            else
            {
                wyplacone_monety.clear();
                System.out.println(df.format((float)reszta/100) +  " zl reszty, w następujących monetach:");
                dodaj_do_automatu();
                wydaj_reszte();
                for(int i=0; i<wyplacone_monety.size();i++)
                    System.out.print(wyplacone_monety.get(i) + " ");


                System.out.println("\n5zl: " + pieczl + "\n2zl: " +  dwazl + "\n1zl: "  + jedenzl + "\n50gr: " +piecdziesiatgr + "\n20gr: " + dwadziesciagr + "\n10gr: " + dziesiecgr);
            }


        }
        System.out.println("Zakonczono program");
    }



    public static void wydaj_reszte()
    {
        while (reszta > 0)
        {

            if (reszta >= 500)
            {
                if (pieczl > 0)
                {
                    pieczl--;
                    reszta = reszta - 500;
                    wyplacone_monety.add("5 zl");
                }
                else {
                    if (dwazl > 0) {
                        dwazl--;
                        reszta = reszta-200;
                        wyplacone_monety.add("2 zl");
                    } else {
                        if (jedenzl > 0) {
                            jedenzl--;
                            reszta = reszta-100;
                            wyplacone_monety.add("1 zl");
                        } else {
                            if (piecdziesiatgr > 0) {
                                piecdziesiatgr--;
                                reszta = reszta-50;
                                wyplacone_monety.add("50 gr");
                            } else {
                                if (dwadziesciagr > 0) {
                                    dwadziesciagr--;
                                    reszta = reszta -20;
                                    wyplacone_monety.add("20 gr");
                                } else {
                                    if (dziesiecgr > 0) {
                                        dziesiecgr++;
                                        reszta = reszta - 10;
                                        wyplacone_monety.add("10 gr");
                                    }
                                }
                            }
                        }
                    }


                }

            }

            if (reszta < 500 && reszta >= 200) {
                if (dwazl > 0) {
                    dwazl--;
                    reszta = reszta - 200;
                    wyplacone_monety.add("2 zl");
                } else {
                    if (jedenzl > 0) {
                        jedenzl--;
                        reszta = reszta - 100;
                        wyplacone_monety.add("1 zl");
                    } else {
                        if (piecdziesiatgr > 0) {
                            piecdziesiatgr--;
                            reszta = reszta-50;
                            wyplacone_monety.add("50 gr");
                        } else {
                            if (dwadziesciagr > 0) {
                                dwadziesciagr--;
                                reszta = reszta-20;
                                wyplacone_monety.add("20 gr");
                            } else {
                                if (dziesiecgr > 0) {
                                    dziesiecgr++;
                                    reszta = reszta-10;
                                    wyplacone_monety.add("10 gr");
                                }
                            }
                        }
                    }
                }

            }

            if (reszta < 200 && reszta >= 100) {
                if (jedenzl > 0) {
                    jedenzl--;
                    reszta = reszta - 100;
                    wyplacone_monety.add("1 zl");
                } else {
                    if (piecdziesiatgr > 0) {
                        piecdziesiatgr--;
                        reszta = reszta-50;
                        wyplacone_monety.add("50 gr");
                    } else
                    {
                        if (dwadziesciagr > 0) {
                            dwadziesciagr--;
                            reszta = reszta-20;
                            wyplacone_monety.add("20 gr");
                        } else {
                            if (dziesiecgr > 0) {
                                dziesiecgr++;
                                reszta = reszta-10;
                                wyplacone_monety.add("10 gr");
                            }
                        }
                    }
                }
            }

            if(reszta<100 && reszta>=50) {


                if(piecdziesiatgr>0)
                {
                    piecdziesiatgr--;
                    reszta = reszta - 50;
                    wyplacone_monety.add("50 gr");
                }
                else
                {
                    if (dwadziesciagr > 0) {
                        dwadziesciagr--;
                        reszta = reszta-20;
                        wyplacone_monety.add("20 gr");
                    } else {
                        if (dziesiecgr > 0) {
                            dziesiecgr++;
                            reszta = reszta-10;
                            wyplacone_monety.add("10 gr");
                        }
                    }
                }
            }

            if(reszta<50 && reszta>=20)
            {
                if(dwadziesciagr>0)
                {
                    reszta=reszta-20;
                    dwadziesciagr--;
                    wyplacone_monety.add("20 gr");
                }
                else
                if(dziesiecgr>0)
                {
                    reszta=reszta-10;
                    dziesiecgr--;
                    wyplacone_monety.add("10 gr");
                }
                else
                {
                    System.out.println("Nie wydamy Ci wiecej reszty");
                }
            }

            if(reszta<20 && reszta >=10 && dziesiecgr>0)
            {
                dziesiecgr--;
                reszta=reszta-10;
                wyplacone_monety.add("10 gr");

            }
            else
                if(dziesiecgr<0)
            {
                System.out.println("Nie wydamy Ci wiecej reszty");
                break;
            }
        }
    }


//    public static void wydaj_reszte()
//    {
//        while (reszta > 0)
//        {
//
//            if (reszta >= 500)
//            {
//                if (pieczl > 0)
//                {
//                    pieczl--;
//                    reszta = reszta - 500;
//                    wyplacone_monety.add("5 zl");
//                }
//                else if (dwazl > 0) {
//                    dwazl--;
//                    reszta = reszta - 200;
//                    wyplacone_monety.add("2 zl");
//                }
//                else if(jedenzl>0)
//                {
//
//                    jedenzl--;
//                    reszta=reszta-100;
//                    wyplacone_monety.add("1 zl");
//                }
//                else if(dziesiecgr>0)
//                {
//                    dziesiecgr--;
//                    reszta=reszta-10;
//                    wyplacone_monety.add("10 gr");
//                }
//
//
//            }
//
//            if (reszta < 500 && reszta >= 200) {
//                if (dwazl > 0) {
//                    dwazl--;
//                    reszta = reszta - 200;
//                    wyplacone_monety.add("2 zl");
//                }
//                else if(jedenzl>0)
//                {
//
//                    jedenzl--;
//                    reszta=reszta-100;
//                    wyplacone_monety.add("1 zl");
//                }
//                else if(dziesiecgr>0)
//                {
//                    dziesiecgr--;
//                    reszta=reszta-10;
//                    wyplacone_monety.add("10 gr");
//                }
//
//            }
//
//            if (reszta < 200 && reszta >= 100) {
//                if(jedenzl>0)
//                {
//                    jedenzl--;
//                    reszta=reszta-100;
//                    wyplacone_monety.add("1 zl");
//                }
//                else if(dziesiecgr>0)
//                {
//                    dziesiecgr--;
//                    reszta=reszta-10;
//                    wyplacone_monety.add("10 gr");
//                }
//            }
//
//            if(reszta<100 && reszta >=10)
//            {
//                if(dziesiecgr>0)
//                {
//                    dziesiecgr--;
//                    reszta=reszta-10;
//                    wyplacone_monety.add("10gr");
//                }
//                else
//                {
//                    System.out.println("Brak monet do wypłacenia");
//                }
//            }
//        }
//    }

    public static void dodaj_do_automatu()
    {
        while(wplata>0)
        {
            if(wplata>=500)
            {
                pieczl++;
                wplata=wplata-500;
            }

            if(wplata<500 && wplata>=200)
            {
                dwazl++;
                wplata=wplata-200;
            }
            if(wplata<200 && wplata >=100)
            {
                jedenzl++;
                wplata=wplata-100;
            }
            if(wplata<100 && wplata>=50)
            {
                piecdziesiatgr++;
                wplata = wplata - 50;
            }
            if(wplata<50 && wplata >=20)
            {
                dwadziesciagr++;
                wplata = wplata - 20;
            }
            if(wplata<20 && wplata >=10)
            {
                dziesiecgr++;
                wplata=wplata-10;
            }
        }
    }
}