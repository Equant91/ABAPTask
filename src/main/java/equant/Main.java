package equant;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Main {


    public static void main(String[] args) {
        ValCurs valCurs = new ValCurs();
        double min = 100000;
        double max = 0;
        int idMin = 0;
        int idMax = 0;

        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            URLConnection urlConnection = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "windows-1251"));
            String strLine;
            StringBuilder sb = new StringBuilder();
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine);
            }
            String xml = sb.toString();
            XmlMapper xmlMapper = new XmlMapper();
            valCurs = xmlMapper.readValue(xml, ValCurs.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < valCurs.getValCurs().size(); x++) {


            String d = valCurs.getValCurs().get(x).getValue().replace(',', '.');
            double value = Double.valueOf(d);
            if (valCurs.getValCurs().get(x).getNominal() != 1) {
                value = value / valCurs.getValCurs().get(x).getNominal();
            }
            if (value < min) {
                min = value;
                idMin = x;
            }
            if (value > max) {
                max = value;
                idMax = x;
            }
        }
        System.out.println("Max value: " + valCurs.getValCurs().get(idMax).toString());
        System.out.println("Min value: " + valCurs.getValCurs().get(idMin).toString());

    }

}