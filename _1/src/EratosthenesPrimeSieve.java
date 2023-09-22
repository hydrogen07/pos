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
        return primes.contains(p);
    }

    @Override
    public void printPrimes() {
        for (int i : primes)
            System.out.println(i);
    }

    private void sieveAlgorithm() {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j : numbers) {
                if (j+1%numbers.get(0) == 0)
                    numbers.remove(j-2);
            }
            primes.add(numbers.get(0));
            numbers.remove(0);
        }
    }
}