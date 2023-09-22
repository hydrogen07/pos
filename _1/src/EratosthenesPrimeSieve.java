import java.util.ArrayList;

public class EratosthenesPrimeSieve implements PrimeSieve {

    private ArrayList<Integer> numbers;
    private ArrayList<Integer> primes;

    public EratosthenesPrimeSieve(int upperBound) {
        numbers = new ArrayList<>();
        primes = new ArrayList<>();
        for (int i = 2; i <= upperBound; i++)
            numbers.add(i);
    }

    @Override
    public boolean isPrime(int p) {
        return false;
    }

    @Override
    public void printPrimes() {

    }

    private void sieveAlgorithm() {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j : numbers) {
                if ()
                primes.add(j);
            }
        }
    }
}