package main

import (
	"fmt"
)

func main() {
	fmt.Println(minBitFlips(10, 7))
	// fmt.Println(minBitFlips(3, 4))
}

func minBitFlips(start int, goal int) int {
	highest := start
	if start < goal {
		highest = goal
	}

	bit := 1
	for {
		highest -= bit
		if highest <= 0 {
			break
		}
		bit *= 2
	}

	step := 0
	for {
		fmt.Println(start/bit, goal/bit)
		if start/bit != goal/bit {
			step++
		}

		if start >= bit {
			start -= bit
		}

		if goal >= bit {
			goal -= bit
		}

		if bit == 1 {
			break
		}
		bit /= 2
	}

	return step
}
