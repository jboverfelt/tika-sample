package io.jboverfelt.tika.example;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class TikaTest {
    public static void main(String[] args) throws TikaException, SAXException, IOException {
        System.out.println(parseResumeToString());
    }

    public static String parseResumeToString() throws IOException, SAXException, TikaException {
        Tika tika = new Tika();
        // Tika requires an input stream to parse data in this manner
        // if the file isn't on the classpath (here I have it in src/main/resources)
        // then you'll have to get the input stream using a different method
        try (InputStream stream = TikaTest.class.getResourceAsStream("/resume_sample.pdf")) {
            return tika.parseToString(stream);
        }
    }
}

