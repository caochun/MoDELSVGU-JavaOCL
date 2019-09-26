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

package jocl.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

import com.vgu.se.jocl.types.AnyType;
import com.vgu.se.jocl.types.BagType;
import com.vgu.se.jocl.types.Class;
import com.vgu.se.jocl.types.IntegerType;
import com.vgu.se.jocl.types.InvalidType;
import com.vgu.se.jocl.types.MessageType;
import com.vgu.se.jocl.types.OrderedSetType;
import com.vgu.se.jocl.types.RealType;
import com.vgu.se.jocl.types.SequenceType;
import com.vgu.se.jocl.types.SetType;
import com.vgu.se.jocl.types.StringType;
import com.vgu.se.jocl.types.TemplateParameterType;
import com.vgu.se.jocl.types.TupleType;
import com.vgu.se.jocl.types.UnlimitedNaturalType;
import com.vgu.se.jocl.types.VoidType;

public class ConformanceTest {

    @Test
    public void test_conforms_to_AnyType() {
        AnyType target = new AnyType();

        AnyType any = new AnyType();
        assertTrue(any.conformsTo(target));

        BagType<Class> bag = new BagType<Class>();
        assertTrue(bag.conformsTo(target));

        Class clazz = new Class();
        assertTrue(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertTrue(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertTrue(message.conformsTo(target));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertTrue(orderedSet.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertTrue(real.conformsTo(target));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertTrue(sequence.conformsTo(target));

        SetType<Class> set = new SetType<Class>();
        assertTrue(set.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertTrue(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertTrue(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertTrue(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertTrue(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void AnyType_conforms_to_test() {
        AnyType target = new AnyType();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        BagType<Class> bag = new BagType<Class>();
        assertFalse(target.conformsTo(bag));

        Class clazz = new Class();
        assertFalse(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSet));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequence));

        SetType<Class> set = new SetType<Class>();
        assertFalse(target.conformsTo(set));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    public void test_conforms_to_BagType() {
        BagType<Class> target = new BagType<Class>();

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        Class clazz = new Class();
        assertFalse(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void BagType_conforms_to_test() {
        BagType<Class> target = new BagType<Class>();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        Class clazz = new Class();
        assertFalse(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    @Test
    public void test_collection_conforms_to_BagType() {
        BagType<IntegerType> target = new BagType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertTrue(bagInteger.conformsTo(target));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertFalse(orderedSetInteger.conformsTo(target));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertFalse(sequenceInteger.conformsTo(target));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertFalse(setInteger.conformsTo(target));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(bagClass.conformsTo(target));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(orderedSetClass.conformsTo(target));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(sequenceClass.conformsTo(target));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(setClass.conformsTo(target));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(bagUnlimitedNatural.conformsTo(target));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(orderedSetUnlimitedNatural.conformsTo(target));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(sequenceUnlimitedNatural.conformsTo(target));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(setUnlimitedNatural.conformsTo(target));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertTrue(bagReal.conformsTo(target));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(orderedSetReal.conformsTo(target));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(sequenceReal.conformsTo(target));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(setReal.conformsTo(target));
    }

    @Test
    public void BagType_conforms_to_test_collection() {
        BagType<IntegerType> target = new BagType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertTrue(target.conformsTo(bagInteger));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertFalse(target.conformsTo(orderedSetInteger));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertFalse(target.conformsTo(sequenceInteger));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertFalse(target.conformsTo(setInteger));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(target.conformsTo(bagClass));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSetClass));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequenceClass));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(target.conformsTo(setClass));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertTrue(target.conformsTo(bagUnlimitedNatural));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(orderedSetUnlimitedNatural));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(sequenceUnlimitedNatural));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(setUnlimitedNatural));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(target.conformsTo(bagReal));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(target.conformsTo(orderedSetReal));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(target.conformsTo(sequenceReal));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(target.conformsTo(setReal));
    }

    @Test
    public void test_conforms_to_OrderedSetType() {
        OrderedSetType<Class> target = new OrderedSetType<Class>();

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        Class clazz = new Class();
        assertFalse(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void OrderedSetType_conforms_to_test() {
        OrderedSetType<Class> target = new OrderedSetType<Class>();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        Class clazz = new Class();
        assertFalse(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    @Test
    public void test_collection_conforms_to_OrderedSetType() {
        OrderedSetType<IntegerType> target = new OrderedSetType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertFalse(bagInteger.conformsTo(target));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertTrue(orderedSetInteger.conformsTo(target));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertFalse(sequenceInteger.conformsTo(target));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertFalse(setInteger.conformsTo(target));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(bagClass.conformsTo(target));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(orderedSetClass.conformsTo(target));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(sequenceClass.conformsTo(target));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(setClass.conformsTo(target));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(bagUnlimitedNatural.conformsTo(target));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(orderedSetUnlimitedNatural.conformsTo(target));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(sequenceUnlimitedNatural.conformsTo(target));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(setUnlimitedNatural.conformsTo(target));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(bagReal.conformsTo(target));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertTrue(orderedSetReal.conformsTo(target));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(sequenceReal.conformsTo(target));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(setReal.conformsTo(target));
    }

    @Test
    public void OrderedSetType_conforms_to_test_collection() {
        OrderedSetType<IntegerType> target = new OrderedSetType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertFalse(target.conformsTo(bagInteger));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertTrue(target.conformsTo(orderedSetInteger));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertFalse(target.conformsTo(sequenceInteger));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertFalse(target.conformsTo(setInteger));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(target.conformsTo(bagClass));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSetClass));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequenceClass));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(target.conformsTo(setClass));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(bagUnlimitedNatural));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertTrue(target.conformsTo(orderedSetUnlimitedNatural));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(sequenceUnlimitedNatural));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(setUnlimitedNatural));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(target.conformsTo(bagReal));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(target.conformsTo(orderedSetReal));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(target.conformsTo(sequenceReal));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(target.conformsTo(setReal));
    }

    @Test
    public void test_conforms_to_SequenceType() {
        SequenceType<Class> target = new SequenceType<Class>();

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        Class clazz = new Class();
        assertFalse(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void SequenceType_conforms_to_test() {
        SequenceType<Class> target = new SequenceType<Class>();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        Class clazz = new Class();
        assertFalse(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    @Test
    public void test_collection_conforms_to_SequenceType() {
        SequenceType<IntegerType> target = new SequenceType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertFalse(bagInteger.conformsTo(target));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertFalse(orderedSetInteger.conformsTo(target));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertTrue(sequenceInteger.conformsTo(target));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertFalse(setInteger.conformsTo(target));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(bagClass.conformsTo(target));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(orderedSetClass.conformsTo(target));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(sequenceClass.conformsTo(target));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(setClass.conformsTo(target));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(bagUnlimitedNatural.conformsTo(target));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(orderedSetUnlimitedNatural.conformsTo(target));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(sequenceUnlimitedNatural.conformsTo(target));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(setUnlimitedNatural.conformsTo(target));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(bagReal.conformsTo(target));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(orderedSetReal.conformsTo(target));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertTrue(sequenceReal.conformsTo(target));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(setReal.conformsTo(target));
    }

    @Test
    public void SequenceType_conforms_to_test_collection() {
        SequenceType<IntegerType> target = new SequenceType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertFalse(target.conformsTo(bagInteger));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertFalse(target.conformsTo(orderedSetInteger));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertTrue(target.conformsTo(sequenceInteger));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertFalse(target.conformsTo(setInteger));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(target.conformsTo(bagClass));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSetClass));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequenceClass));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(target.conformsTo(setClass));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(bagUnlimitedNatural));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(orderedSetUnlimitedNatural));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertTrue(target.conformsTo(sequenceUnlimitedNatural));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(setUnlimitedNatural));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(target.conformsTo(bagReal));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(target.conformsTo(orderedSetReal));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(target.conformsTo(sequenceReal));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(target.conformsTo(setReal));
    }

    @Test
    public void test_conforms_to_SetType() {
        SetType<Class> target = new SetType<Class>();

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        Class clazz = new Class();
        assertFalse(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void SetType_conforms_to_test() {
        SetType<Class> target = new SetType<Class>();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        Class clazz = new Class();
        assertFalse(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    @Test
    public void test_collection_conforms_to_SetType() {
        SetType<IntegerType> target = new SetType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertFalse(bagInteger.conformsTo(target));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertFalse(orderedSetInteger.conformsTo(target));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertFalse(sequenceInteger.conformsTo(target));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertTrue(setInteger.conformsTo(target));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(bagClass.conformsTo(target));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(orderedSetClass.conformsTo(target));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(sequenceClass.conformsTo(target));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(setClass.conformsTo(target));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(bagUnlimitedNatural.conformsTo(target));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(orderedSetUnlimitedNatural.conformsTo(target));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(sequenceUnlimitedNatural.conformsTo(target));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertFalse(setUnlimitedNatural.conformsTo(target));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(bagReal.conformsTo(target));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(orderedSetReal.conformsTo(target));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(sequenceReal.conformsTo(target));

        SetType<RealType> setReal = new SetType<RealType>();
        assertTrue(setReal.conformsTo(target));
    }

    @Test
    public void SetType_conforms_to_test_collection() {
        SetType<IntegerType> target = new SetType<IntegerType>();

        BagType<IntegerType> bagInteger = new BagType<IntegerType>();
        assertFalse(target.conformsTo(bagInteger));

        OrderedSetType<IntegerType> orderedSetInteger = new OrderedSetType<IntegerType>();
        assertFalse(target.conformsTo(orderedSetInteger));

        SequenceType<IntegerType> sequenceInteger = new SequenceType<IntegerType>();
        assertFalse(target.conformsTo(sequenceInteger));

        SetType<IntegerType> setInteger = new SetType<IntegerType>();
        assertTrue(target.conformsTo(setInteger));

        BagType<Class> bagClass = new BagType<Class>();
        assertFalse(target.conformsTo(bagClass));

        OrderedSetType<Class> orderedSetClass = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSetClass));

        SequenceType<Class> sequenceClass = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequenceClass));

        SetType<Class> setClass = new SetType<Class>();
        assertFalse(target.conformsTo(setClass));

        BagType<UnlimitedNaturalType> bagUnlimitedNatural = new BagType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(bagUnlimitedNatural));

        OrderedSetType<UnlimitedNaturalType> orderedSetUnlimitedNatural = new OrderedSetType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(orderedSetUnlimitedNatural));

        SequenceType<UnlimitedNaturalType> sequenceUnlimitedNatural = new SequenceType<UnlimitedNaturalType>();
        assertFalse(target.conformsTo(sequenceUnlimitedNatural));

        SetType<UnlimitedNaturalType> setUnlimitedNatural = new SetType<UnlimitedNaturalType>();
        assertTrue(target.conformsTo(setUnlimitedNatural));

        BagType<RealType> bagReal = new BagType<RealType>();
        assertFalse(target.conformsTo(bagReal));

        OrderedSetType<RealType> orderedSetReal = new OrderedSetType<RealType>();
        assertFalse(target.conformsTo(orderedSetReal));

        SequenceType<RealType> sequenceReal = new SequenceType<RealType>();
        assertFalse(target.conformsTo(sequenceReal));

        SetType<RealType> setReal = new SetType<RealType>();
        assertFalse(target.conformsTo(setReal));
    }

    @Test
    public void test_conforms_to_Class() {
        Class target = new Class();

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        BagType<Class> bag = new BagType<Class>();
        assertFalse(bag.conformsTo(target));

        Class clazz = new Class();
        assertTrue(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertFalse(orderedSet.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertFalse(sequence.conformsTo(target));

        SetType<Class> set = new SetType<Class>();
        assertFalse(set.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void Class_conforms_to_test() {
        Class target = new Class();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        BagType<Class> bag = new BagType<Class>();
        assertFalse(target.conformsTo(bag));

        Class clazz = new Class();
        assertTrue(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSet));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequence));

        SetType<Class> set = new SetType<Class>();
        assertFalse(target.conformsTo(set));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    @Test
    public void test_conforms_to_IntegerType() {
        IntegerType target = new IntegerType(new Integer(1));

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        BagType<Class> bag = new BagType<Class>();
        assertFalse(bag.conformsTo(target));

        Class clazz = new Class();
        assertFalse(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertTrue(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertFalse(orderedSet.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertFalse(sequence.conformsTo(target));

        SetType<Class> set = new SetType<Class>();
        assertFalse(set.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertTrue(voidType.conformsTo(target));
    }

    @Test
    public void IntegerType_conforms_to_test() {
        IntegerType target = new IntegerType(new Integer(1));

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        BagType<Class> bag = new BagType<Class>();
        assertFalse(target.conformsTo(bag));

        Class clazz = new Class();
        assertFalse(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertTrue(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertFalse(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertFalse(target.conformsTo(message));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertFalse(target.conformsTo(orderedSet));

        RealType real = new RealType(new Double(1.0));
        assertFalse(target.conformsTo(real));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertFalse(target.conformsTo(sequence));

        SetType<Class> set = new SetType<Class>();
        assertFalse(target.conformsTo(set));

        StringType string = new StringType(new String("1.0"));
        assertFalse(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertFalse(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }

    @Test
    public void test_conforms_to_InvalidType() {
        InvalidType target = InvalidType.getSoleInstance();

        AnyType any = new AnyType();
        assertFalse(any.conformsTo(target));

        BagType<Class> bag = new BagType<Class>();
        assertFalse(bag.conformsTo(target));

        Class clazz = new Class();
        assertFalse(clazz.conformsTo(target));

        IntegerType integer = new IntegerType(new Integer(1));
        assertFalse(integer.conformsTo(target));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(invalid.conformsTo(target));

        MessageType message = new MessageType();
        assertFalse(message.conformsTo(target));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertFalse(orderedSet.conformsTo(target));

        RealType real = new RealType(new Double(1.0));
        assertFalse(real.conformsTo(target));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertFalse(sequence.conformsTo(target));

        SetType<Class> set = new SetType<Class>();
        assertFalse(set.conformsTo(target));

        StringType string = new StringType(new String("1.0"));
        assertFalse(string.conformsTo(target));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertFalse(templateParameter.conformsTo(target));

        TupleType tuple = new TupleType();
        assertFalse(tuple.conformsTo(target));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertFalse(unlimitedNatural.conformsTo(target));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(voidType.conformsTo(target));
    }

    @Test
    public void InvalidType_conforms_to_test() {
        InvalidType target = InvalidType.getSoleInstance();

        AnyType any = new AnyType();
        assertTrue(target.conformsTo(any));

        BagType<Class> bag = new BagType<Class>();
        assertTrue(target.conformsTo(bag));

        Class clazz = new Class();
        assertTrue(target.conformsTo(clazz));

        IntegerType integer = new IntegerType(new Integer(1));
        assertTrue(target.conformsTo(integer));

        InvalidType invalid = InvalidType.getSoleInstance();
        assertTrue(target.conformsTo(invalid));

        MessageType message = new MessageType();
        assertTrue(target.conformsTo(message));

        OrderedSetType<Class> orderedSet = new OrderedSetType<Class>();
        assertTrue(target.conformsTo(orderedSet));

        RealType real = new RealType(new Double(1.0));
        assertTrue(target.conformsTo(real));

        SequenceType<Class> sequence = new SequenceType<Class>();
        assertTrue(target.conformsTo(sequence));

        SetType<Class> set = new SetType<Class>();
        assertTrue(target.conformsTo(set));

        StringType string = new StringType(new String("1.0"));
        assertTrue(target.conformsTo(string));

        TemplateParameterType templateParameter = new TemplateParameterType();
        assertTrue(target.conformsTo(templateParameter));

        TupleType tuple = new TupleType();
        assertTrue(target.conformsTo(tuple));

        UnlimitedNaturalType unlimitedNatural = new UnlimitedNaturalType(new BigInteger("1"));
        assertTrue(target.conformsTo(unlimitedNatural));

        VoidType voidType = VoidType.getSoleInstance();
        assertFalse(target.conformsTo(voidType));
    }
}
