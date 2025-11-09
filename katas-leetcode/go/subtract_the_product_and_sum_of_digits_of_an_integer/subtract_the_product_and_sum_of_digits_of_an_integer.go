package main

import "fmt"

func main() {
	fmt.Println(subtractProductAndSum(234))
}

func subtractProductAndSum(n int) int {
	productDigit, sumDigit := 1, 0
	for n > 0 {
		x := n % 10
		productDigit *= x
		sumDigit += x
		n /= 10
	}
	return productDigit - sumDigit
}
