package com.questions.jsonparser;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Demo {
  public static void main(String[] args) {
    JSONParser parser = new JSONParser();
    String test1 = "{ \"name\" : \"Alice\" }";
    // print(parser.parse(test1), 0);
    String test2 = "{ \"name\" : \"Alice\", \"parents\" : { \"father\" : \"Bob\", \"mother\" : \"Jane\" } , \"subject\" : [ \"MAC01\", \"MAC02\", \"ALG01\" ] }";
    print(parser.parse(test2), 0);

    String test3 = "{ \"name\" : \"Alice\", \"parents\" : { \"father\" : \"Bob\", \"mother\" : \"Jane\", \"phone\" : \"999999\" } , \"phone\" : null, \"subjectsPassed\" : [true, false, true] , \"cpga\" : 8.0 }";
    print(parser.parse(test3), 0);

  }

  private static void print(Object json, int indent) {
    String pad = " ".repeat(indent);
    if (json instanceof Map) {
      Map<?, ?> map = (Map) json;
      System.out.println(pad + "{");
      for (Entry<?, ?> entry : map.entrySet()) {
        System.out.print(pad + "\"" + entry.getKey() + "\" : ");
        print(entry.getValue(), indent + 1);
        // System.out.print(",");
      }
      System.out.println(pad + "}");
    } else if (json instanceof List) {
      List<?> list = (List) json;
      System.out.println("\n" + pad + "[");
      for (Object element : list) {
        // System.out.println(p);
        print(element, indent + 1);
      }
      System.out.println(pad + "]");
    } else if (json instanceof String) {
      System.out.println("\"" + (String) json + "\",");
    } else {
      System.out.println(pad + json + ",");
    }
  }
}
