package service.exception;

public class InsertSuccess extends RegisterException {
    @Override
    public String getMessage() {
        return "注册成功";
    }
}
