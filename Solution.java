import java.util.Scanner;

public class Soution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfQueries = scanner.nextInt();

    while (numberOfQueries-- > 0) {
      long query = scanner.nextLong();
      System.out.println(findGreatXOR(query));
    }
    scanner.close();
  }
  
    /**
  * The method finds the number of long integers that fulfill the folloiwng requirements:
  * (1) <= (integer) < (query) 
  * (integer) XOR (query) > (query).
  *
  * Provided that the value of the integer is always lower than the value of the query, then   
  * for the Binary Represenations of the integer and the query, it is always true that:
  *
  * If for the position of highest value bit (the leading '1') in the integer, there is '0' 
  * at the equivalent position (as counted from right to left) in the query, then  
  * the leading '1' together with all possible combinations of '0s' and '1s' afterwards,
  * correspond to integers that fulfill the requirement of (integer) XOR (query) > (query). 
  *
  * Thus, for example, if (integer) = (1xxx) and (query) = (10xxx), 
  * where each individual 'x' could be '0' or '1', then (integer) XOR (query) > (query).
  * 
  * @return A long integer representing the total number of integers that fulfill 
  *        the above-mentioned requirements.
  */
  private static long findGreatXOR(long query) {
    long result = 0;
    int position_firstBit = 0;

    for (long i = 1; i < query; i <<= 1) {
      if ((i ^ query) > query) {
        result = result + (long) Math.pow(2, position_firstBit);
      }
      position_firstBit++;
    }
    return result;
  }
}
