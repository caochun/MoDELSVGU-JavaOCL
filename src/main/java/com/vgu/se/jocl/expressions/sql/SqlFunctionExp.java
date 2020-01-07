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


package com.vgu.se.jocl.expressions.sql;

import java.util.List;

import com.vgu.se.jocl.visit.ParserVisitor;

public class SqlFunctionExp extends SqlExp {

    private int paramCount;
    private List<SqlParameter> params;
    
    public SqlFunctionExp(String name) {
        super(name);
        setParamCount(0);
    }
    
    public SqlFunctionExp(String name, List<SqlParameter> params) {
        super(name);
        setParamCount(params.size());
        params = this.params;
    }

    public int getParamCount() {
        return paramCount;
    }

    public void setParamCount(int paramCount) {
        this.paramCount = paramCount;
    }
    
    @Override
    public void accept(ParserVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "SqlFunctionExp [name =" + super.getName() + "]";
    }
}
