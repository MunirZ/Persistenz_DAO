package Commands;

import Commands.exception.BefehlUnbekanntException;

public class CommandFactory {
    public static ICommand createCommand(String eingabe) throws BefehlUnbekanntException {
        String[] args = eingabe.trim().split(" ");
        if (args.length == 0) {
            throw new BefehlUnbekanntException();
        }
        for (int i = 0; i < 1; i++) {
            args[i] = args[i].toLowerCase();
        }
        switch (args[0]) {
            case "help":
                return createCommandHelp();
            case "quit":
                return createCommandQuit();
            case "read":
                if (args[2].equals("all")) {
                    return createCommandRead(args[1]);
                } else {
                    return createCommandReadID(args[1] , args[2]);
                }
            case "create":
                if (args[1].equals("partner")) {
                    return createCommandCreateVertragspartner();
                } else if (args[1].equals("ware")) {
                    return createCommandCreateWare();
                } else {
                    throw new BefehlUnbekanntException();
                }
            case "delete":
                if (args[1].equals("partner")) {
                    return new CommandDeleteVertragspartner(Integer.parseInt(args[2]));
                } else if (args[1].equals("ware")) {
                    return new CommandDeleteWare(Integer.parseInt(args[2]));
                } else {
                    throw new BefehlUnbekanntException();
                }
            case "update":
                if (args[1].equals("partner")) {
                    return new CommandUpdateVertragspartner(Integer.parseInt(args[2]));
                } else if (args[1].equals("ware")) {
                    return new CommandUpdateWare(Integer.parseInt(args[2]));
                } else {
                    throw new BefehlUnbekanntException();
                }
            default:
                throw new BefehlUnbekanntException();
        }
    }

    public static ICommand createCommandReadID(String bezeichnung, String id) throws BefehlUnbekanntException {
        if (bezeichnung.equals("ware")) {
            return new CommandReadIDWare(Integer.parseInt(id));
        } else if (bezeichnung.equals("partner")) {
            return new CommandReadIDVertragspartner(Integer.parseInt(id));
        }
        throw new BefehlUnbekanntException();
    }

    public static ICommand createCommandRead(String bezeichnung) throws BefehlUnbekanntException {
        if (bezeichnung.equals("ware")) {
            return new CommandReadWare();
        } else if (bezeichnung.equals("partner")) {
            return new CommandReadVertragspartner();
        }
        throw new BefehlUnbekanntException();
    }

    public static ICommand createCommandCreateVertragspartner() { return new CommandCreateVertragspartner(); }

    public static ICommand createCommandCreateWare() { return new CommandCreateWare(); }

    public static ICommand createCommandHelp() { return new CommandHelp(); }

    public static ICommand createCommandQuit() { return new CommandQuit(); }
}
