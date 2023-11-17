package chap9.exception;

public class PhoneException extends Exception {
    public PhoneException() {
        super("电话号码格式错误");
    }
}
