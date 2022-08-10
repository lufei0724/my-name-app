package com.myob.mynameapp.user

import com.myob.mynameapp.user.UserDB.users

trait UserRepo {
  def getAllUsers: List[User]
}

object UserRepo {
  def getAllUsers: List[User] = users.toList.map(_._2)
}
