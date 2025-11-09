package main

type AddTwoIntegers struct{}

func (ati AddTwoIntegers) sum(num1 int, num2 int) int {
	return num1 + num2
}
