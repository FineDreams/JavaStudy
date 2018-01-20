package service.exception;

public class UserNotException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户不存在";
    }
}
