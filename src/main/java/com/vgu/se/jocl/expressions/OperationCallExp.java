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

import java.util.Arrays;
import java.util.List;

import com.vgu.se.jocl.visit.ParserVisitor;

public class OperationCallExp extends FeatureCallExp {

    private List<OclExp> arguments;
    private Operation referredOperation;

    public OperationCallExp(OclExp source, Operation referredOperation, 
            OclExp... arguments) {
        super.source = source;
        this.referredOperation = referredOperation;
        this.arguments = Arrays.asList(arguments);
    }

    public List<OclExp> getArguments() {
        return arguments;
    }

    public OclExp getSource () {
        return super.source;
    }

    public Operation getReferredOperation() {
        return referredOperation;
    }
    
    @Override
    public void accept(ParserVisitor parserVisitor) {
        parserVisitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "referredOperation : " + this.referredOperation.getName()
                + "\n" 
                + "type : " + super.getType() + "\n" 
                + "source : " + super.source + "\n" 
                + "arguments : " + this.arguments + "\n";
    }

}
