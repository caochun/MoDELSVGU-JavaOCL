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

@author: thian, ngpbh
***************************************************************************/


package com.vgu.se.jocl.expressions;

import java.util.List;

public class NavigationCallExp extends FeatureCallExp {

    private List<OclExp> qualifiers;
//    protected Property navSource;
    protected Variable variable;

    public NavigationCallExp(List<OclExp> qualifiers) {
        this.qualifiers = qualifiers;
    }

    public NavigationCallExp(Variable variable) {
        this.variable = variable;
    }
    
    public List<OclExp> getQualifiers() {
        return qualifiers;
    }
    
}
