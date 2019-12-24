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

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.vgu.dm2schema.dm.DataModel;

import com.vgu.se.jocl.expressions.Expression;
import com.vgu.se.jocl.parser.simple.SimpleParser;

public class ParserTest {

    @SuppressWarnings("unused")
    private static JSONArray plainUMLContext;
    @SuppressWarnings("unused")
    private static String oclExpStr;

    @SuppressWarnings("unused")
    private static Map<Integer, Integer> testInt = new HashMap<>();

    static {
        String s = "[" + "{\"class\" : \"Car\","
                + "\"attributes\" : [{\"name\" : \"color\", \"type\" : \"String\"}]"
                + "}," + "{\"class\" : \"Person\","
                + "\"attributes\" : [{\"name\" : \"name\", \"type\" : \"String\"}]"
                + "}," + "{\"association\" : \"Ownership\","
                + "\"ends\" : [\"owners\", \"ownedCars\"],"
                + "\"classes\" : [\"Car\", \"Person\"]" + "}" + "]";

        try {
            plainUMLContext = (JSONArray) new JSONParser().parse(s);
            oclExpStr = "Car.allInstances() -> forAll(c|c.owners -> select(p|p.name='Hoang')->forAll(c|c.color = 'blue')) -> collect(d|d->forAll(d2|d2))";
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException, Exception {
        SimpleParser parser = new SimpleParser();
        String[] ocls = getTestCases();

        File dataModelFile = new File("src/test/resources/university_test.json");
        DataModel dataModel = new DataModel(new JSONParser().parse(
                new FileReader(dataModelFile.getAbsolutePath())));
        
        for (int i = 0; i < ocls.length; i++) {
            Expression result = parser.parse(ocls[i], dataModel);
            System.out.println(result);
        }
    }

    @SuppressWarnings("unused")
    private static String trim(String input) {

        String spacePatt = "^(\\s)*|(\\s)*$";
        Matcher m = Pattern.compile(spacePatt).matcher(input);
        if (m.find()) {
            return input.replaceAll(spacePatt, "");
        }

        return input;
    }
    
    private static String[] getTestCases() {
        String[] ocls = {
//                "Student.allInstances()->collect(s|s.enrolls)",
                "University.allInstances()->collect(u|u.programs)",

//             "Car.allInstances()",
//             "Car.allInstances()->asSet()",
//             "Car.allInstances()->collect(c|c.color < @SQL_CURDATE())",
//             "Car.allInstances()->collect(c|c.color < @SQL(CURDATE()) )",
//             "Car.allInstances()->collect(c|c.owners)",
//             "Car.allInstances()->collect(c|c.color)->asSet()",
//             "Car.allInstances()->collect(c|c.color)->isEmpty()",
//             "Car.allInstances()->collect(c|c.color)->notEmpty()",
//             "Car.allInstances()->collect(c|c.color)->size()",
//             "Car.allInstances()->collect(c|c.owners)",
//             "Car.allInstances()->collect(c|c.owners)->flatten()",
//             "Car.allInstances()->collect(c|c.owners)->flatten()->size()",
//             "Car.allInstances()->collect(c|c.owners)->size()",
//             "Car.allInstances()->collect(c|c.owners->asSet())->flatten()",
//             "Car.allInstances()->collect(c|c.owners->isEmpty())",
//             "Car.allInstances()->collect(c|c.owners->notEmpty())",
//             "Car.allInstances()->exists(c|c.color <> 'no-color')",
//             "Car.allInstances()->exists(c|c.owners->forAll(p|p.name = 'no-name'))",
//             "Car.allInstances()->exists(c|c.owners->isEmpty())",
//             "Car.allInstances()->exists(c|c.owners->notEmpty())",
//             "Car.allInstances()->forAll(c|'blue'=c.color)",
//             "Car.allInstances()->forAll(c|c.owners->collect(p|p)->size() = 1)",
//             "Car.allInstances()->forAll(c|c.owners->collect(p|p.ownedCars)->flatten()->size()=1)",
//             "Car.allInstances()->forAll(c|c.owners->exists(p|p.name = 'no-name'))",
//             "Car.allInstances()->forAll(c|c.owners->forAll(p|p.ownedCars->forAll(c1|c1.color=c.color)))",
//             "Car.allInstances()->forAll(c|c.owners->isEmpty())",
//             "Car.allInstances()->forAll(c|c.owners->notEmpty())",
//             "Car.allInstances()->forAll(c|c.owners->select(p|p.name.oclIsUndefined())->size()=0)",
//             "Car.allInstances()->isEmpty()",
//             "Car.allInstances()->notEmpty()",
//             "Car.allInstances()->select(c|c.color = 'no-color')",
//             "Car.allInstances()->select(c|c.color = 'no-color')->size()",
//             "Car.allInstances()->select(c|c.color.oclIsUndefined())",
//             "Car.allInstances()->select(c|c.owners->exists(p|p.name = 'no-name'))->size()",
//             "Car.allInstances()->select(c|c.owners->exists(p|p.name.oclIsUndefined()))->size()",
//             "Car.allInstances()->size()",
//             "Person.allInstances()->collect(p|p.ownedCars->size())",
//             "Person.allInstances()->exists(p|p.ownedCars->exists(c|c.color = 'no-color'))",
//             "Person.allInstances()->exists(p|p.ownedCars->forAll(c|c.color = 'no-color'))",
//             "Person.allInstances()->exists(p|p.ownedCars->size() < 10)",
//             "Person.allInstances()->exists(p|p.ownedCars->size() = 10)",
//             "Person.allInstances()->forAll(p|p.ownedCars->exists(c|c.color = 'no-color'))",
//             "Person.allInstances()->forAll(p|p.ownedCars->forAll(c|c.color = 'no-color'))",
//             "Person.allInstances()->forAll(p|p.ownedCars->size() > 0)",
//             "Person.allInstances()->forAll(p|true)",
//             "Person.allInstances()->select(p|p.ownedCars->exists(c|c.color <> 'no-color'))",
//             "Person.allInstances()->select(p|p.ownedCars->exists(c|c.color.oclIsUndefined()))",
//             "Person.allInstances()->select(p|p.ownedCars->forAll(c|c.color <> 'no-color'))",
//             "true",
//             "self",
//             "self = caller",
//             "self.name",
//             "self.name = 'Hoang'",
//             "self.ownedCars",
//             "self.ownedCars->size()",
//             "self.ownedCars->exists(c|c.color = 'black')",
//             "Car.allInstances()->exists(c|c.owners->exists(p|p = self))",
//             "Car.allInstances()->exists(c|c.owners->exists(p|p.ownedCars->size() < self.ownedCars->size()))",
//             "Car.allInstances()->exists(c| c.color = 'blue')",

        };
        
        return ocls;
    }

}
