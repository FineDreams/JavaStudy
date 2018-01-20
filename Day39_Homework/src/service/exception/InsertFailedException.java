package service.exception;

public class InsertFailedException extends RegisterException{
    @Override
    public String getMessage() {
        return "注册失败";
    }
}
