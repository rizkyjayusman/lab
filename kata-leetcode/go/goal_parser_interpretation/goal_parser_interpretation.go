package main

import (
	"bytes"
	"fmt"
)

func main() {
	fmt.Println(interpret("G()(al)"))
	// fmt.Println(interpret("G()()()()(al)"))
	// fmt.Println(interpret("(al)G(al)()()G"))
}

func interpret(command string) string {
	var buffer bytes.Buffer
	for k := 0; k < len(command); k++ {
		if command[k] == '(' && k+1 < len(command) {
			if command[k+1] == ')' {
				buffer.WriteString("o")
				k = k + 1
			} else if command[k+1] == 'a' {
				buffer.WriteString("al")
				k = k + 3
			}
		} else {
			buffer.WriteByte(command[k])
		}
	}

	return buffer.String()
}
