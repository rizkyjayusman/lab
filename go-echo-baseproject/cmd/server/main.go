package main

import (
	"database/sql"
	"go-echo-baseproject/internal"
	"go-echo-baseproject/internal/user/repo"
	"go-echo-baseproject/internal/user/service"
	"go-echo-baseproject/pkg/database"
	"log"

	"github.com/labstack/echo/v4"
)

func main() {
	e := echo.New()
	dsn := "host=localhost user=baseuser password=basepass dbname=basedb port=5433 sslmode=disable"
	db, err := database.InitDB(dsn)
	if err != nil {
		log.Fatal(err)
	}
	defer func(db *sql.DB) {
		err := db.Close()
		if err != nil {
			log.Fatal(err)
		}
	}(db)

	userRepo := repo.NewUserRepository(db)
	userService := service.NewUserService(userRepo)
	internal.RegisterRoutes(e, userService)
	e.Logger.Fatal(e.Start(":8080"))
}
