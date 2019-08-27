import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main ( String[] args ) throws FileNotFoundException {


        appWithFiles ( "files/in/in.csv" , 10 , "files/out/out.csv" );


    }


    public static void appWithFiles ( String fileIn , int month , String fileOut ) throws FileNotFoundException {

        List<Person> personList = Person.readingFromFileInList ( month , fileIn );
        Collections.sort ( personList );
        sortingTheListFromFile ( fileIn );
        writeToAnotherFile ( personList , fileOut );

    }

    private static void writeToAnotherFile ( List<Person> personList , String fileOut ) {
        String filePath = fileOut;
        try (Writer writer = new BufferedWriter ( new OutputStreamWriter (
                new FileOutputStream ( filePath ) ) )) {
            for ( int i = 0; i < personList.size ( ); i++ ) {
                writer.write ( String.valueOf ( personList.get ( i ).getFirstName ( ) + " " + String.valueOf ( personList.get ( i ).getLastName ( ) ) + System.lineSeparator ( ) ) );

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ( );
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }


    private static void sortingTheListFromFile ( String fileIn ) {
        String fileName = fileIn;
        List<String> list = new ArrayList<> ( );

        try (Stream<String> stream = Files.lines ( Paths.get ( fileName ) )) {

            list = stream
                    .sorted ( ( o1 , o2 ) -> o1.compareTo ( o2 ) )
                    .collect ( Collectors.toList ( ) );


        } catch (IOException e) {
            e.printStackTrace ( );
        }


        //list.forEach ( System.out::println );
    }
}

