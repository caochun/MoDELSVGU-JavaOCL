/**************************************************************************
Copyright 2019 Vietnamese-German-University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author: thian
***************************************************************************/


package com.vgu.se.jocl.main.TOBERMV;

import org.json.simple.JSONArray;

import com.vgu.se.jocl.expressions.OclExp;
import com.vgu.se.jocl.parser.interfaces.Parser;
import com.vgu.se.jocl.parser.simple.SimpleParser;

public class Jocl {

    private Parser ocl2PojoParser;
    private boolean hasComment;
    private String adhocCtx;

    public Jocl() {
        this.ocl2PojoParser = new SimpleParser();
        this.hasComment = false;
    }

    public Parser getParser() {
        return this.ocl2PojoParser;
    }

    public boolean isHasComment() {
        return this.hasComment;
    }
    
    public void setContext(String adhocCtx) {
        this.adhocCtx = adhocCtx;
        ocl2PojoParser.setAdhocCtx(adhocCtx);
    }
    
    public String getContext() {
        return this.adhocCtx;
    }
    
    public String mapOcl2SqlString(String ocl, JSONArray ctx) {
        OclExp oclExp = ocl2PojoParser.parse(ocl, ctx);
//        oclExp.accept(pojo2PsqlParser);
        
//        return pojo2PsqlParser.getSqlString();
        return "";
    }

}
