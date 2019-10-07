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

package com.vgu.se.jocl.parser.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.vgu.se.jocl.env.Environment;
import com.vgu.se.jocl.exception.OclParserException;
import com.vgu.se.jocl.expressions.BooleanLiteralExp;
import com.vgu.se.jocl.expressions.IntegerLiteralExp;
import com.vgu.se.jocl.expressions.IteratorExp;
import com.vgu.se.jocl.expressions.IteratorKind;
import com.vgu.se.jocl.expressions.LiteralExp;
import com.vgu.se.jocl.expressions.NullLiteralExp;
import com.vgu.se.jocl.expressions.OclExp;
import com.vgu.se.jocl.expressions.Operation;
import com.vgu.se.jocl.expressions.OperationCallExp;
import com.vgu.se.jocl.expressions.PropertyCallExp;
import com.vgu.se.jocl.expressions.RealLiteralExp;
import com.vgu.se.jocl.expressions.StringLiteralExp;
import com.vgu.se.jocl.expressions.TypeExp;
import com.vgu.se.jocl.expressions.Variable;
import com.vgu.se.jocl.expressions.VariableExp;
import com.vgu.se.jocl.parser.interfaces.Parser;
import com.vgu.se.jocl.utils.UMLContextUtils;

public class SimpleParser implements Parser {

    private List<String> stringArray = new ArrayList<String>();
    private List<String> parenthesisArray = new ArrayList<String>();

    /**
     * This parse an OCL Expression string to OclExp Java Object given a
     * 
     * UML Context file.
     * 
     * @param ctx
     * @param oclExpStr
     * @return OclExp
     */
    @Override
    public OclExp parse(String ocl, JSONArray ctx) {

        String encOcl = encode(ocl);

        System.out.println("Original : " + ocl + "\nEncoded : " + encOcl
                + "\nStringArray : " + this.stringArray
                + "\nParenthesisArray : " + this.parenthesisArray);

        Stack<String> variableStack = new Stack<String>();

        return parseOclExp(encOcl, ctx, variableStack);
    }

    private String encode(String ocl) {

        String encOcl = String.copyValueOf(ocl.toCharArray());
        encOcl = extractString(encOcl);
        encOcl = extractParenthesis(encOcl);

        return encOcl;
    }

    private String extractString(String encOcl) {

        Pattern pattern = Pattern
                .compile(ParserPatterns.STRING_LITERAL_STR);
        Matcher m = pattern.matcher(encOcl);
        String openBracket = "{";
        String closeBracket = "}";
        int level = 0;

        while (m.find()) {
            String content = m.group(1);
            content = content.replaceAll("^'|'$", "");
            this.stringArray.add(trim(content));
            encOcl = m.replaceFirst(openBracket + level + closeBracket);
            m = pattern.matcher(encOcl);
            level++;
        }

        return encOcl;
    }

    private String extractParenthesis(String encOcl) {

        Pattern pattern = Pattern
                .compile(ParserPatterns.PARENTHESIS_LITERAL_STR);
        Matcher m = pattern.matcher(encOcl);
        String openBracket = "[";
        String closeBracket = "]";
        int level = 0;

        while (m.find()) {
            String content = m.group(1);
            content = content.replaceAll("^\\(|\\)$", "");

            // **********************************************
            // in case of `... operation (a+b)...` being parsed to
            // `... operation [1] ...`
            content = content.replaceAll("\\[", "(");
            content = content.replaceAll("\\]", ")");
            // **********************************************

            this.parenthesisArray.add(trim(content));
            encOcl = m.replaceFirst(openBracket + level + closeBracket);
            m = pattern.matcher(encOcl);
            level++;
        }

        encOcl = encOcl.replaceAll("\\[", "(");
        encOcl = encOcl.replaceAll("\\]", ")");

        return encOcl;
    }

    private OclExp parseOclExp(String ocl, JSONArray ctx,
            Stack<String> variableStack) {

        OclExp oclExp = parseCallExp(ocl, ctx, variableStack);

        if (oclExp != null) {
            return oclExp;
        }

        return parseLiteralExp(ocl, ctx, variableStack);
    }

