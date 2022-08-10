package com.myob.mynameapp.user

import cats.effect.Sync
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import io.circe.syntax._
import org.http4s.circe._

object UserRoutes {
  def userRoutes[F[_]: Sync](H: UserReq[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F]{}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "users" =>
        for {
          users <- H.getAll
          resp <- Ok(users.asJson)
        } yield resp
    }
  }
}
