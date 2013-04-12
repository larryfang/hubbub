package com.grailsinaction

class User {
    String userId
    String password
    String homepage
    Profile profile
    Date dateCreated
    static constraints = {
        userId(size: 3..20, unique: true)
        password(size:6..8, validator: { passwd, user ->
                        passwd != user.userId
        })
        dateCreated()
        profile(nullable: true)
        homepage(url: true, nullable: true)
    }
    static mapping = {profile lazy:true}
    static hasMany = [posts: Post]
}
