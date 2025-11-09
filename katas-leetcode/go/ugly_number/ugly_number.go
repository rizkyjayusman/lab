package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(isPrime(4))
}

func isUgly(n int) bool {
	res := true
	if isPrime(n) 
}

func isPrime(n int) bool {
	res := true
	if n == 1 {
		return res
	}
	sqrt := int(math.Sqrt(float64(n)))
	for i := 2; i <= sqrt; i++ {
		if n%i == 0 {
			res = false
		}
	}

	return res
}
