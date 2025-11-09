package main

type Grid struct{}

func (g Grid) ExecuteInstructions(n int, startPos []int, s string) []int {
	var steps []int

	count := 0
	instructionPos := 0
	r := startPos[0]
	c := startPos[1]
	for instructionPos < len(s) {
		isMoved := true
		if s[instructionPos] == 'U' && r-1 >= 0 {
			r--
		} else if s[instructionPos] == 'L' && c-1 >= 0 {
			c--
		} else if s[instructionPos] == 'R' && c+1 < n {
			c++
		} else if s[instructionPos] == 'D' && r+1 < n {
			r++
		} else {
			isMoved = false
		}

		if isMoved {
			count++
		}

		if !isMoved || instructionPos == len(s)-1 {
			steps = append(steps, count)
			instructionPos = len(steps)
			r = startPos[0]
			c = startPos[1]
			count = 0
			continue
		}

		instructionPos++
	}

	return steps
}
