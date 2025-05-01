import java.util.*;
import java.io.*;

public class lab13 {
    private ArrayList<Integer> data;

    public lab13() {
        data = new ArrayList<>();
    }

    public void readData(String filename) throws IOException {
	// reads input file and stores values in an ArrayList<Integer>
	BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                data.add(Integer.parseInt(line.trim()));
            }
        }
        reader.close();
    }

    public long getTotalCount() {
	// return the number of values
	return data.size();
    }

    public long getOddCount() {
	// return the number of odd values
	return data.stream().filter(n -> n % 2 != 0).count();
    }

    public long getEvenCount() {
	// return the number of even values
	return data.stream().filter(n -> n % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount() {
	// return the number of distinct values greater than 5
	return data.stream().filter(n -> n > 5).distinct().count();
    }

    public Integer[] getResult1() {
	// return even values greater than 5 and less than 50 in sorted order
 	//return new Integer[0];
	return data.stream()
	    .filter(n -> n > 5 && n < 50 && n % 2 == 0)
	    .sorted()
	    .toArray(Integer[]::new);
    }

    public Integer[] getResult2() {
	// return the first 50 of the values after squaring  and multiplying values by 3 as an int
	//return new Integer[0];
	return data.stream()
	    .limit(50)
	    .map(n -> n * n * 3)
	    .toArray(Integer[]::new);
    }

    public Integer[] getResult3() {
	// filter out the even values (or keep the odd values),
	// multiply remaining values by 2, sort, skip over the first 20 elements, remove duplicate values
	// return the values as an int
	//return new Integer[0];
	return data.stream()
	    .filter(n -> n % 2 != 0)    // keeping odd value
	    .map(n -> n * 2)            // multiplying by 2
	    .sorted()
	    .skip(20)
	    .distinct()                 // removing duplicates
	    .toArray(Integer[]::new);   // converting to integer
    }
}
