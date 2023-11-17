package chap9.exception;

public class NameException extends Exception {
    public NameException() {
        super("姓名为空");
    }

}