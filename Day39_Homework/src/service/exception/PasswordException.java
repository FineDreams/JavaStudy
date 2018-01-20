package service.exception;

public class PasswordException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码错误!";
    }
}
