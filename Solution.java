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
  * Finds the number of long integers with value range 
  * 1 <= (integer value) < query 
  * that have fulfill the requirement: 
  * (integer value) XOR (query) > query.
  *
  * The position of the leading '1', in the binary represenation 
  * of the number that is being checked, is shifted from lower to higher 
  * bit positions unitl the value of this number is lower than value of the query. 
  *
  * Thus value of the number that is being check is always lower than the value of query. 
  * Therefore, for the binary represenations of this number and of the query 
  * it is always true that:
  * If for the position of the leading '1' (highest value bit) in the number that
  * is being checked, there is '0' at the same position in the query, then
  * all possible combinations of '0s' and '1s' afterwards fulfill 
  * the requirement of (integer value) XOR (query) > query.
  * 
  * @return A long integer representing the total number of integers that fulfill 
  *         the above-mentioned requirements.
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
