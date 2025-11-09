package main

import "fmt"

type CellInRangeOnAExcelSheet struct{}

func (ciroes CellInRangeOnAExcelSheet) CellsInRange(s string) []string {
	i := s[0]
	j := s[3]
	var str []string
	for i <= j {
		x := s[1]
		y := s[4]
		for x <= y {
			str = append(str, fmt.Sprintf("%c%c", rune(i), x))
			x++
		}
		i++
	}

	return str
}
