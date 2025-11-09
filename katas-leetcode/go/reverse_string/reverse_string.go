package main

import "fmt"

func main() {
	fmt.Println([]byte{'h', 'e', 'l', 'l', 'o'})
	fmt.Println([]byte{'H', 'a', 'n', 'n', 'a', 'h'})
}

func reverseString(s []byte) {
	i := 0
	j := len(s) - 1
	for i < j {
		tmp := s[i]
		s[i] = s[j]
		s[j] = tmp
		i++
		j--
	}
}
