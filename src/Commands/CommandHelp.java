package Commands;

public class CommandHelp implements ICommand{
    @Override
    public void execute() {
        printHelp();
    }

    private static void printHelp() {
        System.out.println("\nFolgende Befehle sind vorhandnen:\n" +
                "read   <Objektbezeichnung> <id>    - Lese einen Eintrag aus der Datenbank\n" +
                "read   <Objektbezeichnung> all     - Lese alle Einträge der Datenbank\n" +
                "create <Objektbezeichnung>         - Erstellt ein Objekt\n" +
                "delete <Objektbezeichnung> <id>    - Löscht das Objekt mit der angegebenen id\n" +
                "update <Objektbezeichnung> <id>    - Eintrag wird überarbeitet\n" +
                "Objektbezeichnungen: (ware / partner)");
    }
}

