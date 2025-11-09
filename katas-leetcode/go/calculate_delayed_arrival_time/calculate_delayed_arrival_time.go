package main

type TrainScheduler struct{}

func (ts TrainScheduler) FindDelayedArrivalTime(arrivalTime int, delayedTime int) int {
	return (arrivalTime + delayedTime) % 24
}
