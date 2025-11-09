package main

type AddDigits struct{}

func (ad AddDigits) AddDigits(num int) int {
	for num >= 10 {
		num = (num % 10) + (num / 10)
	}
	return num
}
