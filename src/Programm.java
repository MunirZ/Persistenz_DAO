import Kaufvertrag.Datenbank;
import Commands.exception.BefehlUnbekanntException;

import java.io.IOException;

public class Programm {
    public static void main(String[] args) throws IOException, BefehlUnbekanntException {
        new Datenbank().starten();
    }
}
