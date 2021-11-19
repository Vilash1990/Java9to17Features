public class Main {

    public static void main(String[] args) {
        // Feature 1: Record Type -> Testing Record for POJO'S to remove lot of boiler plate code. And we don't need to depend on Lombok
        PersonRecord personRecord = new PersonRecord("Ashok", 33);
        System.out.println(personRecord.name());
        System.out.println(personRecord);
        System.out.println(personRecord.equals(personRecord));

        //Feature 2: Var Data type like Javascript

        var id = 1;
        var name = "Ashok Maricharla";
        var age = 31;

        System.out.println("My name is:"+ name + ", My age is:"+ age + ", My Id is:"+ id);

        //Feature 3: Multi Line String definition -> Testing Multi Line String
        String query = """
                
                
                INSERT INTO PERSON (uuid, name,age)
                	VALUES(:id, :personName, : personAge)
                	ON CONFLICT DO NOTHING;
                	
                """;
        String personJSON = """
                
                {
                    "id"    : 12345,
                    "name"  : "Ashok Maricharla",
                    "age"   : 31
                }
                
                """;
        System.out.println(query);
        System.out.println(personJSON);

      // Feature 4: Simplified Switch Cases

      String day= "SUNDAY";

      System.out.println("DAY COUNT: "+ daysCount(day));

      var otherDay = "TUESDAY";

      System.out.print("SIMPLIFIED DAY COUNT: ");
      daysCountSimplified(otherDay);

    }

    private static int daysCount(String day){
        switch (day){
            case "MONDAY":
            case "FRIDAY":
            case "SUNDAY":
                return 6;
            case "TUESDAY":
                return 7;
            case "THURSDAY":
            case "SATURDAY":
                return 8;
            case "WEDNESDAY":
                return 9;
            default:
                return 0;
        }
    }

    private static void daysCountSimplified(String day){
        switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> System.out.print("6");
            case "TUESDAY" -> System.out.print("7");
            case "THURSDAY", "SATURDAY" -> System.out.print("8");
            case "WEDNESDAY" -> System.out.print("9");
            default -> System.out.print("0");
        }
    }
}
