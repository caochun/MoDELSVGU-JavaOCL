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

// Look at Predefiend Iterateor Expression 11.7, OCL 2.4
public class IteratorExp extends LoopExp {
    
    private OclExp source;
    private String kind;
    private OclExp body;

    public IteratorExp(OclExp source, String kind, OclExp body) {
        this.source = source;
        this.kind = kind;
        this.body = body;
    }

    public OclExp getSource() {
        return source;
    }

    public String getKind() {
        return kind;
    }

    public OclExp getBody() {
        return body;
    }


}
