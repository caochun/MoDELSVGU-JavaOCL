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


package com.vgu.se.jocl.expressions;

import com.vgu.se.jocl.visit.ParserVisitor;

// Look at Predefiend Iterateor Expression 11.7, OCL 2.4
public class IteratorExp extends LoopExp {
    
    private String kind;

    public IteratorExp(OclExp source, String kind, Variable iterator, OclExp body) {
        super.source = source;
        super.iterator = iterator;
        super.body = body;
        this.kind = kind;
    }

    public OclExp getSource() {
        return super.source;
    }

    public String getKind() {
        return this.kind;
    }

    public OclExp getBody() {
        return super.body;
    }

    public Variable getIterator() {
        return super.iterator;
    }

    @Override
    public void accept(ParserVisitor parserVisitor) {
        parserVisitor.visit(this);
    }


}
