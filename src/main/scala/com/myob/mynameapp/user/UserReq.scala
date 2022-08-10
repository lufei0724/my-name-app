package com.myob.mynameapp.user

import cats.Applicative
import cats.implicits.catsSyntaxApplicativeId

trait UserReq[F[_]] {
  def getAll: F[List[User]]
}

object UserReq {
  implicit def apply[F[_]](implicit ev: UserReq[F]): UserReq[F] = ev

  def impl[F[_] : Applicative]: UserReq[F] = new UserReq[F] {
    def getAll: F[List[User]] = UserRepo.getAllUsers.pure[F]
  }
}