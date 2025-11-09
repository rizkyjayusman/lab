package main

import "fmt"

func main() {
	// fmt.Println(sortPeople([]string{"Mary", "John", "Emma"}, []int{180, 165, 170}))
	fmt.Println(sortPeople([]string{"Alice", "Bob", "Bob"}, []int{155, 185, 150}))
}

func sortPeople(names []string, heights []int) []string {
	for i := 1; i < len(heights); i++ {
		key := heights[i]
		key_y := names[i]
		j := i - 1
		for j >= 0 && key > heights[j] {
			heights[j+1] = heights[j]
			names[j+1] = names[j]
			j -= 1
		}
		heights[j+1] = key
		names[j+1] = key_y
	}

	return names
}
