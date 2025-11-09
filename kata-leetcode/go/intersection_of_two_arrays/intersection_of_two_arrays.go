package main

import "fmt"

func main() {
	fmt.Println(intersection([]int{1, 2, 2, 1}, []int{2, 2}))
	// fmt.Println(intersection([]int{4, 9, 5}, []int{9, 4, 9, 8, 4}))
	// fmt.Println(intersection([]int{61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12, 86, 58, 77, 30, 64, 46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30, 67, 34, 62, 35, 47, 98, 3, 41, 53, 26, 66, 40, 54, 44, 57, 46, 70, 60, 4, 63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82, 66, 98, 6, 92, 31, 43, 81, 88, 60, 10, 55, 66, 82, 0, 79, 11, 81},
	// 	[]int{5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92, 84, 38, 85, 34, 16, 6, 99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48}))
}

func intersection(nums1 []int, nums2 []int) []int {
	if len(nums1) < len(nums2) {
		return intersect(nums1, nums2)
	}
	return intersect(nums2, nums1)
}

func intersect(a []int, b []int) []int {
	z := make(map[int]bool)
	for _, itemA := range a {
		fmt.Println(itemA)
		if _, ok := z[itemA]; ok {
			continue
		}

		for _, itemB := range b {
			if itemA == itemB {
				z[itemA] = true
				break
			}
		}
	}

	var arr []int
	for k := range z {
		arr = append(arr, k)
	}

	return arr
}
