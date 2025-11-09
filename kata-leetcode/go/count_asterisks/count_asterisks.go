package main

import "fmt"

func main() {
	fmt.Println(countAsterisks("l|*e*et|c**o|*de|"))
	fmt.Println(countAsterisks("iamprogrammer"))
	fmt.Println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"))
}

func countAsterisks(s string) int {
	count := 0
	check := true
	for _, v := range s {
		if v == '*' && check {
			count++
		} else if v == '|' {
			check = !check
		}
	}
	return count
}
