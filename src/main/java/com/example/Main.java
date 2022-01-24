package com.example;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class Main {
    public static void main(String[] args) throws IOException {

        
        
        
        /* deserializzazione */

        File file = new File("src/main/resources/classe.xml");
        XmlMapper xmlMapper = new XmlMapper();
        root value = xmlMapper.readValue(file, root.class);
        System.out.println("La classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'aula "
                + value.getAula().getNome() + " ed è composta dai seguenti studenti: ");

        for (int i = 0; i < value.getStudenti().size(); i++) {
            System.out.println("- " + value.getStudenti().get(i).getCognome());

        }

       
       
        /* serializzazione */

        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(new File("src/main/resources/classe_serializzata.xml"), value);
    }
}
