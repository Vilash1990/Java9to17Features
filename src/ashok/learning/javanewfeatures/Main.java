package ashok.learning.javanewfeatures;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Feature 1(JAVA 14): Record Type -> Testing Record for POJO'S to remove lot of boiler plate code. And we don't need to depend on Lombok
        PersonRecord personRecord = new PersonRecord("Ashok", 33);
        System.out.println(personRecord.name());
        System.out.println(personRecord);
        System.out.println(personRecord.equals(personRecord));

        //Feature 2 (JAVA 10): Var Data type like Javascript- Type Script

        var id = 1;
        var name = "Ashok Maricharla";
        var age = 31;

        System.out.println("My name is:" + name + ", My age is:" + age + ", My Id is:" + id);

        //Feature 3 (JAVA 15): Multi Line String definition -> Testing Multi Line String
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

        // Feature 4 (JAVA 12): Simplified Switch Cases

        String day = "SUNDAY";

        System.out.println("DAY COUNT: " + daysCount(day));

        var otherDay = "TUESDAY";

        System.out.print("SIMPLIFIED DAY COUNT: ");
        daysCountSimplified(otherDay);

        //  Old way of writing instance of
        MusicFile musicFile = new VideoFile();
        if (musicFile instanceof AudioFile) {
            ((AudioFile) musicFile).playAudio();
        }
        if (musicFile instanceof VideoFile) {
            ((VideoFile) musicFile).playVideo();
        }

        // Feature 5 (JAVA 14): New way of writing instance of. We don't need to cast externally if we need to use instance of

        if (musicFile instanceof AudioFile audioFile) {
            audioFile.playAudio();
        } else if (musicFile instanceof VideoFile videoFile) {
            videoFile.playVideo();
        }

        //JAVA 9: Of on collections
        List namesList = List.of("Ashok", "Vilasi", "Rishit");
        namesList.forEach(personName -> {
            System.out.println(personName);
        });

        Map<Integer, String> namesMap = Map.ofEntries(Map.entry(1,"Ashok"), Map.entry(2,"Vilasi"), Map.entry(3,"Rishit"));

        Map<Integer, String> namesMap1 = Map.of(1, "Ashok", 2, "Vilasi", 3, "Rishit");

        namesMap.values().stream().forEach(name2 -> System.out.println(name2));

        namesMap1.values().stream().forEach(name3 -> System.out.println(name3));

        //Feature 6 (JAVA 14): Meaningful Null pointer exception

        PersonRecord personRecord1 = new PersonRecord(null, 15);
        System.out.println(personRecord1.name().substring(2, 3));
    }

    private static int daysCount(String day) {
        switch (day) {
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

    private static void daysCountSimplified(String day) {
        switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> System.out.println("6");
            case "TUESDAY" -> System.out.println("7");
            case "THURSDAY", "SATURDAY" -> System.out.println("8");
            case "WEDNESDAY" -> System.out.println("9");
            default -> System.out.println("0");
        }
    }
}
