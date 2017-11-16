public class Benchmark {

	public Benchmark(int nth) {
		long[] primes = new long[nth];
		long nthPrime = nthPrime(nth, primes);
		System.out.println(nth+"th Prime Number: "+nthPrime);
	}

	private long nthPrime(int nth, long[] primes) {
		if(primes[0]==2 && primes[1]==3){
			for(int i=2;i<primes.length;i++)
				primes[i] = nextPrime(i-1, primes);
			return primes[nth-1];
		}else{
			primes[0] = 2L; primes[1] = 3L;
			return nthPrime(nth, primes);
		}
	}

	private long nextPrime(int idx, long[] primes) {
		long prev = primes[idx];
		while(!isPrime(prev+=2, primes));
		return prev;
	}

	private boolean isPrime(long p, long[] primes) {
		long sqrt = (long)Math.sqrt(p);
		for(int i=0;primes[i]<=sqrt;i++)
			if(p%primes[i]==0) return false;
		return true;
	}

	public static void main(String[] args) {
		new Benchmark(10000000);
	}
}

