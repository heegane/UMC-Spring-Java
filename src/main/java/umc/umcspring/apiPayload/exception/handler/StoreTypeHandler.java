package umc.umcspring.apiPayload.exception.handler;

import umc.umcspring.apiPayload.code.BaseErrorCode;
import umc.umcspring.apiPayload.exception.GeneralException;

public class StoreTypeHandler extends GeneralException {
    public StoreTypeHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
