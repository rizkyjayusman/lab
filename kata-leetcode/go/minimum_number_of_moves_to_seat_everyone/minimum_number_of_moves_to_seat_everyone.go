package main

import (
	"fmt"
)

func main() {
	fmt.Println(minMovesToSeat([]int{3, 1, 5}, []int{2, 7, 4}))
	fmt.Println(minMovesToSeat([]int{4, 1, 5, 9}, []int{1, 3, 2, 6}))
	fmt.Println(minMovesToSeat([]int{2, 2, 6, 6}, []int{1, 3, 2, 6}))
	fmt.Println(minMovesToSeat([]int{3, 20, 17, 2, 12, 15, 17, 4, 15, 20}, []int{10, 13, 14, 15, 5, 2, 3, 14, 3, 18}))
}

func minMovesToSeat(seats []int, students []int) int {
	for i := 0; i < len(seats)-1; i++ {
		for j := 0; j < len(seats)-i-1; j++ {
			if seats[j] > seats[j+1] {
				seats[j], seats[j+1] = seats[j+1], seats[j]
			}

			if students[j] > students[j+1] {
				students[j], students[j+1] = students[j+1], students[j]
			}
		}
	}

	fmt.Println(seats, students)

	res := 0
	for k, vseat := range seats {
		diff := vseat - students[k]
		if diff < 0 {
			diff *= -1
		}
		res += diff
	}

	return res
}
