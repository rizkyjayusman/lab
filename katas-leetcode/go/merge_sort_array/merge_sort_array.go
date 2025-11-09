package main

import "fmt"

func main() {
	case1 := []int{1, 2, 3, 0, 0, 0}
	merge(case1, 3, []int{2, 5, 6}, 3)
	// case2 := []int{1}
	// merge(case2, 1, []int{}, 0)
	// case3 := []int{0}
	// merge(case3, 0, []int{1}, 1)
}

func merge(nums1 []int, m int, nums2 []int, n int) {
	j := 0
	i := 0
	for i < m+n && j < n {
		if nums1[i] > nums2[j] {
			tmp := nums1[i]
			nums1[i] = nums2[j]
			if i+1 < m+n {
				nums1[i+1] = tmp
			}
			j++
		}

		i++
	}

	fmt.Println(nums1)
}
