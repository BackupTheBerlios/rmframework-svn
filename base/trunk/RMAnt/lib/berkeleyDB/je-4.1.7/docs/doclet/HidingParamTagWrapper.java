/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle. All rights reserved.
 *
 */

import java.util.Map;

import com.sun.javadoc.ParamTag;

class HidingParamTagWrapper extends HidingTagWrapper implements ParamTag {
    public HidingParamTagWrapper(ParamTag paramtag, Map mapWrappers) {
        super(paramtag, mapWrappers);
    }

    private ParamTag _getParamTag() {
        return (ParamTag)getWrappedObject();
    }

    public String parameterComment() {
        return _getParamTag().parameterComment();
    }

    public String parameterName() {
        return _getParamTag().parameterName();
    }

    public boolean isTypeParameter() {
        return _getParamTag().isTypeParameter();
    }
}
