class Main {

    public static void main(String[] args) throws Exception {

        Methods methods = new Methods();

        String flag = methods.parseCommand(args);

        methods.toRead(flag, methods.names);

        if (flag.equals("-u")) {
            methods.toWrite(methods.contents);
        } else {
            methods.toWrite(methods.contents, methods.sizes, methods.names.get(methods.names.size() - 1));
        }
    }
}