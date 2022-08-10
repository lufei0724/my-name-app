package com.myob.mynameapp.user

import io.circe.{Encoder, Json}
import org.http4s.EntityEncoder
import org.http4s.circe.jsonEncoderOf

import java.util.UUID

case class User(id: UUID, firstName: String, lastName: String, age: Int)

object User {
  implicit val UserEncoder: Encoder[User] = new Encoder[User] {
    final def apply(a: User): Json = Json.obj(
      ("firstName", Json.fromString(a.firstName)),
      ("lastName", Json.fromString(a.lastName)),
      ("age", Json.fromInt(a.age))
    )
  }

  implicit def userEntityEncoder[F[_]]: EntityEncoder[F, User] =
    jsonEncoderOf[F, User]
}
