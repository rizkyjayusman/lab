package main

import "fmt"

func main() {
	fmt.Println(restoreString("codeleet", []int{4, 5, 6, 7, 0, 1, 2, 3}))
	// fmt.Println(restoreString("abc", []int{0, 1, 2}))
}

func restoreString(s string, indices []int) string {
	arr := make([]rune, len(indices))
	for k, v := range s {
		arr[indices[k]] = v
	}
	return string(arr)
}
