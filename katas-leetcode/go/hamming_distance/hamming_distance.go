package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Println(hammingDistance(1, 4))
}

func hammingDistance(x int, y int) int {
	max := x
	if y > max {
		max = y
	}

	i := 1
	for {
		if i >= max {
			break
		}
		i *= 2
	}

	for {
		if i <= 0 || y <= 0 {
			break
		}

		if x > 0 {
			fmt.Printf("x %v\n", x)
			x -= i
		}

		if y > 0 {
			fmt.Printf("y %v\n", y)
			y -= i
		}

		i /= 2
		time.Sleep(1 * time.Second)
	}

	return i
}
