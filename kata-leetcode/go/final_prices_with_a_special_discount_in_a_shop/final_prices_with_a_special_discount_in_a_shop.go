package main

import "fmt"

type Shop struct{}

func (s Shop) FinalPrices(prices []int) []int {
	for i := 0; i <= len(prices)-2; i++ {
		for j := i + 1; j <= len(prices)-1; j++ {
			fmt.Println(i, j)
			if prices[j] <= prices[i] {
				prices[i] = prices[i] - prices[j]
				break
			}
		}
	}
	return prices
}