    private OclExp parseCallExp(String ocl, JSONArray ctx,
            Stack<String> variableStack) {

//        Implementing the operators patterns from lowest precedence
        Pattern[] patterns = { ParserPatterns.IMPLIES_OP_PATT,
                ParserPatterns.XOR_OP_PATT, ParserPatterns.OR_OP_PATT,
                ParserPatterns.AND_OP_PATT,
                ParserPatterns.EQUALITY_OP_PATT,
                ParserPatterns.COMPARISON_OP_PATT,
//                ParserPatterns.ADD_OR_SUBTRACT_OP_PATT,
//                ParserPatterns.MULTIPLY_OR_DIV_OP_PATT,
//                ParserPatterns.NOT_OR_NEGATIVE_OP_PATT,
                ParserPatterns.NOT_OP_PATT };

        Matcher m;
        for (Pattern p : patterns) {
            m = p.matcher(ocl);
            if (m.find()) {
                return parseOperationCallExp(m, ocl, ctx,
                        variableStack);
            }
        }

//        Check the DOT or ARROW pattern
        m = ParserPatterns.DOT_OR_ARROW_OP_PATT.matcher(ocl);
        if (m.find()) {
            return parseCallExp(m, ocl, ctx, variableStack);
        }

        return null;
    }

    private OclExp parseOperationCallExp(Matcher m, String ocl,
            JSONArray ctx, Stack<String> variableStack) {

        String source = trim(m.group(1));
        String operator = trim(m.group(2));
        String body = trim(m.group(3));

        return new OperationCallExp(
                parseOclExp(source, ctx, variableStack),
                new Operation(operator),
                parseOclExp(body, ctx, variableStack));
    }

    private OclExp parseCallExp(Matcher m, String ocl, JSONArray ctx,
            Stack<String> variableStack) {

        String operator = m.group(2);

        switch (operator) {
        case ".":
            return parseDotCase(m, ocl, ctx, variableStack);
        default: // "->"
            return parseArrowCase(m, ocl, ctx, variableStack);
        }
    }

    private OclExp parseDotCase(Matcher m, String ocl, JSONArray ctx,
            Stack<String> variableStack) {

        String left = trim(m.group(1));
        String right = trim(m.group(3));
        String rightOperation = right.replaceFirst("(\\w*)\\(\\d+\\)",
                "$1");
        String operationPatt = "(\\w*)(\\((\\d+)\\))";
        String opParamPatt = "(\\w*)(\\((\\.*)\\))";
        Matcher mRight = Pattern.compile(operationPatt).matcher(right);

        if (mRight.find()) {
//            Used for operation defined in Classifier with paramenters

            String[] arguments = this.parenthesisArray
                    .get(Integer.valueOf(trim(mRight.group(3))))
                    .split(",");

            if (arguments.length == 1 & "".equals(arguments[0])) {
                arguments = new String[0];
            }

            OclExp[] argumentExps = new OclExp[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                argumentExps[i] = parse(arguments[i], ctx);
            }

            return new OperationCallExp(
                    parseOclExp(left, ctx, variableStack),
                    new Operation(rightOperation), argumentExps);
        } else {
            if (left.matches(ParserPatterns.VARIABLE_DECL_STR)) {
                left = left.replaceFirst(
                        ParserPatterns.VARIABLE_DECL_STR, "$1");
            }

            return new PropertyCallExp(new Variable(left), right);
        }
    }

    private OclExp parseArrowCase(Matcher m, String ocl, JSONArray ctx,
            Stack<String> variableStack) {

        String source = trim(m.group(1));
        String body = trim(replace(m.group(3)));
        String kind = trim(
                m.group(3).replaceFirst("(\\w*)\\(\\d+\\)", "$1"));

        System.out.println("\n\n" + "\nComplete: " + m.group()
                + "\nSource: " + source + "\nbody: " + body + "\nkind: "
                + kind + "\n\n");

        if (IteratorKind.valueOf(kind) == null) {
            throw new OclParserException("Invalid iterator kind!");
        }
        String iterator = "iterator";
        String iteratorDeclRx = "^(.*)\\|(.*)$";

        OclExp srcExp = parseOclExp(source, ctx, variableStack);

        if (body.matches(iteratorDeclRx)) {
            iterator = trim(body.replaceFirst(iteratorDeclRx, "$1"));

            if (variableStack.contains(iterator)) {
                throw new OclParserException(iterator + " already existed!");
            }

            body = trim(body.replaceFirst(iteratorDeclRx, "$2"));

            variableStack.push(iterator);
            System.out.println("String : " + body + " --> Stack : "
                    + variableStack);
        }

        OclExp bodyExp = "".equals(body) ? null
                : parseOclExp(body, ctx, variableStack);

        if(body.matches(iteratorDeclRx)) { variableStack.pop(); }

        return new IteratorExp(srcExp, kind, new Variable(iterator),
                bodyExp);
    }

