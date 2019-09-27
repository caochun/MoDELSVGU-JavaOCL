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

package com.vgu.se.jocl.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.vgu.se.jocl.env.Environment;
import com.vgu.se.jocl.exception.OclParserException;
import com.vgu.se.jocl.expressions.BooleanLiteralExp;
import com.vgu.se.jocl.expressions.IntegerLiteralExp;
import com.vgu.se.jocl.expressions.NullLiteralExp;
import com.vgu.se.jocl.expressions.OclExp;
import com.vgu.se.jocl.expressions.OperationCallExp;
import com.vgu.se.jocl.expressions.RealLiteralExp;
import com.vgu.se.jocl.expressions.StringLiteralExp;

public class Parser {
    
    /**
     * <p>V1 : <code>^((?!\\.|-&gt|\\(|\\)).)*$</code> : <br />This means lookahead in 
     * the string, find any character that is not preceded by 
     * any of the following character <code>{.,|,(,),->}</code>,
     * and get them ALL, starting from the beginning to the end
     * of the line.</p>
     * 
     * <p><strong>1st Capturing Group</strong> 
     * <code>((?!\.|-&gt|\||\(|\)).)*</code>
     * <code>*</code> Quantifier — Matches between zero and unlimited
     * times, as <code>*</code> many times as possible, giving back
     * as needed (greedy)</p>
     * 
     * <p><code>(?!\\.|->|\\(|\\)|\\|</code> : Negative lookahead 
     * Assert that the Regex below does not match <br />
     * 1st Alternative <code style="background-color:#e5e5e5;">\.</code>:<br />
     *      <code style="background-color:#e5e5e5;">\.</code> matches the character {@code .}
     *      literally (case sensitive) <br />
     * 2nd Alternative <code>-></code>:
     *      <code>-></code> matches the characters <code>-></code> literally
     *      (case sensitive)<br />
     * 3rd Alternative <code>\)</code>
     *      <code>\)</code> matches the character <code>)</code> literally (case
     *      sensitive)<br />
     * 4th Alternative <code>\(</code>
     *      <code>\(</code> matches the character <code>(</code> literally
     *      (case sensitive)<br />
     * 5th Alternative <code>\|</code>
     *      <code>\|</code> matches the character <code>|</code> literally
     *      (case sensitive)<br />
     * 
     * {@code .} matches any character (except for line
     * terminators) 
     */
    private static final Pattern initCases = Pattern.compile("^((?!\\.|->|\\(|\\)|\\|).)*$");
    
    /**
     * This parse an OCL Expression string to OclExp Java Object given
     * a UML Context file.
     * 
     * @param plainUMLContext
     * @param oclExpStr
     * @return OclExp
     */
    public static OclExp parse(JSONArray plainUMLContext,
            String oclExpStr) {
        Matcher m = initCases.matcher(oclExpStr);
        if (m.find()) {
            String input = m.group();
            getOclExpType(input);
        }
        
        return new StringLiteralExp(new String(""));
    }
    
    private static OclExp getOclExpType(String input) {
        if(input.matches("(?i)(^('?(-?\\d+(\\.?\\d+)?|(\\w+)+)'?)$)")) {
            return parseLiteralExp(input);
        } else if(input.matches("")) {
            
        }
    }
    
    private static OclExp parseLiteralExp(String input) {
        /**
         * Any character between two single quote ''
         * E.g.: "'Lorem ipsum άλφα 123|, !@#$%^&*('"
         * 
         */
        final String STRING_LITERAL_PATT = "^'.*'$";
        /**
         * Start ONLY with a word true OR false WITHOUT quote and 
         * case-insensitive (?i) <- inline flag
         * E.g.:"true", "false", "True", "False", "TRUE", "FALSE"
         * Note : there is NO single quote
         */
        final String BOOLEAN_LITERAL_PATT = "(?i)(^\\btrue\\b|\\bfalse\\b$)";
        /**
         * String contains ONLY digit WITH an optional minus sign (-)
         * denoting negativity; this patterns allows, too, the decimal
         * number by adding optional group (.\\d+)?.
         * This also allows JAVA legal way of writing number using 
         * underscore (_)
         * E.g.: "12334", "-12345", "123_3445", "12_234.4893"
         */
        final String NUMERIC_LITERAL_PATT = "^-?(\\d+(_\\d+)*(.\\d+)?)(?<!_)$";
        /**
         * This is strictly a natural number. If this string is given
         * a number that is greater than what an Integer can hold, the 
         * parser will throw an Error.
         */
        final String INTEGER_LITERAL_PATT = "^-?\\d+(_\\d+)*(?<!_)$";
        /**
         * This is strictly a real number. If this string is given
         * a number that is greater than what a Double can hold, the 
         * parser will throw an Error.
         */
        final String REAL_LITERAL_PATT = "^-?(\\d+(_\\d+)*.\\d+)(?<!_)$";

        if(input.matches(BOOLEAN_LITERAL_PATT)) {
            boolean val = Boolean.valueOf(input);
            return new BooleanLiteralExp(val);
        } else if(input.matches(STRING_LITERAL_PATT)) {
            return new StringLiteralExp(input);
        } else if(input.matches(NUMERIC_LITERAL_PATT)) {
            if(input.matches(INTEGER_LITERAL_PATT)) {
                return new IntegerLiteralExp(Integer.valueOf(input));
            } else if(input.matches(REAL_LITERAL_PATT)) {
                return new RealLiteralExp(Double.valueOf(input));
            }
        } else {
            throw new OclParserException("Invaliic OCL Literal Expression!");
        }
        
        return new NullLiteralExp();
    }

}
