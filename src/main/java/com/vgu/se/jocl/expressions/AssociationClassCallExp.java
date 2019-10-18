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

@author: ngpbh
***************************************************************************/

package com.vgu.se.jocl.expressions;

import java.util.List;

import com.vgu.se.jocl.types.Class;
import com.vgu.se.jocl.types.Type;
import com.vgu.se.jocl.utils.UMLContextUtils;
import com.vgu.se.jocl.visit.ParserVisitor;;

public class AssociationClassCallExp extends NavigationCallExp {

    private String referredAssociationEnd;
    private Class referredAssociationClass;
    private String oppositeAssociationEnd;
    private Type oppositeAssociationEndType;
    private String association;

    public AssociationClassCallExp(OclExp source,
            String referredAssociationEnd) {
        super.navigationSource = source;
        this.referredAssociationEnd = referredAssociationEnd;
    }

    public Type getOppositeAssociationEndType() {
        return oppositeAssociationEndType;
    }

    public void setOppositeAssociationEndType(
            Type oppositeAssociationEndType) {
        this.oppositeAssociationEndType = oppositeAssociationEndType;
    }

    public String getAssociationEnd() {
        return referredAssociationEnd;
    }

    public Class getReferredAssociationClass() {
        return referredAssociationClass;
    }

    public String getReferredAssociationEnd() {
        return referredAssociationEnd;
    }

    public void setReferredAssociationEnd(
            String referredAssociationEnd) {
        this.referredAssociationEnd = referredAssociationEnd;
    }

    public String getOppositeAssociationEnd() {
        return oppositeAssociationEnd;
    }

    public void setOppositeAssociationEnd(
            String oppositeAssociationEnd) {
        this.oppositeAssociationEnd = oppositeAssociationEnd;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public void setReferredAssociationClass(
            Class referredAssociationClass) {
        this.referredAssociationClass = referredAssociationClass;
    }

    @Override
    public void accept(ParserVisitor parserVisitor) {
        parserVisitor.visit(this);
    }
}
