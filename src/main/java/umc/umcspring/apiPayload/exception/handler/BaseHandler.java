package umc.umcspring.apiPayload.exception.handler;

import umc.umcspring.apiPayload.code.BaseErrorCode;
import umc.umcspring.apiPayload.exception.GeneralException;

public class BaseHandler extends GeneralException {
    public BaseHandler (BaseErrorCode errorCode) {
        super(errorCode);
    }
}
