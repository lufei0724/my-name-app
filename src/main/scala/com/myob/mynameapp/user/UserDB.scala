package com.myob.mynameapp.user

import java.util.UUID
import scala.collection.mutable

object UserDB {

  val users: mutable.HashMap[UUID, User] = mutable.HashMap.empty[UUID, User]
  private val id1 = UUID.randomUUID()
  private val id2 = UUID.randomUUID()
  private val user1: User = User(id1, "Peter", "Murphy", 36)
  private val user2: User = User(id2, "Matt", "Lu", 37)
  users += (user1.id -> user1)
  users += (user2.id -> user2)

}
