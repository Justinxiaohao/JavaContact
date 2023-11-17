package chap9.exception;

public class EmailException extends Exception {
    public EmailException() {
        super("电子邮箱格式错误");
    }
}
