package component

import "time"

type Task struct {
	ID        int8      `json:"id"`
	String    string    `json:"string"`
	CreatedAt time.Time `json:"created_at"`
}