    private String replace(String input) {

        String output = String.copyValueOf(input.toCharArray());
        Pattern p = Pattern.compile("((\\w+)\\()(\\d+)(\\)(.*))");
        Matcher m = p.matcher(output);

        if (m.find()) {
            String content = this.parenthesisArray
                    .get(Integer.valueOf(m.group(3)));

            if ("".equals(content)) {
                return content;
            }

            output = output.replaceFirst(p.pattern(), content);
        }

        return output;
    }

    private OclExp parseLiteralExp(String input, JSONArray ctx,
            Stack<String> variableStack) {
        /**
         * Any character between two single quote '' E.g.: "'Lorem ipsum
         * άλφα 123|, !@#$%^&*('"
         * 
         */
        final String STRING_LITERAL_PATT = "\\s*\\w*\\{(\\d+)*\\}";
        /**
         * Start ONLY with a word true OR false WITHOUT quote and
         * case-insensitive (?i) <- inline flag E.g.:"true", "false",
         * "True", "False", "TRUE", "FALSE" Note : there is NO single
         * quote
         */
        final String BOOLEAN_LITERAL_PATT = "(?i)(^\\btrue\\b|\\bfalse\\b$)";
        /**
         * String contains ONLY digit WITH an optional minus sign (-)
         * denoting negativity; this patterns allows, too, the decimal
         * number by adding optional group (.\\d+)?. This also allows
         * JAVA legal way of writing number using underscore (_) E.g.:
         * "12334", "-12345", "123_3445", "12_234.4893"
         */
        final String NUMERIC_LITERAL_PATT = "^-?(\\d+(_\\d+)*(.\\d+)?)(?<!_)$";
        /**
         * This is strictly a natural number. If this string is given a
         * number that is greater than what an Integer can hold, the
         * parser will throw an Error.
         */
        final String INTEGER_LITERAL_PATT = "^-?\\d+(_\\d+)*(?<!_)$";
        /**
         * This is strictly a real number. If this string is given a
         * number that is greater than what a Double can hold, the
         * parser will throw an Error.
         */
        final String REAL_LITERAL_PATT = "^-?(\\d+(_\\d+)*.\\d+)(?<!_)$";

        if (input.matches(NUMERIC_LITERAL_PATT)) {

            if (input.matches(INTEGER_LITERAL_PATT)) {

                return new IntegerLiteralExp(Integer.valueOf(input));
            } else if (input.matches(REAL_LITERAL_PATT)) {

                return new RealLiteralExp(Double.valueOf(input));
            }
        } else if (input.matches(STRING_LITERAL_PATT)) {
            if (input.matches("\\{(\\d+)\\}")) {
                input = input.replaceFirst(STRING_LITERAL_PATT, "$1");
                input = this.stringArray.get(Integer.valueOf(input));
            }

            if (UMLContextUtils.isClass(ctx, input)) {
                return new TypeExp(input);
            }

            return new StringLiteralExp(input);
        } else if (input.matches(BOOLEAN_LITERAL_PATT)) {

            return new BooleanLiteralExp(Boolean.valueOf(input));
        } else if (input.length() > 0) {

            return new VariableExp(new Variable(input));
        } else {
            throw new OclParserException(input + "\n======\n"
                    + "Invalid OCL Literal Expression!");
        }

        return new NullLiteralExp();
    }

    private String trim(String input) {
        String spacePatt = "^(\\s)*|(\\s)*$";
        Matcher m = Pattern.compile(spacePatt).matcher(input);
        if (m.find()) {
            return input.replaceAll(spacePatt, "");
        }

        return input;
    }
}
