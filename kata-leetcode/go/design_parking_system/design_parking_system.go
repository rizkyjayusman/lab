package main

import "fmt"

type ParkingSystem struct {
	big    int
	medium int
	small  int
}

func Constructor(big int, medium int, small int) ParkingSystem {
	return ParkingSystem{
		big:    big,
		medium: medium,
		small:  small,
	}
}

func (p *ParkingSystem) AddCar(carType int) bool {
	switch carType {
	case 1:
		if p.big != 0 {
			p.big--
			return true
		}
	case 2:
		if p.medium != 0 {
			p.medium--
			return true
		}
	case 3:
		if p.small != 0 {
			p.small--
			return true
		}
	}
	return false
}

func main() {
	ps := Constructor(1, 1, 0)
	fmt.Println(ps.AddCar(1))
	fmt.Println(ps.AddCar(1))
	fmt.Println(ps.AddCar(1))
}
