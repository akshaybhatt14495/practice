package hackerrank;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Geo{
    public String lat;
    public String lng;
}

class Address{
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;
}

class Company{
    public String name;
    public String basename;
}

class User{
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String website;
    public Company company;
}


public class ParseInput {
    public static void main(String[] args) throws IOException {

        System.out.println(apiResponseParser(Arrays.asList("username", "EQUALS", "Wilsonp"), 1));
    }

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        try {
            List<User> list = apiResponse();
            Gson gString = new Gson();
            System.out.println(gString.toJson(list));
            String field = inputList.get(0);
            String operator= inputList.get(1);
            String value= inputList.get(2);

            String []splitArray = field.split("\\.");

            List <Integer> ids = new ArrayList<>();
            for (User u : list) {
                String resultValue;
                switch(splitArray[0]) {
                    case "address": {
                        switch(splitArray[1]) {

                            case "geo" : {
                                Field fieldVal = u.address.geo.getClass().getDeclaredField(splitArray[2]);
                                fieldVal.setAccessible(true);
                                resultValue = (String) fieldVal.get(u.address.geo);
                                break;
                            }
                            default: {
                                Field fieldVal = u.address.getClass().getDeclaredField(splitArray[1]);
                                fieldVal.setAccessible(true);
                                resultValue = (String) fieldVal.get(u.address);
                                break;
                            }
                        }

                        break;

                    }
                    case "company": {
                        Field fieldVal = u.company.getClass().getDeclaredField(splitArray[1]);
                        fieldVal.setAccessible(true);
                        resultValue = (String) fieldVal.get(u.company);
                        break;

                    }
                    default: {

                        Field fieldVal = u.getClass().getDeclaredField(splitArray[0]);
                        fieldVal.setAccessible(true);
                        resultValue = (String) fieldVal.get(u);
                        break;
                    }

                }
                if (operator.equals("EQUALS")) {
                    if (resultValue.equalsIgnoreCase(value)) {
                        ids.add(u.id);
                    }

                } else if (operator.equals("IN")) {

                    String []expectedValues = value.split("\\,");

                    for (String expected: expectedValues) {
                        if (resultValue.equals(expected)) {
                            ids.add(u.id);
                            break;
                        }
                    }
                }
            }
            return ids;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }


    }

    public static List<User> apiResponse() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String input;
            String content="";
            while ((input = in.readLine()) !=null) {
                content+=input;
            }
            in.close();
            //System.out.println(content);
            Gson g = new Gson();

            JsonArray jsonArray = new JsonParser().parse(content).getAsJsonArray();
            List<User> list = new ArrayList<>();

            for (int i=0; i< jsonArray.size(); i++) {
                JsonElement str = jsonArray.get(i);
                User             obj = g.fromJson(str, User.class);
                list.add(obj);
            }

            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }


    }

}
