package main

type GarbageCollector struct{}

func (gc GarbageCollector) GarbageCollection(garbage []string, travel []int) int {
	steps := make([]int, len(garbage))
	for i := 1; i < len(steps); i++ {
		steps[i] = steps[i-1] + travel[i-1]
	}

	g, p, m := 0, 0, 0
	lastGIdx, lastPIdx, lastMIdx := 0, 0, 0
	for k, v := range garbage {
		for _, vv := range v {
			if vv == 'G' {
				g++
				lastGIdx = k
			} else if vv == 'M' {
				m++
				lastMIdx = k
			} else if vv == 'P' {
				p++
				lastPIdx = k
			}
		}
	}

	garbageSum := g + p + m
	travelSum := steps[lastGIdx] + steps[lastPIdx] + steps[lastMIdx]
	return garbageSum + travelSum
}
