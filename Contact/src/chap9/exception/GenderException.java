package chap9.exception;

public class GenderException extends Exception{
    public GenderException() {
        super("性别格式错误");
    }
}