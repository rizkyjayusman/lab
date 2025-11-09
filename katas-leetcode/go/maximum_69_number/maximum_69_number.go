package main

import "fmt"

func main() {
	fmt.Println(maximum69Number(9669))
	fmt.Println(maximum69Number(9996))
	fmt.Println(maximum69Number(9999))
}

func maximum69Number(num int) int {
	max := num
	x := 1
	y := 1
	for x < num {
		x *= 10

		r := num
		d := (r % x) / y
		add := 3 * y
		if d == 6 {
			r += add
		} else if d == 9 {
			r -= add
		}

		if r > max {
			max = r
		}

		y *= 10
	}
	return max
}
