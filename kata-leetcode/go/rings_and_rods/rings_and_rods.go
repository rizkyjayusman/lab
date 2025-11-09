package main

import (
	"fmt"
)

func main() {
	fmt.Println(countPoints("B0B6G0R6R0R6G9"))
	fmt.Println(countPoints("B0R0G0R9R0B0G0"))
	fmt.Println(countPoints("G4"))
	fmt.Println(countPoints("G3R3R7B7R5B1G8G4B3G6"))
	fmt.Println(countPoints("B9R9G0R4G6R8R2R9G9"))
}

func countPoints(rings string) int {
	if len(rings) < 2 {
		return 0
	}

	m := make(map[byte]map[byte]struct{})
	res := make(map[byte]struct{})

	i, j := 0, 1
	for j <= len(rings)-1 {
		o, err := m[rings[j]]
		if !err {
			o = make(map[byte]struct{})
		}

		o[rings[i]] = struct{}{}

		_, exist := res[rings[j]]
		if !exist {
			_, isRExist := o['R']
			_, isGExist := o['G']
			_, isBExist := o['B']
			if isBExist && isGExist && isRExist {
				res[rings[j]] = struct{}{}
			}
		}

		m[rings[j]] = o
		i += 2
		j += 2
	}

	return len(res)
}
