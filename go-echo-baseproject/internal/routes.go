package internal

import (
	helloHandler "go-echo-baseproject/internal/hello/handler"
	userHandler "go-echo-baseproject/internal/user/handler"
	"go-echo-baseproject/internal/user/service"

	"github.com/labstack/echo/v4"
)

func RegisterRoutes(e *echo.Echo, userService service.UserService) {
	userApi := userHandler.NewUserHandler(userService)
	helloApi := helloHandler.NewHelloHandler()

	apiV1 := e.Group("/handler/v1")
	apiV1.GET("/users", userApi.GetAll)
	apiV1.GET("/users/:id", userApi.GetUser)
	apiV1.GET("/", helloApi.Hello)
}
