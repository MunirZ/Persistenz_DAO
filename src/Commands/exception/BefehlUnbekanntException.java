package Commands.exception;

public class BefehlUnbekanntException extends Exception{

    @Override
    public String getMessage() {
        return "Die Befehlseingabe ist fehlerhaft!\nGeben sie einen gültigen Befehl ein.";
    }
}
