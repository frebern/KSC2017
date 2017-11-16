import java.util.ArrayList;

public class BenchmarkPrime {

	public BenchmarkPrime(int nth) {
		ArrayList<Long> primes = new ArrayList<>();
		long nthPrime = nthPrime(nth, primes);
		System.out.println(nth+"th Prime Number: "+nthPrime);
	}

	private long nthPrime(int nth, ArrayList<Long> primes) {
		int len = primes.size();
		if(len>=2){
			while(nth>primes.size())
				primes.add(nextPrime(primes));
			return primes.get(nth-1);
		}else{
			primes.clear();
			primes.add(2L); primes.add(3L);
			return nthPrime(nth, primes);
		}
	}

	private long nextPrime(ArrayList<Long> primes) {
		long prev = primes.get(primes.size()-1);
		while(!isPrime(prev+=2, primes));
		return prev;
	}

	private boolean isPrime(long p, ArrayList<Long> primes) {
		return primes.stream()
			     .filter(i -> i*i<=p)
			     .allMatch(i -> !(p%i==0));
	}

	public static void main(String[] args) {
		new BenchmarkPrime(500000);
	}

}

